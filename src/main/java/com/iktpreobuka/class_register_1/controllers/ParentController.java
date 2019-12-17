package com.iktpreobuka.class_register_1.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.class_register_1.entities.ParentEntity;
import com.iktpreobuka.class_register_1.entities.StudentEntity;
import com.iktpreobuka.class_register_1.entities.dto.ParentDTO;
import com.iktpreobuka.class_register_1.services.ParentService;
import com.iktpreobuka.class_register_1.services.StudentService;
import com.iktpreobuka.class_register_1.utilities.RESTError;

@RestController
@RequestMapping("/api/v1/parents")
@CrossOrigin
public class ParentController {
	
	@Autowired
	ParentService parentServ;
	
	@Autowired
	StudentService studentServ;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllParents() {

		try {

			List<ParentEntity> parents = parentServ.findAllParents();
			List<ParentDTO> parentDtos = new ArrayList<>();

			if (parents != null) {

				for (ParentEntity parent : parents) {
					ParentDTO parentDto = new ParentDTO(parent.getId(), parent.getFirstName(), parent.getLastName(),
							parent.getEmail());
					parentDtos.add(parentDto);
				}
				return new ResponseEntity<List<ParentDTO>>(parentDtos, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "No parents found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getParentById(@PathVariable Integer id) {

		try {

			ParentEntity parent = parentServ.findParentById(id);

			if (parent != null) {

				ParentDTO returnParentDto = new ParentDTO(parent.getId(), parent.getFirstName(), parent.getLastName(),
						parent.getEmail());

				return new ResponseEntity<ParentDTO>(returnParentDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "Parent not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewParent(@Valid @RequestBody ParentDTO parentDto, BindingResult result) {
		
		if (result.hasErrors()) {
			return new ResponseEntity<>(parentDto, HttpStatus.BAD_REQUEST);
		}

		try {

			ParentEntity parent = new ParentEntity();

			parent.setFirstName(parentDto.getFirstName());
			parent.setLastName(parentDto.getLastName());
			parent.setEmail(parentDto.getEmail());

			parentServ.saveParent(parent);

			ParentDTO returnParentDto = new ParentDTO(parent.getId(), parent.getFirstName(), parent.getLastName(),
					parent.getEmail());

			return new ResponseEntity<ParentDTO>(returnParentDto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteParent(@PathVariable Integer id) {

		try {

			ParentEntity parent = parentServ.findParentById(id);

			if (parent != null) {

				parentServ.deleteParentById(id);

				ParentDTO returnParentDto = new ParentDTO(parent.getId(), parent.getFirstName(), parent.getLastName(),
						parent.getEmail());

				return new ResponseEntity<ParentDTO>(returnParentDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "Parent not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/{id}/student/{studentId}")
	public ResponseEntity<?> addStudent(@PathVariable Integer id, Integer studentId) {
		

		try {

			ParentEntity parent = parentServ.findParentById(id);
			StudentEntity student = studentServ.findStudentById(studentId);
			List<StudentEntity> students = parent.getStudents();

			students.add(student);

			parentServ.saveParent(parent);

			ParentDTO returnParentDto = new ParentDTO(parent.getId(), parent.getFirstName(), parent.getLastName(),
					parent.getEmail());

			return new ResponseEntity<ParentDTO>(returnParentDto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
