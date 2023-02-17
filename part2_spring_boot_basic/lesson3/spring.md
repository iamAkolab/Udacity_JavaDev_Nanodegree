# What is Spring

When designing Spring applications, the most important principle to keep in mind is separation of concerns. What that really means is that for every problem 
your application has to solve has a home in a component class that is easy to find and flexible to use. By building your application out of small but focused 
components, you'll make the most of Spring's boilerplate-crushing power, and when it's time to add new features, you'll know exactly where to put them. 
On a larger team, this means greater coordination and less time spent trying to find and eliminate redundancies and conflicts.

But in order to allow your components to communicate effectively with one another, you'll need a system of data types to share between them. These are simple 
classes designed to store structured data, and little else. They're useful as conceptual representations of application data, like user profiles, or shipment 
invoice details, but made to be used and manipulated by the components of an application. A good rule of thumb to decide which is which is the new keyword test. 
A component should never be manually instantiated with the new keyword - components are managed by Spring, which means we need to rely on dependency injection 
to get a component reference. Data types, on the other hand, are no more special than Java's collections, and we can manually instantiate them with the new 
keyword whenever we'd like. Of course, we can use Spring (and its related libraries) to instantiate them for us as well, and in the coming lessons we sometimes will.

## Key Terms:
* Separation of Concerns: A code organization philosophy that emphasizes single-purpose components. In Java and Spring, this means keeping all methods related to a specific problem domain in the same class, for the sake of maintainability and reducing code reuse.
* Data Types: Sometimes called POJOs (plain-old-java-objects), Data Types are classes in application designed purely to hold structured application data, like users, profiles, or anything else an application might manage. These objects are helpful for us to maintain a good conceptual model of an application, and are created and accessed frequently during execution.
* Components: Components are persistent class instances managed by Spring in an application. They usually resemble libraries more than typical objects, with methods that must be called to perform specific actions. Components are only created when Spring is configured to create them, usually at server startup.
