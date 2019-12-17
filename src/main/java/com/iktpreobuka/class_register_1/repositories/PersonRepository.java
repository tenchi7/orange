package com.iktpreobuka.class_register_1.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.class_register_1.entities.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer>{

}
