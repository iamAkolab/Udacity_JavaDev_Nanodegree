# Testing With JUnit and Selenium
## Testing: Why and How
![The Test-Driven Development Lifecycle](https://user-images.githubusercontent.com/77028341/222091941-3fe76bfd-4b89-4017-afe3-ffdb4e028a23.png)

The figure above shows the test-driven development lifecycle. First, there is an idea for a new feature. That feature idea is turned into a series of user stories, which are then turned into tests, which fail because the feature does not exist yet. The developers then work on the feature's code requirements until all of the tests pass, and the cycle begins anew.

Testing is an important and highly desired part of the software development process. In a world where uptime and user retention means everything, it's important to validate that your application actually does what it's supposed to before it goes into production.

The standard accepted way to enforce this is by adopting a test-driven development lifecycle, or TDD. In this model, the "red then green" philosophy is dominant - tests should be written before the feature to be tested, meaning that they start off failing - aka, the tests are "red." Then, as the feature is implemented, one test after another should start to pass - aka, become "green."

To facilitate this approach, it's useful to have a standard way to describe features or requirements to be tested. For this, we turn to the concept of a "user story." A user story describes the functionality a feature should have from the perspective of a user interacting with the application. Typically, the format of a user story is:

As a user, I can take some action in order to achieve some goal.

Often a feature will be broken up into many user stories, each of which should correspond to at least one test to be implemented for that feature. If all the tests pass, it means that all of the user stories are successfully implemented, and the feature is complete.

### Key Terms
* Test Driven Development: a software development methodology that emphasizes writing tests before the code to be tested. This gives developers a roadmap to success - once all the tests are passing, the feature is complete!
* User Story: User stories are short sentences derived from feature requirements in the format of As a user, I can in order to . These are used to create tests to verify the components of a feature.

## Testing
There are many different types of tests meant to validate different types of features and different layers of an application. In this course, we're going to focus on two specific types of tests: Unit tests and integration tests.

Unit tests are meant to test a single unit or component of an application or process - these tests should be simple, and verify that a specific method, component, or process step acts as expected according to its inputs. Sometimes you'll also use unit tests to verify that the unit under test fails predictably, as well; it's good to test both positive and negative conditions in a unit test!

Integration tests are the next layer up from unit tests. Instead of testing a single unit of an application, they test multiple units and how they integrate with one another. Often, an integration test will validate an entire user story, for example, while a unit test will validate a single step in the process a user story describes.

The rule of thumb is that unit tests should be used to test invariants - conditions that do not change - and integration tests should be used to test user actions and entire process flows .

### Key Terms
* Unit Tests: A unit test only validates the smallest unit of a computational process. That might mean a test of a single method, or a single component in an application.
* Invariants: An invariant is a law of computation, something that shouldn't change despite changing circumstances. For example, adding 0 to a number should always result in the original number, and dividing by 0 should always result in an error.
* Integration Tests: Integration tests are intended to validate the operation of multiple application components as they interact with each other - or integrate with one another.


## Testing with JUnit
JUnit is the standard Java testing framework, and despite its name, it is capable of much more than unit tests. JUnit expects all tests for an application to be collected in class files, just like any other Java code.

Annotations
JUnit provides an annotation, @Test, that can be placed on a method in a test class to declare a single test. Each method annotated like this can be either executed individually, or in a group - and in both cases, JUnit will generate a report that lists each test that was run, and whether it was successful or not.

In order for JUnit to know if a test is successful or not we need to use assertions. @Test-annotated methods should not have a return value! Instead, we can use special methods provided by JUnit to check our assumptions about the code under test. We'll look at a concrete example of this in the next video. To begin with, see the list of all annotations here.

Sometimes, we need to initialize some data or objects to be used in our test methods. JUnit provides a few extra annotations to define this initialization code. @BeforeEach- and @AfterEach-annotated methods will be called before an after each @Test-annotated method, respectively, and @BeforeAll- and @AfterAll-annotated methods will be called at the before and after all tests have been executed, respectively.

### Assertions
An assertion, in the context of JUnit, is a method we can call to check our assumptions about the behavior of the unit under test. If our assumptions are correct, the assertion silently returns and the test method continues. If they're false, the assertion throws a special exception class that JUnit uses to build the final failure report, and the test method halts execution.

```
Assertions are the static methods defined in the Assertion class. See the list of assertions here , and an example on how to use assertions in a unit test
```
For example, assertEquals(int expected, int actual) is an assertion method you can call in your test method to assert that the actual and expected integer values are equal. Let's see an example implementation of annotations and assertions next.

## Testing with JUnit - Annotations and Assertions
In the previous video example, we looked at some basic JUnit tests to learn more about JUnit's annotations and assertions. Some key takeaways:

* In a Maven project, it's extremely important to make sure your JUnit test classes are in the right directory. Maven expects tests to be in the src/test/java directory. Always double check!
* JUnit's assertions are all static methods on the org.junit.jupiter.api.Assertions class, so to use them you need to statically import the methods you need
* The most commonly-used assertion is assertEquals, which can be used to check if the result of some action is equal to the expected result.
* Another common assertion is assertThrows, which is used to check if a given piece of code does throw an exception as expected. This can be useful to check so-called negative test cases, where we want to make sure our application fails in the correct way. This assertion uses Java 8's lambda expression syntax to capture a piece of code to test - if you're not familiar with this syntax, you can find more information about it in the further research section below.
* @BeforeEach-annotated methods are particularly useful for initializing some data that needs to be in the same state for every test. For example in the video, we used this to ensure that a list under test always has the same values at the beginning of each test.

![image](https://user-images.githubusercontent.com/77028341/222093092-c8b31a3a-afe4-486e-bd56-fb6c5f665b55.png)

The diagram above shows the lifecycle of a JUnit test class.
* First, JUnit instantiates the class and calls any method annotated with @BeforeAll.
* Then it chooses a test to run. It calls any method with the @BeforeEach method, then it calls the @Test-annotated test method.
* Finally it calls the @AfterEach-annotated method. It repeats this for each @Test-annotated method in the class.
* When none remain, it calls the @AfterAll-annotated method and destroys the test class instance
