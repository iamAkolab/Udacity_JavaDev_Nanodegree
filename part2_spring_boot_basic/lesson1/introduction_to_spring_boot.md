# LESSON 1s
## Introduction to Spring Boot
In this lesson, you will meet your instructor, learn about the prerequisites, and discuss what web development is and how it has been accomplished.

Web Development means building web applications, and in a standard web application, there are three main components:

* Data Storage
* Application Logic
* Client Access

### Data Storage
Some of those beans will be responsible for interacting with the database. We will be using a SQL database called H2, which is an in-memory SQL database 
hosted by Spring Boot. You'll learn to use MyBatis, a Java library for database interaction, to generate data-access beans, which will be used by other 
services in your application logic to satisfy client requests.

### Application Logic
Application logic manages client access and database interaction. For this course, you're going to learn how to use Spring Boot to maintain a collection 
of beans, which are small components of application logic that can interact with each other to carry out complex tasks.

### Client Access
The client that will access our application is a web browser, which will send HTTP requests to our app and usually expects HTML in return. Using Spring 
MVC and Spring Security, libraries provided to us by Spring Boot, you will learn to create special beans called controllers that you can configure to 
respond to client requests and generate HTML responses. Controllers act as the entry points of your application, from a client's perspective.

## Business Stakeholders
On a professional development team, many people are involved in the choice of language and framework:

* Developers who write the code.
* Testers who write and run tests.
* Designers who create prototypes for the developers to implement.
* Project Architects who choose the technologies best suited to a project's requirements
* Business Analysts who write technical specifications for the developers to follow.
* Project Managers who plan development efforts.

![Stakeholders](https://github.com/iamAkolab/udacity_javadev_nanodegree/blob/main/part2_spring_boot_basic/lesson1/l0-18-business-stakeholders.jpg)
