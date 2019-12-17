package com.iktpreobuka.class_register_1.entities.dto;

import java.util.List;

public class SchoolClassDTO {

	private Integer id;

	private Integer year;

	private Integer section;

	private List<StudentDTO> students;

	public SchoolClassDTO() {
		super();
	}

	public SchoolClassDTO(Integer year, Integer section) {
		super();
		this.year = year;
		this.section = section;
	}

	public SchoolClassDTO(Integer id, Integer year, Integer section) {
		super();
		this.id = id;
		this.year = year;
		this.section = section;
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

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}

	public Integer getId() {
		return id;
	}

}
