package com.iktpreobuka.class_register_1.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TeacherEntity extends PersonEntity {

	@JsonBackReference
	@OneToMany(mappedBy = "teacher")
	private List<TeacherSubjectEntity> ts;

	public TeacherEntity() {
		super();
	}
	
	public TeacherEntity(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public TeacherEntity(List<TeacherSubjectEntity> ts) {
		super();
		this.ts = ts;
	}

	public List<TeacherSubjectEntity> getTs() {
		return ts;
	}

	public void setTs(List<TeacherSubjectEntity> ts) {
		this.ts = ts;
	}

}
