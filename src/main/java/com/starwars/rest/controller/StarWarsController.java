package com.starwars.rest.controller;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.rest.services.StarWarsService;
import com.starwars.rest.validations.AppValidations;

@RestController
@RequestMapping("/")
public class StarWarsController {

	@Autowired
	StarWarsService starWarsService;
	
	@Autowired
	AppValidations validate;
	
	/*
	 * Endpoint to fetch details for any star wars related object
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> findObjectDetails(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) throws Exception{
		
		validate.validateType(type);
		return new ResponseEntity<>(starWarsService.getDetails(type, name), HttpStatus.OK);
	}
	
}
