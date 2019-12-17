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
import com.iktpreobuka.class_register_1.entities.SubjectEntity;
import com.iktpreobuka.class_register_1.entities.TeacherEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectClassEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;
import com.iktpreobuka.class_register_1.entities.dto.SchoolClassDTO;
import com.iktpreobuka.class_register_1.entities.dto.SubjectDTO;
import com.iktpreobuka.class_register_1.entities.dto.TeacherDTO;
import com.iktpreobuka.class_register_1.entities.dto.TeacherSubjectClassDTO;
import com.iktpreobuka.class_register_1.entities.dto.TeacherSubjectDTO;
import com.iktpreobuka.class_register_1.services.SchoolClassService;
import com.iktpreobuka.class_register_1.services.SubjectService;
import com.iktpreobuka.class_register_1.services.TeacherService;
import com.iktpreobuka.class_register_1.services.TeacherSubjectClassService;
import com.iktpreobuka.class_register_1.services.TeacherSubjectService;
import com.iktpreobuka.class_register_1.utilities.RESTError;

@RestController
@RequestMapping("api/v1/teachers")
@CrossOrigin
public class TeacherController {

	@Autowired
	private TeacherService teachServ;

	@Autowired
	private SubjectService subServ;

	@Autowired
	private SchoolClassService classServ;

	@Autowired
	private TeacherSubjectService teachSubServ;

