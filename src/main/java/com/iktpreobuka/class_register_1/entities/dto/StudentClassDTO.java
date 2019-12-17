package com.iktpreobuka.class_register_1.entities.dto;

import javax.validation.constraints.NotNull;

public class StudentClassDTO {

	@NotNull(message = "Student must be provided.")
	private StudentDTO studentDto;
	@NotNull(message = "School class must be provided.")
	private SchoolClassDTO schoolClassDto;

	public StudentClassDTO() {
		super();
	}

	public StudentClassDTO(@NotNull(message = "Student must be provided.") StudentDTO studentDto,
			@NotNull(message = "School class must be provided.") SchoolClassDTO schoolClassDto) {
		super();
		this.studentDto = studentDto;
		this.schoolClassDto = schoolClassDto;
	}

	public StudentDTO getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDTO studentDto) {
		this.studentDto = studentDto;
	}

	public SchoolClassDTO getSchoolClassDto() {
		return schoolClassDto;
	}

	public void setSchoolClassDto(SchoolClassDTO schoolClassDto) {
		this.schoolClassDto = schoolClassDto;
	}

}
