package com.iktpreobuka.class_register_1.entities.dto;

import javax.validation.constraints.NotNull;

public class TeacherSubjectDTO {

	@NotNull(message = "Teacher must be provided.")
	private TeacherDTO teacherDto;
	@NotNull(message = "Subject must be provided.")
	private SubjectDTO subjectDto;

	public TeacherSubjectDTO() {
		super();
	}

	public TeacherSubjectDTO(@NotNull(message = "Teacher must be provided.") TeacherDTO teacherDto,
			@NotNull(message = "Subject must be provided.") SubjectDTO subjectDto) {
		super();
		this.teacherDto = teacherDto;
		this.subjectDto = subjectDto;
	}

	public TeacherDTO getTeacherDto() {
		return teacherDto;
	}

	public void setTeacherDto(TeacherDTO teacherDto) {
		this.teacherDto = teacherDto;
	}

	public SubjectDTO getSubjectDto() {
		return subjectDto;
	}

	public void setSubjectDto(SubjectDTO subjectDto) {
		this.subjectDto = subjectDto;
	}

}
