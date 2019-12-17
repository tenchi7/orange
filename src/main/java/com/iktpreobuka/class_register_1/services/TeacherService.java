package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.TeacherEntity;

public interface TeacherService {

	public List<TeacherEntity> findAllTeachers();

	public TeacherEntity findTeacherById(Integer id);

	public TeacherEntity saveTeacher(TeacherEntity teacher);

	public TeacherEntity updateTeacherById(Integer id, TeacherEntity updateTeacher);

	public TeacherEntity deleteTeacherById(Integer id);

}
