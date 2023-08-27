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
__Step 1__: Create an entity called Dog.
* The dog should have three attributes:
 * Name
 * Breed
 * Origin
You can re-use your code from the REST API for the Dog entity, just make sure to update the package name accordingly!

__Step 2__: Create a GraphQL schema.
* The schema should match the fields found in the Dog entity.
* Add the following query operations:
 * findDogBreeds
 * findDogBreedById
 * findAllDogNames
* Add the following mutators:
 * deleteDogBreed
 * updateDogName

Following the video, create a graphql package within the resources directory of the project. Within that package, add a dog.graphqls file (you can add as a text file in IntelliJ if you do not have the GraphQL plug-in yet).
```
type Dog {
    id: ID!
    name: String!
    breed: String!
    origin: String!
}

type Query {
    findAllDogs: [Dog]!
    findDogById(id:ID!): Dog!
}

type Mutation {
    deleteDogBreed(breed:String!) : Boolean
    updateDogName(newName: String!, id:ID!) : Dog!
}
```
Now, you may be thinking I did not actually implement the query operations that were requested. But wait - using GraphQL, the user will be able to specify which fields they want from a query. So, simply by adding the queries for find all dogs (where they can request only breed, or only names), and finding a dog by id (where they can request just the breed), these operations actually exist.

__Step 3__: Create a repository that extends CrudRepository.
 * This repository is for creating, reading, updating, and deleting Dog objects.
Depending on how you implemented your DogRepository for the REST API, you may be able to completely re-use your code here. I actually chose to completely remove any queries from within the DogRepository, as there are already built-in methods for a CrudRepository that findAll and findById.

```
package com.udacity.DogGraphQL.repository;

import com.udacity.DogGraphQL.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
	@Query("select d.id, d.breed from Dog d where d.id=:id")
    	String findBreedById(Long id);

    	@Query("select d.id, d.breed from Dog d")
    	List<String> findAllBreed();

    	@Query("select d.id, d.name from Dog d")
    	List<String> findAllName();
}
```
__What about the service and controller?__
We don't need these to implement a GraphQL API. If you still want to have a REST API available, you can add those files to the application as well, and the same endpoints as before will be available.

## LAB III
__Step 1__: Create resolvers that implement GraphQLQueryResolver.
* The query resolver should match the operations in the GraphQL schema.
 * Query
 * findDogBreeds
 * findDogBreedById
 * findAllDogNames
* Mutation
 * deleteDogBreed
 * updateDogName
First, create a resolver package and then add a new class Query that implements GraphQLQueryResolver. We just need to add the queries we put in dog.graphqls earlier.

I already added some of the necessary error handling in findDogById for Step 2 here, but it's essentially the same for this file as what you saw for the REST API.
```
package com.udacity.DogGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.DogGraphQL.entity.Dog;
import com.udacity.DogGraphQL.exception.DogNotFoundException;
import com.udacity.DogGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
```
Next up are the mutators. Create a mutator package and then add a new class Mutation that implements GraphQLMutationResolver.

In these mutations, I am first using the findAll() query from the DogRepository, then processing to get the relevant entry (if available), and perform the requested operation. There are lots of ways to do this - you could instead add some additional queries to DogRepository to help, querying for just a single Dog by ID, for instance.

