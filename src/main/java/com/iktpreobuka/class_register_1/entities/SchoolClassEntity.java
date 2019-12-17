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
public class SchoolClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version = 1;
	private Integer year;
	private Integer section;

	@JsonBackReference
	@OneToMany(mappedBy = "schoolClass")
	private List<StudentEntity> students;

	@JsonBackReference
	@OneToMany(mappedBy = "schoolClass")
	private List<TeacherSubjectClassEntity> tscs;

	public SchoolClassEntity() {
		super();
	}

	public SchoolClassEntity(Integer year, Integer section) {
		super();
		this.year = year;
		this.section = section;
	}

	public SchoolClassEntity(Integer id, Integer year, Integer section, List<StudentEntity> students,
			List<TeacherSubjectClassEntity> tscs) {
		super();
		this.id = id;
		this.year = year;
		this.section = section;
		this.students = students;
		this.tscs = tscs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSection() {
		return section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	public List<TeacherSubjectClassEntity> getTscs() {
		return tscs;
	}

	public void setTscs(List<TeacherSubjectClassEntity> tscs) {
		this.tscs = tscs;
	}

}
