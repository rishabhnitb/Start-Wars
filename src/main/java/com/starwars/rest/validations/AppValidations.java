package com.starwars.rest.validations;

import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;

import com.starwars.rest.common.AppConstants;

@Controller
public class AppValidations extends AppConstants{

	/*
	 * validating for TYPE provided 
	 */
	public void validateType(String type) {
		if(!TYPES.contains(type))
			throw new ValidationException("Invalid type provided, available types : " + TYPES);
	}
}
