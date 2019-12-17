package com.iktpreobuka.class_register_1.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.SubjectEntity;
import com.iktpreobuka.class_register_1.entities.TeacherEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;
import com.iktpreobuka.class_register_1.repositories.TeacherSubjectRepository;




@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectService {
	
	@Autowired
	private TeacherSubjectRepository teachSubRepo;
	
	@Override
	public List<TeacherSubjectEntity> findAllTeacherSubjectsForTeacher(Integer teacherId) {
		
		List<TeacherSubjectEntity> teachSubs = new ArrayList<>();
		for (TeacherSubjectEntity teacherSubject : teachSubs) {
			if (teacherSubject.getTeacher().getId().equals(teacherId)) {
				teachSubs.add(teacherSubject);
			}
		}
		return teachSubs;
	}
	
	@Override
	public List<TeacherSubjectEntity> findAllTeacherSubjectsForSubject(Integer subjectId) {
		
		List<TeacherSubjectEntity> teachSubs = new ArrayList<>();
		for (TeacherSubjectEntity teacherSubject : teachSubs) {
			if (teacherSubject.getSubject().getId().equals(subjectId)) {
				teachSubs.add(teacherSubject);
			}
		}
		return teachSubs;
	}
	
	@Override
	public TeacherSubjectEntity saveTeacherSubject(TeacherSubjectEntity teacherSubject) {
		
		return teachSubRepo.save(teacherSubject); 
	}

	@Override
	public TeacherSubjectEntity findTeacherSubjectById(Integer id) {
		
		return teachSubRepo.findById(id).get();
	}

	@Override
	public List<TeacherSubjectEntity> findByTeacher(TeacherEntity teacher) {
		
		return teachSubRepo.findByTeacher(teacher);
	}

	@Override
	public List<SubjectEntity> findSubjectsByTeacherId(Integer teacherId) {

		List<SubjectEntity> teacherSubjects = teachSubRepo.findByTeacherId(teacherId);
		
		return teacherSubjects;
	}

	@Override
	public TeacherSubjectEntity deleteTeacherSubjectById(Integer id) {

		TeacherSubjectEntity teacherSubject = teachSubRepo.findById(id).get();
		teachSubRepo.deleteById(id);
		
		return teacherSubject;
	}

	@Override
	public TeacherSubjectEntity findTeacherSubjectByTeacherAndSubject(TeacherEntity teacher, SubjectEntity subject) {

		return teachSubRepo.findByTeacherAndSubject(teacher, subject);
	}
	
}
