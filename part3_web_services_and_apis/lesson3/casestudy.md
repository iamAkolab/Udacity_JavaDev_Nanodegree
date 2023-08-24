# GraphQL Case Study Steps

The case study is a GraphQL API that retrieves a list of locations from a database. The code can be cloned from [GitLab](https://gitlab.com/videolearning/udacity-java/tree/master/Lesson3-graphql).

The REST API has the following components:

* Controller - LocationController.java
* Service - LocationService.java and LocationServiceImpl.java
* CRUD Repository - LocationRepository.java
* Domain Entity/Model - Location.java
* Schema - location.graphqls and via the GraphiQL console at http://localhost:8080/graphql/schema.json.
* Mutator - Mutation.java
* Query - Query.java
* H2 Database accessible via http://localhost:8080/h2/
* Tomcat Server accessible via http://localhost:8080
* GraphiQL console accessible via http://localhost:8080/graphiql

```
Sample Queries/Mutations
{
  findAllApplications {
    id
    owner
    address
  }
}

mutation {
  newLocation(
    name: "MBJ Airport",
    address: "Montego Bay, Jamaica airport location") {
      id 
      name
      address
    }
}

mutation {
  deleteLocation(id:1)
}

```

## LAB I
__Step 1__: Use Spring Initializr to bootstrap a simple project.
* Add the H2 Database, Spring Web Starter, and the Spring Data JPA dependencies before generating the project.

__Step 2__: Add the necessary GraphQL dependencies.
* You will need to manually enter these in your Maven POM file.
* Set up the necessary H2 and GraphQL properties to application.properties at this time as well.
  
First, add the following dependencies in the pom.xml file:
```
		<dependency>
			<groupId>com.graphql-java</groupId>
			<artifactId>graphql-spring-boot-starter</artifactId>
			<version>5.0.2</version>
		</dependency>

		<dependency>
			<groupId>com.graphql-java</groupId>
			<artifactId>graphql-java-tools</artifactId>
			<version>5.2.4</version>
		</dependency>

		<dependency>
			<groupId>com.graphql-java</groupId>
			<artifactId>graphiql-spring-boot-starter</artifactId>
			<version>5.0.2</version>
		</dependency>
```
Then, head over to your application.properties and add the following:
```
spring.h2.console.enabled=true
spring.h2.console.path=/h2
spring.datasource.url=jdbc:h2:mem:dogdata

graphql.servlet.mapping=/graphql
graphql.servlet.enabled=true
graphql.servlet.corsEnabled=true

graphiql.enabled=true
graphiql.endpoint=/graphql
graphiql.mapping=graphiql
```

## LAB II
