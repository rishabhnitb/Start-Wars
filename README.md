# starwars
Project to integrate with Star Wars API {https://swapi.dev/api/}

Application uses open source API provided by https://swapi.dev/api/

Application can be used to get details for the characters, vehicles, films and 
other associated things with respect to Star Wars.

I have used Jenkins/docker which were locally hosted and provided my creds on both platform

Application Git Repo : https://github.com/rishabhnitb/Start-Wars
Docker image : https://hub.docker.com/r/rishabhnitb/star-wars
To pull the image : docker pull rishabhnitb/star-wars
Above image can be started to access the application

Project include Jenkinsfile with following stages :
	-GIT checkout (to checkout the project from git)
	-MVN package (to perform maven goal)
	-Build Docker Image (building docker image)
	-Push Docker Image (pushing to docker hub, I have configured it on my local jenkins with my creds. Please provide creds accordingly)
	-Run Container on Dev Server (Running the docker image on local machine)

It is an Spring based Web Application which is exposed using a micro-service which accepts parameters like type and name:

-On deploying application on local systems endpoints can be accessed in the following manner : 
	
	-To access swagger/Documentation : http://localhost:8080/swagger-ui/#/
	-Sample GET request : http://localhost:8080/?type=people&&name=Luke%20Skywalker
		-Request accepts following request parameters : 
			-type (required) : denotes the type of object one wants to list (eg: planets, people, films etc)
			-name (optional) : In order to look for a specific item, name can be provided to search from the list
		(NOTE : If only type is provided, response will contain list of all the available objects)
		
<img width="843" alt="image" src="https://user-images.githubusercontent.com/5252807/172023401-87eadd21-48cb-4326-9c53-feda781874b0.png">

Jenkins Stage View : 
<img width="1028" alt="image" src="https://user-images.githubusercontent.com/5252807/172051268-fc4e7a0d-ebcb-4bb0-a340-ae05b217ab77.png">

		
		
