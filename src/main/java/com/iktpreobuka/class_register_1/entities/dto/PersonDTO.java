package com.iktpreobuka.class_register_1.entities.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDTO {

	private Integer id;
	@NotNull(message = "First name must be provided.")
	@Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.")
	private String firstName;
	@NotNull(message = "Last name must be provided.")
	@Size(min = 2, max = 20, message = "Last name must be between {min} and {max} characters long.")
	private String lastName;

	public PersonDTO() {
		super();
	}

	public PersonDTO(
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 20, message = "Last name must be between {min} and {max} characters long.") String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public PersonDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 20, message = "Last name must be between {min} and {max} characters long.") String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

}
