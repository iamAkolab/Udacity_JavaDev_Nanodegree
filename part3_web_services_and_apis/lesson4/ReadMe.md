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
Eureka, created by Netflix, is responsible for the registration and discovery microservices. Spring has incorporated Eureka into Spring Cloud, making it even easier to stand up a Eureka server.

Eureka consists of a server and a client-side component. The server component will be the registry in which all the microservices register their availability. The microservices use the Eureka client to register; once the registration is complete, it notifies the server of its existence.
