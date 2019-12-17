package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.StudentEntity;

public interface StudentService {
	
	public List<StudentEntity> findAllStudents();
	
	public StudentEntity findStudentById(Integer id);
	
	public StudentEntity saveStudent(StudentEntity student);
	
	public StudentEntity updateStudentById(Integer id, StudentEntity updateStudent);
	
	public StudentEntity deleteStudentById(Integer id);

}
