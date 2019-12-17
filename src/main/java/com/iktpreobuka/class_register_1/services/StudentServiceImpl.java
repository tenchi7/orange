package com.iktpreobuka.class_register_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.StudentEntity;
import com.iktpreobuka.class_register_1.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<StudentEntity> findAllStudents() {

		return (List<StudentEntity>) studentRepo.findAll();
	}

	@Override
	public StudentEntity findStudentById(Integer id) {

		return studentRepo.findById(id).get();
	}

	@Override
	public StudentEntity saveStudent(StudentEntity student) {

		return studentRepo.save(student);
	}

	@Override
	public StudentEntity updateStudentById(Integer id, StudentEntity updateStudent) {

		StudentEntity student = studentRepo.findById(id).get();

		student.setFirstName(updateStudent.getFirstName());
		student.setLastName(updateStudent.getLastName());
		student.setSchoolClass(updateStudent.getSchoolClass());
		student.setParent(updateStudent.getParent());

		return student;
	}

	@Override
	public StudentEntity deleteStudentById(Integer id) {

		StudentEntity student = studentRepo.findById(id).get();

		studentRepo.delete(student);

		return student;
	}
	
}
