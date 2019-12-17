package com.iktpreobuka.class_register_1.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version = 1;
	private String name;
	
	@JsonBackReference
	@OneToMany(mappedBy = "subject")
	private List<TeacherSubjectEntity> teacherSubjects;

	public SubjectEntity() {
		super();
	}

	public SubjectEntity(Integer id, String name, List<TeacherSubjectEntity> teacherSubjects) {
		super();
		this.id = id;
		this.name = name;
		this.teacherSubjects = teacherSubjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TeacherSubjectEntity> getTeacherSubjects() {
		return teacherSubjects;
	}

	public void setTeachers(List<TeacherSubjectEntity> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
