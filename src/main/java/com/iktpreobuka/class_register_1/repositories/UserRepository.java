package com.iktpreobuka.class_register_1.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.class_register_1.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	
	public UserEntity findUserByUsername(String username);

}
