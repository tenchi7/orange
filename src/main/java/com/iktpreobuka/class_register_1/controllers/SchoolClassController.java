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

import com.iktpreobuka.class_register_1.entities.SchoolClassEntity;
import com.iktpreobuka.class_register_1.entities.dto.SchoolClassDTO;
import com.iktpreobuka.class_register_1.services.SchoolClassService;
import com.iktpreobuka.class_register_1.utilities.RESTError;

@RestController
@RequestMapping("/api/v1/school_classes")
@CrossOrigin
public class SchoolClassController {
	
	@Autowired
	private SchoolClassService classServ;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllSchoolCLasses() {

		try {
			List<SchoolClassEntity> schoolClasses = classServ.findAllSchoolClasses();
			List<SchoolClassDTO> schoolClassDtos = new ArrayList<>();

			if (schoolClasses != null) {

				for (SchoolClassEntity schoolClass : schoolClasses) {
					SchoolClassDTO schoolClassDto = new SchoolClassDTO(schoolClass.getId(), schoolClass.getYear(), 
							schoolClass.getSection());
					schoolClassDtos.add(schoolClassDto);
				}
				return new ResponseEntity<List<SchoolClassDTO>>(schoolClassDtos, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "No school classes found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getSchoolClassById(@PathVariable Integer id) {

		try {
			SchoolClassEntity schoolClass = classServ.findSchoolClassById(id);

			if (schoolClass != null) {
				
				SchoolClassDTO schoolClassDto = new SchoolClassDTO(schoolClass.getId(), schoolClass.getYear(), 
						schoolClass.getSection());
				
				return new ResponseEntity<SchoolClassDTO>(schoolClassDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "School class not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewSchoolClass(@Valid @RequestBody SchoolClassDTO schoolClassDto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(schoolClassDto, HttpStatus.BAD_REQUEST);
		}

		try {
			SchoolClassEntity schoolClass = new SchoolClassEntity(schoolClassDto.getYear(),
					schoolClassDto.getSection());
			classServ.addNewSchoolClass(schoolClass);
			
			SchoolClassDTO returnSchoolClassDto = new SchoolClassDTO(schoolClass.getId(), schoolClass.getYear(), 
					schoolClass.getSection());


			return new ResponseEntity<SchoolClassDTO>(returnSchoolClassDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