	@Autowired
	private TeacherSubjectClassService tscServ;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllTeachers() {

		try {
			List<TeacherEntity> teachers = teachServ.findAllTeachers();
			List<TeacherDTO> teacherDtos = new ArrayList<>();

			if (teachers != null) {

				for (TeacherEntity teacher : teachers) {
					TeacherDTO returnTeacherDto = new TeacherDTO(teacher.getId(), teacher.getFirstName(),
							teacher.getLastName());
					teacherDtos.add(returnTeacherDto);
				}
				return new ResponseEntity<List<TeacherDTO>>(teacherDtos, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "No teachers found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getTeacherById(@PathVariable Integer id) {

		try {

			TeacherEntity teacher = teachServ.findTeacherById(id);

			if (teacher != null) {
				TeacherDTO returnTeacherDto = new TeacherDTO(teacher.getId(), teacher.getFirstName(),
						teacher.getLastName());
				return new ResponseEntity<TeacherDTO>(returnTeacherDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "Teacher not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewTeacher(@Valid @RequestBody TeacherDTO teacherDto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(teacherDto, HttpStatus.BAD_REQUEST);
		}

		try {
			TeacherEntity teacher = new TeacherEntity(teacherDto.getFirstName(), teacherDto.getLastName());

			teachServ.saveTeacher(teacher);

			TeacherDTO returnTeacherDto = new TeacherDTO(teacher.getId(), teacher.getFirstName(),
					teacher.getLastName());

			return new ResponseEntity<TeacherDTO>(returnTeacherDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<?> updateTeacher(@Valid @RequestBody TeacherDTO teacherDto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(teacherDto, HttpStatus.BAD_REQUEST);
		}

		try {
			TeacherEntity teacher = teachServ.findTeacherById(teacherDto.getId());

			teacher.setFirstName(teacherDto.getFirstName());
			teacher.setLastName(teacherDto.getLastName());

			TeacherDTO returnTeacherDto = new TeacherDTO(teacher.getId(), teacher.getFirstName(),
					teacher.getLastName());

			return new ResponseEntity<TeacherDTO>(returnTeacherDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {

		try {

			TeacherEntity teacher = teachServ.findTeacherById(id);

			if (teacher != null) {

				teachServ.deleteTeacherById(id);

				TeacherDTO returnTeacherDto = new TeacherDTO(teacher.getId(), teacher.getFirstName(),
						teacher.getLastName());

				return new ResponseEntity<TeacherDTO>(returnTeacherDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "Teacher not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(method = RequestMethod.POST, path = "/subject")
	public ResponseEntity<?> addNewTeacherSubject(@Valid @RequestBody TeacherSubjectDTO teachSubDto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(teachSubDto, HttpStatus.BAD_REQUEST);
		}

		try {
			TeacherEntity teacher = teachServ.findTeacherById(teachSubDto.getTeacherDto().getId());
			SubjectEntity subject = subServ.findSubjectById(teachSubDto.getSubjectDto().getId());

			TeacherSubjectEntity teachSub = new TeacherSubjectEntity(teacher, subject);
			teachSubServ.saveTeacherSubject(teachSub);

			TeacherDTO returnTeacherDto = new TeacherDTO(teachSub.getTeacher().getFirstName(),
					teachSub.getTeacher().getLastName());
			SubjectDTO returnSubjectDto = new SubjectDTO(teachSub.getSubject().getName());
			TeacherSubjectDTO returnTeachSubDto = new TeacherSubjectDTO(returnTeacherDto, returnSubjectDto);

			return new ResponseEntity<TeacherSubjectDTO>(returnTeachSubDto, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/subject/{id}")
	public ResponseEntity<?> getTeacherSubjectById(@PathVariable Integer id) {

		try {
			TeacherSubjectEntity teachSub = teachSubServ.findTeacherSubjectById(id);

			if (teachSub != null) {
				TeacherDTO returnTeacherDto = new TeacherDTO(teachSub.getTeacher().getFirstName(),
						teachSub.getTeacher().getLastName());
				SubjectDTO returnSubjectDto = new SubjectDTO(teachSub.getSubject().getName());
				TeacherSubjectDTO returnTeachSubDto = new TeacherSubjectDTO(returnTeacherDto, returnSubjectDto);

				return new ResponseEntity<TeacherSubjectDTO>(returnTeachSubDto, HttpStatus.OK);
			}
			return new ResponseEntity<RESTError>(new RESTError(1, "Teacher-subject not found."), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// pribavlja sve predmete koje predaje neki nastavnik po njegovom id-u
	@RequestMapping(method = RequestMethod.GET, path = "/subjects/{id}")
	public ResponseEntity<?> getAllSubjects(@PathVariable Integer id) {
		try {
			List<SubjectEntity> subjects = new ArrayList<>();
			List<TeacherSubjectEntity> teachSubs = teachSubServ.findByTeacher(teachServ.findTeacherById(id));

			for (TeacherSubjectEntity teachSub : teachSubs) {
				subjects.add(teachSub.getSubject());
			}

			List<SubjectDTO> subjectDtos = new ArrayList<>();

			if (!subjects.isEmpty()) {

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

	@RequestMapping(method = RequestMethod.POST, path = "/subject/class")
	public ResponseEntity<?> addNewTeacherSubjectClass(@Valid @RequestBody TeacherSubjectClassDTO tscDto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(tscDto, HttpStatus.BAD_REQUEST);
		}

		try {
			TeacherEntity teacher = teachServ.findTeacherById(tscDto.getTeacherDto().getId());
			SubjectEntity subject = subServ.findSubjectById(tscDto.getSubjectDto().getId());
			TeacherSubjectEntity teachSub = teachSubServ.findTeacherSubjectByTeacherAndSubject(teacher, subject);
			SchoolClassEntity schoolClass = classServ.findSchoolClassById(tscDto.getSchoolClassDto().getId());

			TeacherSubjectClassEntity tsc = new TeacherSubjectClassEntity(teachSub, schoolClass);
			tscServ.saveTeacherSubjectClass(tsc);

			return new ResponseEntity<TeacherSubjectClassEntity>(tsc, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// pribavlja sve razrede kojima jedan nastavnik predaje određeni predmet
	@RequestMapping(method = RequestMethod.GET, path = "/{id}/teacher/{subjectId}/subject")
	public ResponseEntity<?> getSchoolClassesForTeacherSubject(@PathVariable Integer id, Integer subjectId) {
		try {
			List<SchoolClassDTO> scDtos = new ArrayList<>();
			TeacherEntity teacher = teachServ.findTeacherById(id);
			SubjectEntity subject = subServ.findSubjectById(subjectId);
			TeacherSubjectEntity teachSub = teachSubServ.findTeacherSubjectByTeacherAndSubject(teacher, subject);
			List<SchoolClassEntity> schoolClasses = tscServ.findByTeacherSubject(teachSub);

			for (SchoolClassEntity schoolClass : schoolClasses) {
				SchoolClassDTO schoolClassDto = new SchoolClassDTO(schoolClass.getId(), schoolClass.getYear(),
						schoolClass.getSection());
				scDtos.add(schoolClassDto);
			}

			return new ResponseEntity<List<SchoolClassDTO>>(scDtos, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
