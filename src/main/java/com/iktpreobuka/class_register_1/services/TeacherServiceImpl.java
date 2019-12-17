package com.iktpreobuka.class_register_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.TeacherEntity;
import com.iktpreobuka.class_register_1.repositories.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherRepository teachRepo;

	@Override
	public List<TeacherEntity> findAllTeachers() {
		
		return (List<TeacherEntity>) teachRepo.findAll();
	}

	@Override
	public TeacherEntity findTeacherById(Integer id) {
		
		return teachRepo.findById(id).get();
	}

	@Override
	public TeacherEntity saveTeacher(TeacherEntity teacher) {
		
		return teachRepo.save(teacher);
	}

	@Override
	public TeacherEntity updateTeacherById(Integer id, TeacherEntity updateTeacher) {
		TeacherEntity teacher = teachRepo.findById(id).get();
		teacher.setFirstName(updateTeacher.getFirstName());
		teacher.setLastName(updateTeacher.getLastName());

		return teacher;
	}

	@Override
	public TeacherEntity deleteTeacherById(Integer id) {

		TeacherEntity teacher = teachRepo.findById(id).get();
		teachRepo.deleteById(id);

		return teacher;
	}
	
	

}
