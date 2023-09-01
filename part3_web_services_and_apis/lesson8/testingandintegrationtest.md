# Overview

Testing gives you confidence that your application is working when you make changes, so you’ll want to introduce automated testing and make testing a normal part of your development process. First, unit test your small piece, then integrate your piece with the other system components to conduct integration testing.

Dependency
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
Spring-boot-starter-test imports both Spring Boot test modules as well as JUnit, AssertJ, Hamcrest, and a number of other useful libraries.
