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
import com.iktpreobuka.class_register_1.entities.SchoolClassEntity;
import com.iktpreobuka.class_register_1.entities.StudentEntity;
import com.iktpreobuka.class_register_1.entities.dto.ParentDTO;
import com.iktpreobuka.class_register_1.entities.dto.SchoolClassDTO;
import com.iktpreobuka.class_register_1.entities.dto.StudentDTO;
import com.iktpreobuka.class_register_1.services.ParentService;
import com.iktpreobuka.class_register_1.services.SchoolClassService;
import com.iktpreobuka.class_register_1.services.StudentService;
import com.iktpreobuka.class_register_1.utilities.RESTError;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studServ;

	@Autowired
	private ParentService parentServ;

	@Autowired
	private SchoolClassService classServ;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllStudents() {

		try {
			List<StudentEntity> students = studServ.findAllStudents();
			List<StudentDTO> studentDtos = new ArrayList<>();

			if (students != null) {

				for (StudentEntity student : students) {
					StudentDTO studentDto = new StudentDTO(student.getId(), student.getFirstName(),
							student.getLastName());
					studentDtos.add(studentDto);
				}
				return new ResponseEntity<List<StudentDTO>>(studentDtos, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "No students found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {

		try {
			StudentEntity student = studServ.findStudentById(id);

			if (studServ.findStudentById(id) == null) {
				return new ResponseEntity<RESTError>(new RESTError(1, "Student not found."), HttpStatus.NOT_FOUND);
			}

			ParentEntity parent = student.getParent();
			SchoolClassEntity schoolClass = student.getSchoolClass();

			ParentDTO parentDto = new ParentDTO(parent.getId(), parent.getFirstName(), parent.getLastName(),
					parent.getEmail());
			SchoolClassDTO schoolClassDto = new SchoolClassDTO(schoolClass.getId(), schoolClass.getYear(),
					schoolClass.getSection());
			StudentDTO studentDto = new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(),
					parentDto, schoolClassDto);

			return new ResponseEntity<StudentDTO>(studentDto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewStudent(@Valid @RequestBody StudentDTO studentDto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(studentDto, HttpStatus.BAD_REQUEST);
		}

		try {
			StudentEntity student = new StudentEntity(studentDto.getFirstName(),
					studentDto.getLastName());
			studServ.saveStudent(student);

			StudentDTO returnStudentDto = new StudentDTO(student.getId(), student.getFirstName(),
					student.getLastName());

			return new ResponseEntity<StudentDTO>(returnStudentDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<?> updateStudent(@Valid @RequestBody StudentDTO studentDto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(studentDto, HttpStatus.BAD_REQUEST);
		}

		try {
			StudentEntity student = studServ.findStudentById(studentDto.getId());

			student.setFirstName(studentDto.getFirstName());
			student.setLastName(studentDto.getLastName());

			studServ.saveStudent(student);

			StudentDTO returnStudentDto = new StudentDTO(student.getId(), student.getFirstName(),
					student.getLastName());

			return new ResponseEntity<StudentDTO>(returnStudentDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Dodaje postojećeg roditelja postojećem učeniku
	@RequestMapping(method = RequestMethod.PUT, path = "/{studentId}/addParent")
	public ResponseEntity<?> addParentToStudent(@PathVariable Integer parentId, Integer studentId) {

		try {
			StudentEntity student = studServ.findStudentById(studentId);
			ParentEntity parent = parentServ.findParentById(parentId);

			student.setParent(parent);

			ParentDTO returnParentDto = new ParentDTO(parent.getId(), parent.getFirstName(), parent.getLastName(),
					parent.getEmail());

			StudentDTO returnStudentDto = new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(),
					returnParentDto);

			return new ResponseEntity<StudentDTO>(returnStudentDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Dodaje učenika u neki od postojećih razreda
	@RequestMapping(method = RequestMethod.PUT, path = "/{studentId}/addSchoolClass")
	public ResponseEntity<?> addSchoolClassToStudent(@PathVariable Integer studentId, Integer classId) {

		try {
			StudentEntity student = studServ.findStudentById(studentId);
			SchoolClassEntity schoolClass = classServ.findSchoolClassById(classId);

			student.setSchoolClass(schoolClass);

			SchoolClassDTO returnSchoolClassDto = new SchoolClassDTO(schoolClass.getId(), schoolClass.getYear(),
					schoolClass.getSection());

			StudentDTO returnStudentDto = new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(),
					returnSchoolClassDto);

			return new ResponseEntity<StudentDTO>(returnStudentDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {

		try {
			StudentEntity student = studServ.findStudentById(id);

			if (student != null) {

				studServ.deleteStudentById(id);

				StudentDTO returnStudentDto = new StudentDTO(student.getId(), student.getFirstName(),
						student.getLastName());

				return new ResponseEntity<StudentDTO>(returnStudentDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "Student not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
