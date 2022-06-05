package com.starwars.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.starwars.rest.common.AppConstants;
import com.starwars.rest.controller.StarWarsController;
import com.starwars.rest.services.StarWarsService;
import com.starwars.rest.validations.AppValidations;

@SpringBootTest
class RestApplicationTests extends AppConstants{

	@Autowired
	private AppValidations validate;
	
	@Autowired
	private StarWarsService service;
	
	@Autowired
	private StarWarsController controller;
	
	@Test
	public void validateTypeNegativeTest() {
		
		try {
			validate.validateType("test");
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void validateTypePositiveTest() {
		try {
			validate.validateType(PEOPLE);
		} catch(Exception e) {
			assertTrue(false);
		}
		assertTrue(true);
	}

	@Test
	public void getDetailsPositiveTest() {
		Object result = null;
		try {
			result = service.getDetails(PEOPLE, "abc");
		} catch (Exception e) {
			assertTrue(false);
		}
		assertTrue(result.toString().contentEquals("{}"));
	}
	
	@Test
	public void validateEndpointNegativeTest() {
		try {
			controller.findObjectDetails("abc", "def");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Invalid type provided"));
		}
	}
	
}
