# Overview

Testing gives you confidence that your application is working when you make changes, so you’ll want to introduce automated testing and make testing a normal part of your development process. First, unit test your small piece, then integrate your piece with the other system components to conduct integration testing.

Dependency
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```
Spring-boot-starter-test imports both Spring Boot test modules as well as JUnit, AssertJ, Hamcrest, and a number of other useful libraries.

# Unit Testing
We will first look at unit testing REST APIs using [JUnit](https://junit.org/junit5/), [Mockito](https://site.mockito.org/) and [Spring Test](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html) (also known as, MockMVC).

* JUnit is a popular unit testing framework that allows you to test individual units of source code.
* Mockito is a great mocking framework which provices data for JUnit tests.
* @MockBean works well with the Mockito library.
* @WebMvcTest is used for controller layer unit testing.

## Case Study: Unit Testing
The code can be cloned from [GitLab](https://gitlab.com/videolearning/udacity-java/tree/master/Lesson8-testing).

__REST API Components__
* Controller - LocationController.java
* Service - LocationService.java and LocationServiceImpl.java
* CRUD Repository - LocationRepository.java
* Domain Entity/Model - Location.java
* H2 Database accessible via http://localhost:8080/h2/
* Tomcat Server accessible via http://localhost:8080

__Unit Testing Components__
* LocationControllerUnitTest.java

__Integration Testing Components__
* LocationControllerIntegrationTest.java
