package com.iktpreobuka.class_register_1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.ParentEntity;
import com.iktpreobuka.class_register_1.entities.PersonEntity;
import com.iktpreobuka.class_register_1.entities.StudentEntity;
import com.iktpreobuka.class_register_1.entities.TeacherEntity;
import com.iktpreobuka.class_register_1.entities.UserEntity;
import com.iktpreobuka.class_register_1.enumerations.EUserRole;
import com.iktpreobuka.class_register_1.repositories.PersonRepository;
import com.iktpreobuka.class_register_1.repositories.UserRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void addUserAccountToPerson(Integer personId, UserEntity user) {
		
		PersonEntity person = personRepo.findById(personId).get();
		
		boolean isInstanceOfTeacher = person instanceof TeacherEntity;
		boolean isInstanceOfStudent = person instanceof StudentEntity;
		boolean isInstanceOfParent = person instanceof ParentEntity;
		
		if (isInstanceOfTeacher == true) {
			user.setRole(EUserRole.TEACHER);
		}
		else if (isInstanceOfStudent == true) {
			user.setRole(EUserRole.STUDENT);
		}
		else if (isInstanceOfParent == true) {
			user.setRole(EUserRole.PARENT);
		}
		
		person.setUser(user);

	}

}
