package com.starwars.rest.services.impl;

import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.starwars.rest.common.AppConstants;
import com.starwars.rest.http.HttpHandler;
import com.starwars.rest.services.StarWarsService;

@Service
public class StartWarsServiceImpl extends AppConstants implements StarWarsService{

	@Autowired
	HttpHandler httpHandler;
	
	/*
	 * Fetch details 
	 */
	@Override
	public Object getDetails(String type, String name) throws Exception {
		
		Object object = null;
		try {
			HttpResponse<String> response = httpHandler.get(type, name);
			
			if((name != null && !name.contentEquals("")) && 
					response.statusCode() == HttpStatus.OK.value()) {
				object = getRequestedObject(response.body(), type, name);
			} else {
				object = response.body();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception(e);
		}
		return object;
	}
	
	/*
	 * Find the object with the name provided for the type selected
	 */
	public Object getRequestedObject(String object, String type, String name) {
		
		JSONArray response = new JSONObject(object).getJSONArray(RESULTS);
		JSONObject singleObject = new JSONObject();
		
		for(int i = 0; i<response.length(); i++) {
			
			JSONObject node = response.getJSONObject(i);
			if(!type.contentEquals(FILMS) && (node.get(NAME).toString().contains(name))) {
				singleObject = node;
				break;
			} else if(type.contentEquals(FILMS) && node.get(TITLE).toString().contains(name)){
				singleObject = node;
				break;
			}
		}
		return singleObject.toString();
	}

}
