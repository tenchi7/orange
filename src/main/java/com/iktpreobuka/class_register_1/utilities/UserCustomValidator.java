package com.iktpreobuka.class_register_1.utilities;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.class_register_1.entities.dto.UserDTO;

@Component
public class UserCustomValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> myClass) {
		return UserDTO.class.equals(myClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO user = (UserDTO) target;
		if (!user.getPassword().equals(user.getConfirmedPassword())) {
			errors.reject("400", "Passwords must be the same");
		}
	}

}