As with the queries, I've gone ahead and added the exception handling for Step 2 already for simplicity. The one for deleteDogBreed is not required in this exercise, but probably helpful for a user.
```
package com.udacity.DogGraphQL.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogGraphQL.entity.Dog;
import com.udacity.DogGraphQL.exception.BreedNotFoundException;
import com.udacity.DogGraphQL.exception.DogNotFoundException;
import com.udacity.DogGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
           if (d.getBreed().equals(breed)) {
               // Delete if the breed is found
               dogRepository.delete(d);
               deleted = true;
           }
        }
        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            // Set the new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
```
__Step 2__: Make sure errors are handled appropriately.
If an id is requested that doesn’t exist, appropriately handle the error
Some of this has been handled in the above for the Query and Mutation. You might be tempted to fully re-use your code for DogNotFoundException from earlier, but we need a few changes for it to work properly with GraphQL (note that if you were also adding on a separate REST API using a service and controller, you may want to use separate exception handling for it). This time, you'll want to have it implement a GraphQLError, and no longer use the @ResponseStatus annotation we used with the REST API.
```
package com.udacity.DogGraphQL.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException(String message, Long invalidDogId) {
        super(message);
        extensions.put("invalidDogId", invalidDogId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
```
If you are also wanting to implement the BreedNotFoundException, you can essentially just slightly alter the DogNotFoundException to do so. You could of course also potentially combine these into one exception file if you get a little more creative with the Exception itself.
```
package com.udacity.DogGraphQL.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public BreedNotFoundException(String message, String invalidBreed) {
        super(message);
        extensions.put("invalidBreedId", invalidBreed);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
```

## LAB IV
__Step 1__: Create a data.sql file.
* The file should create sample dog data in the database.
You can re-use your previous data.sql file or make a new one.

__Step 2__: Check that the GraphQL API works appropriately.
First, check that your schema shows appropriately at http://localhost:8080/graphql/schema.json. You might consider getting a browser extension or another tool to show formatted json as well, otherwise this will look like a large wall of text.
Now, let's go to Postman to test out whether the queries and mutators we want actually work.

First, make sure you are using a POST request, then add our graphQL URL http://localhost:8080/graphql to the app. Then, Make sure to add a Header with Content-Type as application/json.
Now, we can test out our queries. Let's look at an example for how a user would accomplish their needs based on the lab query operations. I also added id below to know which belongs to each dog, but they could just as easily skip that and only return the specific data they want (you need at least one item selected with GraphQL, and can do multiple at once - but you cannot grab all data without specifying each individual field).

For each of these below, enter them into "Body" in Postman and then "Send" the request.

findDogBreeds
```
{
	"query":"{findAllDogs { id breed } }"
}
```
which returns:

```
{
    "data": {
        "findAllDogs": [
            {
                "id": "1",
                "breed": "Pomeranian"
            },
            {
                "id": "2",
                "breed": "Pit Bull"
            },
            {
                "id": "3",
                "breed": "Cocker Spaniel"
            },
            {
                "id": "4",
                "breed": "Direwolf"
            },
            {
                "id": "5",
                "breed": "Husky"
            }
        ]
    }
}
```

findDogBreedById
```
{
	"query":"{findAllDogs { id breed } }"
}
```
which returns:
```
{
    "data": {
        "findDogById": {
            "id": "1",
            "breed": "Pomeranian"
        }
    }
}
```

You should also try out an invalid ID with this to check your error handling. As part of the returned JSON, I got Exception while fetching data (/findDogById) : Dog Not Found.


findAllDogNames
```
{
	"query":"{findAllDogs { id name } }"
}
```
which returns:
```
{
    "data": {
        "findAllDogs": [
            {
                "id": "1",
                "name": "Fluffy"
            },
            {
                "id": "2",
                "name": "Spot"
            },
            {
                "id": "3",
                "name": "Ginger"
            },
            {
                "id": "4",
                "name": "Lady"
            },
            {
                "id": "5",
                "name": "Sasha"
            }
        ]
    }
}
```
## Mutations
Let's say we want to change the name of dog four to "Ghost". There's a slightly different syntax, that needs mutation included in the query as well. Also, make sure to use the escape character \ to include quotation marks for strings.

updateDogName
```
{
	"query":"mutation {updateDogName(newName:\"Ghost\", id:4) { id name breed } }"
}
```
which returns:
```
{
    "data": {
        "updateDogName": {
            "id": "4",
            "name": "Ghost",
            "breed": "Direwolf"
        }
    }
}
```
Make sure to test out an invalid ID here too!


deleteDogBreed
For this, you do not need to add the field specifications afterward.
```
{
	"query":"mutation {deleteDogBreed(breed:\"Pomeranian\")}"
}
```
which returns:
```
{
    "data": {
        "deleteDogBreed": true
    }
}
```
If you added an Exception for a missing breed, make sure to test that here too
