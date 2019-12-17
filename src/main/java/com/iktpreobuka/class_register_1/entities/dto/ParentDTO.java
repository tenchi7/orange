package com.iktpreobuka.class_register_1.entities.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ParentDTO {

	private Integer id;
	@NotNull(message = "First name must be provided.")
	@Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.")
	private String firstName;
	@NotNull(message = "Last name must be provided.")
	@Size(min = 2, max = 20, message = "Last name must be between {min} and {max} characters long.")
	private String lastName;
	@Email
	@NotNull(message = "Email must be provided.")
	private String email;
	private List<StudentDTO> students;

	public ParentDTO() {
		super();
	}

	public ParentDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 20, message = "Last name must be between {min} and {max} characters long.") String lastName,
			@Email @NotNull(message = "Email must be provided.") String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public ParentDTO(
			@NotNull(message = "Name must be provided.") @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 20, message = "Last name must be between {min} and {max} characters long.") String lastName,
			@Email @NotNull(message = "Email must be provided.") String email, List<StudentDTO> students) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.students = students;
	}

	public Integer getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}

}
