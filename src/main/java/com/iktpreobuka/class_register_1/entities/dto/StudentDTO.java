package com.iktpreobuka.class_register_1.entities.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO {

	private Integer id;

	@NotNull(message = "First name must be provided.")
	@Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.")
	private String firstName;

	@NotNull(message = "Last name must be provided.")
	@Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.")
	private String lastName;

	private ParentDTO parentDto;

	private SchoolClassDTO schoolClassDto;

	public StudentDTO() {
		super();
	}

	public StudentDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public StudentDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String lastName,
			ParentDTO parentDto) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parentDto = parentDto;
	}

	public StudentDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String lastName,
			SchoolClassDTO schoolClassDto) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolClassDto = schoolClassDto;
	}

	public StudentDTO(Integer id,
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 6, message = "Code must be between {min} and {max} characters long.") String lastName,
			ParentDTO parentDto, SchoolClassDTO schoolClassDto) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parentDto = parentDto;
		this.schoolClassDto = schoolClassDto;
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

	public ParentDTO getParentDto() {
		return parentDto;
	}

	public void setParentDto(ParentDTO parentDto) {
		this.parentDto = parentDto;
	}

	public SchoolClassDTO getSchoolClassDto() {
		return schoolClassDto;
	}

	public void setSchoolClassDto(SchoolClassDTO schoolClassDto) {
		this.schoolClassDto = schoolClassDto;
	}

}
