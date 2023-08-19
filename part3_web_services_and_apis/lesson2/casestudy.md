# Case Study: Intro & Maven Dependencies
The case study is a REST API that retrieves a list of locations from a database. The code can be cloned from [GitLab](https://gitlab.com/videolearning/udacity-java/tree/master/Lesson2-restapis)

* spring-boot-starter-web - This starter pack is used for web application development and automatically adds libraries like Spring MVC, REST, Tomcat, and Jackson.
* com.h2database - This starter pack is used for the H2 in-memory database.
* spring-boot-starter-data-jpa - This starter pack includes JDBC, Hibernate, Transactions API, JPA, and Aspects.

# LAB 1
__Step 1__: Use Spring Initializr to bootstrap a simple project.
* Add the H2 Database, Spring Web Starter, and the Spring Data JPA dependencies before generating the project.

__Step 2__: Set-up the H2 in-memory database.
* Enable the console, add a path for the console, and create a url for the datasource using H2.

Within application.properties (found within /src/main/resources/), you could add the following code:

```
spring.h2.console.enabled=true
spring.h2.console.path=/h2

spring.datasource.url=jdbc:h2:mem:dogdata
```
