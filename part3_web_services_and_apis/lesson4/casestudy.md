# Case Study: Build a Dog Microservice (Eureka)

## LAB I: Build a Dog Microservice
__Step 1__: Create a SpringBoot project that creates a Eureka server.
* Ensure that you use the proper dependencies in the Maven POM file and the necessary annotations.
* Make a note of the service URL and add any other necessary details in application.properties.

First, navigate once again to Spring Initializr. You can add the Config Client (for spring-cloud-starter-config) and Eureka Server (for spring-cloud-netflix-eureka-server) dependencies to generate the POM file for this project. Remember that since this is just the Eureka server and not the microservice client you will build later, you won't need dependencies like H2.

Additionally, I added the below additional dependency to my POM file to get the Eureka server up and running:
```
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.4.0-b180725.0427</version>
		</dependency>
```
From there, navigate to your application.properties file to add the application name and server port (8761 in the case of a Eureka server, typically). Below, I have also added lines to avoid registering the Eureka server itself as a client, as well as adding some additional logging to help with any potential debugging or information needs.

```
spring.application.name=eureka-server
server.port=8761

## avoid registering itself as a client
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
logging.level.com.netflix.eureka=ON
logging.level.com.netflix.discovery=ON
```
You're already almost done! Now, we just need one import and one annotation added to EurekaApplication.java - importing EnableEurekaServer and adding the related annotation.

```
package com.udacity.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
```
__Step 2__: Use a web browser to view the Eureka web console.
Navigate to http://localhost:8761/ on your computer to view the Eureka web console. Note again that Eureka servers are typically put on port 8761, but if you would have used a different server port in application.properties, you would instead navigate to that port.

## LAB II: Build a Dog Microservice - Spring Data REST
__Step 0__: Create a SpringBoot project/module for an eventual microservice.
We skipped this step on the original lab page, but it's essentially inferred to get us started. This can either be a new project (in which case you would need the Eureka server running in a separate window) or a new module. Since so far we've been using Spring Initializr as a separate project, I will approach it as such below.

Along with JPA, H2 and Spring Web Starter, you can add Rest Repositories (for spring-boot-starter-data-rest), Cloud Config, and also Eureka Discovery Client, which we won't utilize until the last part of the lab in this lesson (you can always update your POM file with this later, if necessary). If you need to debug, you might comment out the Eureka discovery client, as otherwise you'll see a lot of messages being output depending on whether it is connected to your Eureka server yet.
Don't forget to add anything you may need for H2 to application.properties here! I re-used the same lines from the REST API in mine.

Step 1: Create an entity called Dog.
The dog should have three attributes:
Name
Breed
Origin
You can re-use your code from the REST API for the Dog entity, just make sure to update the package name accordingly!

Step 2: Create a repository that extends CrudRepository.
This repository is for creating, reading, updating, and deleting Dog objects.
Note: This repository will not need to implement anything beyond an interface.
Depending on your implementation, this can be re-used from either the REST API or GraphQL API. In this case, we don't need to add anything within the interface here.

package com.udacity.DogMicroservice.repository;

import com.udacity.DogMicroservice.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
Step 3: Create a data.sql file.
The file should create sample dog data in the database.
You can either re-use your previous data.sql files here or create a new one.

Step 4: Create a microservice using Spring Data REST.
Include the proper dependencies in the Maven POM file.
If you've been following since Step 0, this was actually done by including Rest Repositories within Spring Initializr, but otherwise, you can add the following to your POM file:

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>
Amazingly, you have now created a microservice to serve up the dogs' information! Spring Data Rest is handling most of the work for you, although since this is a microservice, it is more limited in what it does on its own (we don't have the explicit functionality to just get dog names here, for instance).

Step 5: Check that you are able to access your microservice.
While it might feel like we have hardly coded anything yet, your microservice should now be ready! When I navigated to http://localhost:8080/dogs, I saw the below (with some formatting done by a browser extension).
