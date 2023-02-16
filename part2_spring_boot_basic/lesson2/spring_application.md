# Spring Applications

Spring is an application framework, which means that instead of choosing when to invoke it from your application, you choose when it 
invokes your application code. This pattern of software development is called Inversion of Control (IoC), and it's powerful because it 
allows developers to develop specialized application components and use Spring to connect them with each other using dependency injection. 
This is good for clean, separated code and for code reuse. This is evident when looking at the vast number of Spring modules and 
Spring-integrated third-party tools that are available. This course focuses on a few of them:

* Spring MVC, a generic web controller library for Spring that supports a wide variety of utilities to simplify the handling of HTTP requests
* Thymeleaf, a third party template engine that can integrate with Spring MVC to simplify the generation of web pages as responses to HTTP requests
* Spring Security, a generic authentication library for Spring that can integrate with many different credential sources and authentication protocols to automatically manage request authentication and security contexts
* MyBatis, a third-party database access library that provides simple SQL/Java mapping tools that can be defined in Spring components

![Frameworks](https://miro.medium.com/max/1200/0*l_Jj0DUJFpl0uVKG)

## The End of Boilerplate: Spring Boot
So Spring adds a lot of features, but it still sounds like a lot of configuration. We still have to deploy it to an application server, right? 
And we still have to create a servlet for Spring to live in. It also sounds like getting all of these modules and utilities to work together might take some work.

In the past, Spring did require a lot of configuration, but over time, the development world has moved towards a convention-over-configuration approach. 
Spring Boot is a project that provides an a-la-cart Spring experience, complete with a web page for generating and downloading starter projects based on 
the application needs. Most Spring Boot applications today also contain an embedded application server with a default, pre-configured servlet definition. 
All you have to do to run your Spring-enabled code as a server is to run a main method.

With the rise of containerized architectures like Docker, this style of application development has become as popular as the pluggable application server, 
and in this course, we'll be exclusively using this mode. However, if you do want to deploy your Spring Boot application to a traditional application server, 
there are built-in tools that allow you to package the application as a standard WAR file.

## Key Terms
* IoC: Inversion of Control, which is the practice of designing libraries as application runners. This allows developers to focus on application-specific logic 
and rely on IoC containers to connect application components with one another, eliminating a lot of boilerplate and encouraging a clean separation of development 
concerns.


# Spring Starter Packs
## Spring Starter Packs Setup
Spring is a collection of open-source libraries that solve common web development problems. But how do we get those libraries? In this course, we'll be using Maven, a dependency management tool that lets us define dependencies on open-source libraries based on their names and version numbers. We define those in a file in our projects called pom.xml, which Maven reads and uses to download the required libraries. We can also have our projects inherit dependencies from some base project, which is a feature that Spring Boot uses to make setting up a new Spring project easy as pie. We'll be using Spring Initializr, an online project generator, to choose specific Spring dependencies to add to new Spring projects.


Spring Boot is best experienced with the help of Spring Initializr, an official project generator. You can use it to configure metadata and build properties of a project as well as what starter dependencies you want to include. These include:

* Spring Dev Tools: utilities including hot reloading changed code into a running application
* Spring MVC: web layer utilities that make developing server-side web apps easy
* Spring Data: a common interface for many different types of database access
* And many more Once you've selected your dependencies and chosen your language, build tool, and project identifiers, Spring Initializr will generate a zip file that includes a ready-to-run server with all of the choices you made reflected in its pom.xml file, as well as the package structure.

## Key Terms
* Maven: A dependency management system and project build tool for Java. Provides a standardized way to define dependencies between projects and include them in the project build path.
* POM: The Project Object Model that Maven uses to represent the dependency and build configuration of a project. Usually, this refers to the pom.xml configuration file found in a Maven project.
* Dependency Management System: Any tool that automates the downloading and linking of external packages to a software development project. Most languages these days either provide one officially or have a community-accepted standard.

