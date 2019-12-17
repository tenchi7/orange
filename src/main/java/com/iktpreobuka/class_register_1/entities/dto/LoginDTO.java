package com.iktpreobuka.class_register_1.entities.dto;

import javax.validation.constraints.NotNull;

public class LoginDTO {

	@NotNull(message = "Username must be provided.")
	private String username;

	@NotNull(message = "Password must be provided.")
	private String password;

	public LoginDTO() {
		super();
	}

	public LoginDTO(
			@NotNull(message = "Username must be provided.") String username,
			@NotNull(message = "Password must be provided.") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
