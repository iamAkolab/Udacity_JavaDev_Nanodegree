# Spring Data Rest
Spring Data REST makes it easy to expose microservices. Spring Data REST builds on top of Spring Data repositories and automatically exports those as REST resources.

So how does Spring Data Rest work?

* 1. At application startup, Spring Data Rest finds all of the spring data repositories
* 2. Then, Spring Data Rest creates an endpoint that matches the entity name
* 3. Next, Spring Data Rest appends an S to the entity name in the endpoint
* 4. Lastly, Spring Data Rest exposes CRUD (Create, Read, Update, and Delete) operations as RESTful APIs over HTTP

There is no need to create a controller or service layer!
