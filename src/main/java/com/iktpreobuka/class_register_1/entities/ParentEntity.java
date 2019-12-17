package com.iktpreobuka.class_register_1.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ParentEntity extends PersonEntity {

	@Column(unique = true)
	private String email;

	@JsonBackReference
	@OneToMany(mappedBy = "parent")
	private List<StudentEntity> students;

	public ParentEntity() {
		super();
	}

	public ParentEntity(String email, List<StudentEntity> students) {
		super();
		this.email = email;
		this.students = students;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

}
