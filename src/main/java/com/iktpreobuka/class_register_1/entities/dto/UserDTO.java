package com.iktpreobuka.class_register_1.entities.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDTO {

	@NotNull(message = "Username must be provided.")
	@Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.")
	private String username;

	@NotNull(message = "Password must be provided.")
	@Min(value = 8, message = "Password must be at least {min} characters long.")
	private String password;

	@NotNull(message = "Password must be provided.")
	@Min(value = 8, message = "Password must be at least {min} characters long.")
	private String confirmedPassword;

	@NotNull(message = "Person must be provided.")
	private PersonDTO personDto;

	@NotNull(message = "User Role must be provided.")
	private String userRole;

	public UserDTO() {
		super();
	}

	public UserDTO(
			@NotNull(message = "Username must be provided.") @Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be provided.") @Min(value = 8, message = "Password must be at least {min} characters long.") String password,
			@NotNull(message = "Person must be provided.") PersonDTO personDto,
			@NotNull(message = "User Role must be provided.") String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.personDto = personDto;
		this.userRole = userRole;
	}

	public UserDTO(
			@NotNull(message = "Username must be provided.") @Size(min = 2, max = 20, message = "First name must be between {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be provided.") @Min(value = 8, message = "Password must be at least {min} characters long.") String password,
			@NotNull(message = "User Role must be provided.") String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public PersonDTO getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDTO personDto) {
		this.personDto = personDto;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
