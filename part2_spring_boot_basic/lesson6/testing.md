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
