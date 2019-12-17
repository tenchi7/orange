package com.iktpreobuka.class_register_1.entities.dto;

public class LoginResponseDTO {

	private String username;

	private String password;

	private String role;

	private Integer id;

	private String firstName;

	private String lastName;

	public LoginResponseDTO() {
		super();
	}

	public LoginResponseDTO(String username, String password, String role, Integer id, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
