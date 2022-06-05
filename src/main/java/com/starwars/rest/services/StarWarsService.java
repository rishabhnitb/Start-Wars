package com.starwars.rest.services;

public interface StarWarsService {


	Object getDetails(String type, String name) throws Exception;
	
	Object getRequestedObject(String object, String type, String name);
	
}
