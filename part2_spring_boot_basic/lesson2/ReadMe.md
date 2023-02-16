# Lesson Outline
In this lesson, you'll be introduced to the following ideas and tools:

* Java Application Servers: We introduce the basics of server-side web development and how a Java Application Server simplifies things.
* Java Servlets: We discuss the central feature of the Application Server, the Servlet, and how it allows developers to access the conveniences provided by the Application Server.
* Spring Applications: We introduce Spring Framework, a collection of Java libraries and tools that build on the Application Server and Servlet to provide a huge amount of utility to Java web developers.
* Spring Starter Packs: We discuss the various "starter packs" available through Spring Boot's project generator, which can be used to quickly get up and running with a new Spring Boot project configured for specific features.
* Maven and the POM file: We introduce Maven, a dependency management tool for Java that allows developers to easily use powerful open-source libraries in their projects. We discuss how dependencies are declared in Maven's pom.xml file.

![Java Web Dev](https://github.com/iamAkolab/udacity_javadev_nanodegree/blob/main/part2_spring_boot_basic/lesson2/l1-lesson-outline.png)

# Source Code
https://github.com/udacity/nd035-c1-spring-boot-basics-examples

In general, the steps for downloading (clone) a Github repository are:
* Step 1. Download and install the Git for your OS
* Step 2. Open terminal (macOS/Linux) or Git Bash (Windows).
* Step 3. Run the following commands:

```
# Change your directory
cd <path to a directory where you want to download the repository>

# Download the repository
git clone https://github.com/udacity/nd035-c1-spring-boot-basics-examples.git

# Go inside the downloaded repository
cd nd035-c1-spring-boot-basics-examples

# List the files in the current directory
ls
```

# Key Terms
In this lesson, we learned about:

* Web servers and how early servers were single-function programs that could host files, serve web pages, and expose databases to external connections.
* Java application servers, which provides a pluggable architecture for applications to interface with, granting access to shared resources and multi-threaded request processing.
* Spring framework, a family of libraries that build on the abstractions of the application server to support many third-party integrations to provide easy abstractions for common web development tasks.
* Spring Boot, a convention-over-configuration approach to Spring app development that provides defaults for many Spring configuration options in order to provide a smoother development experience.
* Spring Initializr, the official project generator for Spring Boot, which allows developers to specify an application's metadata and dependencies and receive a fully-configured Spring Boot project, ready for development.
* Summary - Spring Boot Dependencies
* Spring Web This dependency helps to build RESTful web services using the Spring MVC. It uses Apache Tomcat as the default container.
* Thymeleaf It is a server-side Java template engine for both web and standalone applications that allows you to show HTML web pages to a client and populate them with data directly using the server code.
* Spring Security It is a dependency that allows custom authentication and access-control framework for the web application.
* MyBatis It is a persistence framework for having SQL support. MyBatis couples objects with SQL statements using an XML descriptor or annotations.
