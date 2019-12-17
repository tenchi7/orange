package com.iktpreobuka.class_register_1.entities;

import javax.persistence.Entity;

@Entity
public class AdminEntity extends PersonEntity {
	
	public AdminEntity() {
		super();
	}

	public AdminEntity(Integer id, Integer version, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

}
