package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.SchoolClassEntity;


public interface SchoolClassService {
	
	public List<SchoolClassEntity> findAllSchoolClasses();
	
	public SchoolClassEntity findSchoolClassById(Integer id);
	
	public SchoolClassEntity addNewSchoolClass(SchoolClassEntity schoolClass);
	
	public SchoolClassEntity updateSchoolClassById(Integer id, SchoolClassEntity updateSchoolClass);
	
	public SchoolClassEntity deleteSchoolClassById(Integer id);

}
