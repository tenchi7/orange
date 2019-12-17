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

import com.iktpreobuka.class_register_1.entities.SubjectEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;
import com.iktpreobuka.class_register_1.entities.dto.SubjectDTO;
import com.iktpreobuka.class_register_1.services.SubjectService;
import com.iktpreobuka.class_register_1.services.TeacherSubjectService;
import com.iktpreobuka.class_register_1.utilities.RESTError;

@RestController
@RequestMapping("/api/v1/subjects")
@CrossOrigin
public class SubjectController {

	@Autowired
	private SubjectService subServ;
	
	@Autowired
	private TeacherSubjectService teachSubServ;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllSubjects() {
		try {
			List<SubjectEntity> subjects = subServ.findAllSubjects();
			List<SubjectDTO> subjectDtos = new ArrayList<>();

			if (subjects != null) {

				for (SubjectEntity subject : subjects) {
					SubjectDTO subjectDto = new SubjectDTO(subject.getId(), subject.getName());
					subjectDtos.add(subjectDto);
				}
				return new ResponseEntity<List<SubjectDTO>>(subjectDtos, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "No subjects found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getSubjectById(@PathVariable Integer id) {

		try {

			SubjectEntity subject = subServ.findSubjectById(id);

			if (subject != null) {
				SubjectDTO subjectDto = new SubjectDTO(subject.getId(), subject.getName());
				return new ResponseEntity<SubjectDTO>(subjectDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "Subject not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewSubject(@Valid @RequestBody SubjectDTO subjectDto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(subjectDto, HttpStatus.BAD_REQUEST);
		}

		try {
			SubjectEntity subject = new SubjectEntity();
			subject.setName(subjectDto.getName());
			subServ.saveSubject(subject);

			SubjectDTO returnSubjectDto = new SubjectDTO(subject.getId(), subject.getName());

			return new ResponseEntity<SubjectDTO>(returnSubjectDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<?> updateSubjectById(@Valid @RequestBody SubjectDTO subjectDto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(subjectDto, HttpStatus.BAD_REQUEST);
		}

		try {
			SubjectEntity subject = subServ.findSubjectById(subjectDto.getId());

			subject.setName(subjectDto.getName());
			subServ.saveSubject(subject);

			SubjectDTO returnSubjectDto = new SubjectDTO(subject.getId(), subject.getName());

			return new ResponseEntity<SubjectDTO>(returnSubjectDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Pribavlja sve predmete koje predaje neki nastavnik
	@RequestMapping(method = RequestMethod.GET, path = "/teacher/{teacherId}")
	public ResponseEntity<?> getAllSubjectsForTeacher(@PathVariable Integer teacherId) {
		try {

			List<TeacherSubjectEntity> teachSubs = teachSubServ.findAllTeacherSubjectsForTeacher(teacherId);

			if (!teachSubs.isEmpty()) {

				List<SubjectEntity> subjects = new ArrayList<>();

				for (TeacherSubjectEntity teachSub : teachSubs) {
					SubjectEntity subject = teachSub.getSubject();
					subjects.add(subject);
				}

				List<SubjectDTO> subjectDtos = new ArrayList<>();

				for (SubjectEntity subject : subjects) {
					SubjectDTO subjectDto = new SubjectDTO(subject.getId(), subject.getName());
					subjectDtos.add(subjectDto);
				}
				return new ResponseEntity<List<SubjectDTO>>(subjectDtos, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "No subjects found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
