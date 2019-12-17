package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.ParentEntity;


public interface ParentService {
	
	public List<ParentEntity> findAllParents();
	
	public ParentEntity findParentById(Integer id);
	
	public ParentEntity findParentByEmail(String email);
	
	public ParentEntity saveParent(ParentEntity parent);
	
	public ParentEntity updateParentById(Integer id, ParentEntity updateParent);
	
	public ParentEntity deleteParentById(Integer id);

}
