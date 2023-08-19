# Case Study: Intro & Maven Dependencies
The case study is a REST API that retrieves a list of locations from a database. The code can be cloned from [GitLab](https://gitlab.com/videolearning/udacity-java/tree/master/Lesson2-restapis)

* spring-boot-starter-web - This starter pack is used for web application development and automatically adds libraries like Spring MVC, REST, Tomcat, and Jackson.
* com.h2database - This starter pack is used for the H2 in-memory database.
* spring-boot-starter-data-jpa - This starter pack includes JDBC, Hibernate, Transactions API, JPA, and Aspects.

# LAB I
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

# LAB II
__Step 1__: Create an entity called Dog.
The dog should have three attributes:
* Name
* Breed
* Origin
First, create a new package in the same directory that holds your main application, called entity. Then, create a new Java class called Dog.

```
package com.udacity.DogRestApi.entity;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String breed;
    private String origin;

    public Dog(Long id, String name, String breed, String origin) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Dog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
```
__Step 2__: Create a web controller using @RestController.
* You just need to create the structure of the controller for now. You'll add more to it once we discuss services next.
First, create a new package in the same directory that holds your main application, called web. Then, create a new Java class called DogController.

The below code contains the first steps for this controller, which we will complete in the final lab of this lesson after implementing the related DogService.
```
package com.udacity.DogRestApi.web;

import org.springframework.web.bind.annotation.RestController;
// Note - we will eventually also import additional packages later on

@RestController
public class DogController {

}
```
