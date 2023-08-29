# Case Study: Build a Dog Microservice (Eureka)

## LAB I: Build a Dog Microservice
__Step 1___: Create a SpringBoot project that creates a Eureka server.
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
