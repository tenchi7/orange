package com.iktpreobuka.class_register_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.UserEntity;
import com.iktpreobuka.class_register_1.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<UserEntity> getAllUsers() {
			
		return (List<UserEntity>) userRepo.findAll();
	}

	@Override
	public UserEntity findUserByUsername(String username) {
		
		return userRepo.findUserByUsername(username);
	}

	@Override
	public UserEntity saveUser(UserEntity newUser) {
		
		return userRepo.save(newUser);
	}

	@Override
	public UserEntity changePassword(Integer id, String oldPassword, String newPassword) {
		
		UserEntity user = userRepo.findById(id).get();
		if (oldPassword == user.getPassword()) {
			user.setPassword(newPassword);
		}	
		return user;
	}

	@Override
	public UserEntity deleteUserByUsername(String username) {

		UserEntity user = userRepo.findUserByUsername(username);
		userRepo.delete(user);
		return user;
	}

}
