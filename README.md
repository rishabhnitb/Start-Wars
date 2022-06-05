# starwars
Project to integrate with Star Wars API {https://swapi.dev/api/}

Application uses open source API provided by https://swapi.dev/api/

Application can be used to get details for the characters, vehicles, films and 
other associated things with respect to Star Wars.

It is an Spring based Web Application which is exposed using a micro-service which accepts parameters like type and name:

-On deploying application on local systems endpoints can be accessed in the following manner : 
	
	-To access swagger/Documentation : http://localhost:8080/swagger-ui/#/
	-Sample GET request : http://localhost:8080/?type=people&&name=Luke%20Skywalker
		-Request accepts following request parameters : 
			-type (required) : denotes the type of object one wants to list (eg: planets, people, films etc)
			-name (optional) : In order to look for a specific item, name can be provided to search from the list
		(NOTE : If only type is provided, response will contain list of all the available objects)
		
<img width="843" alt="image" src="https://user-images.githubusercontent.com/5252807/172023401-87eadd21-48cb-4326-9c53-feda781874b0.png">
		
		
