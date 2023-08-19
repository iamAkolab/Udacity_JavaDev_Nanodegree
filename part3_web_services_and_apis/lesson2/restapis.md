# Rest APIs

REST stands for REpresentational State Transfer. It’s a set of guidelines application developers use to design APIs.

There are four principles that APIs follow:

* Data and functionality in the API are considered “resources” and identified through something called the URI, or Uniform Resource Identifier. These are accessed by web links.
* Resources are manipulated using a fixed set of operations. GET retrieves a resource. POST creates one. Use PUT to update the resource, and of course, DELETE will remove it.
* Resources can be represented in multiple formats, such as HTML, XML, plain text, and other formats defined by a media type.
* Communication between the client and server (i.e. endpoint) is stateless. This means the server will not remember or store any state about the client that made the call.

Example a REST API that retrieves a list of locations from a database. The code can be cloned from [GitLab](https://gitlab.com/videolearning/udacity-java/tree/master/Lesson2-restapis).
The REST API has the following components:

Controller - LocationController.java
Service - LocationService.java and LocationServiceImpl.java
CRUD Repository - LocationRepository.java
Domain Entity/Model - Location.java
H2 Database accessible via http://localhost:8080/h2/
Tomcat Server accessible via http://localhost:8080
