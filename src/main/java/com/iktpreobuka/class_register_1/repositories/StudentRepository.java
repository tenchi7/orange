package com.iktpreobuka.class_register_1.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.class_register_1.entities.StudentEntity;

public interface StudentRepository  extends CrudRepository<StudentEntity, Integer>{

}
