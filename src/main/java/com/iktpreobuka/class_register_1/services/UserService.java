package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.UserEntity;

public interface UserService {
	
	public List<UserEntity> getAllUsers();
	
	public UserEntity findUserByUsername(String username);
	
	public UserEntity saveUser(UserEntity newUser);
	
	public UserEntity changePassword(Integer id, String oldPassword, String newPassword);
	
	public UserEntity deleteUserByUsername(String username);

}
