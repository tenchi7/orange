package com.iktpreobuka.class_register_1.utilities;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.class_register_1.security.Views;

public class RESTError {

	@JsonView(Views.Public.class)
	private int code;

	@JsonView(Views.Public.class)
	private String message;

	public RESTError(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
