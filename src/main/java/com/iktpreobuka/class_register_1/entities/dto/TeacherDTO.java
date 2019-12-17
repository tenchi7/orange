package com.iktpreobuka.class_register_1.entities.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherDTO {

	private Integer id;
	@NotNull(message = "First name must be provided.")
	@Size(min = 2, max = 30, message = "Name must be between {min} and {max} characters long.")
	private String firstName;
	@NotNull(message = "Last name must be provided.")
	@Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.")
	private String lastName;

	private List<SchoolClassDTO> schoolClasses;

	private List<SubjectDTO> subjects;

	public TeacherDTO() {
		super();
	}

	public TeacherDTO(
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.") String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public TeacherDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 30, message = "Name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.") String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public TeacherDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 30, message = "Name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.") String lastName,
			List<SubjectDTO> subjects) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<SchoolClassDTO> getSchoolClasses() {
		return schoolClasses;
	}

	public void setSchoolClasses(List<SchoolClassDTO> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<SubjectDTO> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectDTO> subjects) {
		this.subjects = subjects;
	}

}
