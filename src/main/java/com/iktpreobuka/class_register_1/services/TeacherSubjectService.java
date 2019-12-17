package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.SubjectEntity;
import com.iktpreobuka.class_register_1.entities.TeacherEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;


public interface TeacherSubjectService {
	
	public List<TeacherSubjectEntity> findAllTeacherSubjectsForTeacher(Integer teacherId);

	public List<TeacherSubjectEntity> findAllTeacherSubjectsForSubject(Integer subjectId);
	
	public TeacherSubjectEntity findTeacherSubjectById(Integer id);
	
	public TeacherSubjectEntity findTeacherSubjectByTeacherAndSubject(TeacherEntity teacher, SubjectEntity subject);
	
	public List<TeacherSubjectEntity> findByTeacher(TeacherEntity teacher);
	
	public List<SubjectEntity> findSubjectsByTeacherId(Integer teacherId);
	
	public TeacherSubjectEntity saveTeacherSubject(TeacherSubjectEntity teacherSubject);
	
	public TeacherSubjectEntity deleteTeacherSubjectById(Integer id);

}
