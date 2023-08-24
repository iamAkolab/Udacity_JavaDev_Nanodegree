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
