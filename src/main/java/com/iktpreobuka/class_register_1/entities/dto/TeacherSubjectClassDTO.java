package com.iktpreobuka.class_register_1.entities.dto;

import javax.validation.constraints.NotNull;


public class TeacherSubjectClassDTO {

	@NotNull(message = "Teacher must be provided.")
	private TeacherDTO teacherDto;

	@NotNull(message = "Subject must be provided.")
	private SubjectDTO subjectDto;

	@NotNull(message = "School class must be provided.")
	private SchoolClassDTO schoolClassDto;

	public TeacherSubjectClassDTO() {
		super();
	}

	public TeacherSubjectClassDTO(@NotNull(message = "Teacher must be provided.") TeacherDTO teacherDto,
			@NotNull(message = "Subject must be provided.") SubjectDTO subjectDto,
			@NotNull(message = "School class must be provided.") SchoolClassDTO schoolClassDto) {
		super();
		this.teacherDto = teacherDto;
		this.subjectDto = subjectDto;
		this.schoolClassDto = schoolClassDto;
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

	public SchoolClassDTO getSchoolClassDto() {
		return schoolClassDto;
	}

	public void setSchoolClassDto(SchoolClassDTO schoolClassDto) {
		this.schoolClassDto = schoolClassDto;
	}

}
