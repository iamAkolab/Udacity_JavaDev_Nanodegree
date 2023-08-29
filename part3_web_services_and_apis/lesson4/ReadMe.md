# Microservices

N-Tier and monolithic applications used to be the de facto standard. In one single binary web artifact, like an EAR or WAR file, there would be a layered architecture with the decomposition of code into more functional components.

* Presentation Layer
* Business Process Layer/Service Layer
* Data Access Layer

There are several disadvantages to the n-tier monolithic application architecture:

* Tight coupling of code which makes changes hard.
* A single deployment with multiple layers that causes long testing, building, and deployment cycles.
* A big monolithic application that makes code reuse and sharing of components difficult.

The Microservices Architecture (MSA) decomposes systems into discrete, individual, standalone components that can communicate amongst themselves, working together or with external systems.
MSA is a more agile framework that fits well with the cloud-based world and lends itself well to web application development and web service development.

__Features__
* MSA is very flexible because it supports any language that can communicate via a RESTful endpoint and leverages REST over HTTP.
* MSA offers agility and systems that are easier to write, test, deploy, and share.
* MSA provides systems that can better scale to load and demand.
* MSA provides systems that are resilient because failures are isolated and don’t cascade through the infrastructure.

## Case Study: Eureka Server
Eureka, created by Netflix, is responsible for the registration and discovery microservices. Spring has incorporated Eureka into [Spring Cloud](https://spring.io/projects/spring-cloud), making it even easier to stand up a Eureka server.

Eureka consists of a server and a client-side component. The server component will be the registry in which all the microservices register their availability. The microservices use the Eureka client to register; once the registration is complete, it notifies the server of its existence.


The case study is an online ordering service. There are multiple services that work together to create the system.

* Item Service
* Order Service
* Shipping Service

Each service has its own database. For this case study, instead of building out the entire system, we will focus on the Item Service. The code can be cloned from GitLab.

The project has the following components:

Eureka Module
* Eureka Registry accessible via http://localhost:8761

Items Microservices Module
* CRUD Repository - ItemRepository.java
* Domain Entity/Model -Item.java
* H2 Database accessible via http://localhost:8080/h2/
* Tomcat Server accessible via http://localhost:8080
* Items Microservice accessible via http://localhost:8080/items


## Troubleshooting
You may need this additional dependency in your POM file for the Eureka server to load:
```
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.4.0-b180725.0427</version>
</dependency>
```
