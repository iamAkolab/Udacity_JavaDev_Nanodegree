# Case Study: Build a Dog Microservice (Eureka)

## LAB I: Build a Dog Microservice
__Step 1___: Create a SpringBoot project that creates a Eureka server.
* Ensure that you use the proper dependencies in the Maven POM file and the necessary annotations.
* Make a note of the service URL and add any other necessary details in application.properties.

First, navigate once again to Spring Initializr. You can add the Config Client (for spring-cloud-starter-config) and Eureka Server (for spring-cloud-netflix-eureka-server) dependencies to generate the POM file for this project. Remember that since this is just the Eureka server and not the microservice client you will build later, you won't need dependencies like H2.
