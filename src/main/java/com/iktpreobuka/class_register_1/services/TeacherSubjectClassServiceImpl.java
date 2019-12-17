package com.iktpreobuka.class_register_1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.SchoolClassEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectClassEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;
import com.iktpreobuka.class_register_1.repositories.TeacherSubjectClassRepository;

@Service
public class TeacherSubjectClassServiceImpl implements TeacherSubjectClassService {

	@Autowired
	private TeacherSubjectClassRepository tscRepo;

	@Override
	public TeacherSubjectClassEntity saveTeacherSubjectClass(TeacherSubjectClassEntity teachSubClass) {

		return tscRepo.save(teachSubClass);
	}

	@Override
	public List<SchoolClassEntity> findByTeacherSubject(TeacherSubjectEntity teacherSubject) {

		List<SchoolClassEntity> schoolClasses = new ArrayList<>();

		for (TeacherSubjectClassEntity tsc : tscRepo.findByTeacherSubject(teacherSubject)) {
			SchoolClassEntity schoolClass = tsc.getSchoolClass();
			schoolClasses.add(schoolClass);
		}

		return schoolClasses;
	}

	@Override
	public TeacherSubjectClassEntity findByTeacherSubjectAndSchoolCLass(TeacherSubjectEntity teacherSubject,
			SchoolClassEntity schoolClass) {

		TeacherSubjectClassEntity tsc = tscRepo.findByTeacherSubjectAndSchoolClass(teacherSubject, schoolClass);

		return tsc;
	}

}
