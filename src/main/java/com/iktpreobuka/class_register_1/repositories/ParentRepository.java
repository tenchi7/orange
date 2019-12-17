package com.iktpreobuka.class_register_1.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.class_register_1.entities.ParentEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Integer> {
	
	public ParentEntity findByEmail(String email);

}
