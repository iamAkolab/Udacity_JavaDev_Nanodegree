# How a Java Application Server Connects Applications to the Web

A web server's primary role is listening for HTTP requests and handling them with application logic, sending an HTTP response to the client that indicates the 
result of the operation. Simple HTTP servers host directories of HTML files directly, sending files in response to requests for specific URLs. This is enough 
for static websites with no dynamic server operations, but modern web apps support users accounts, complex interactions, and persistent data. 
Java application servers make these features more accessible by hosting many individual applications, managing them over a common interface, the servlet. 
This allows developers to focus on application logic and features, with HTTP request handling and routing handled by the server.

Spring provides additional sets of libraries that integrate with the servlet interface to provide applications with even more utilities that focus on database access, 
security, and HTML generation, and it's the tool we'll use to build our web applications.

![Java App Server](https://github.com/iamAkolab/udacity_javadev_nanodegree/blob/main/part2_spring_boot_basic/lesson2/l1-06-big-picture.jpg)

## Key Terms
* HTTP Request/Response: HTTP, or HyperTextTransferProtocol, is a binary data format for communication between programs over the web. It can be broken down into two basic message types: requests and responses. Clients send requests for resources to servers, which respond with the requested data. Read more about the protocol here.
* HTTP GET and POST: Every HTTP request has an important header that determines its method. GET and POST are two of the most common; GET indicates a request for data from  the server, and POST represents a request to "post" new data to the server - this usually represents some action on server data like submitting search terms, posting an  update, or adding new data to the server.


# Developing Your Intuition anout Web Development in Java
When building a web application, there are a lot of helpful tools that can solve common problems for you. How do you decide what you need to implement a given feature?

Since we're going to be building web apps with Java and Spring boot, the first step is to research what Spring supports and recommends for that feature. Spring's website includes documentation and examples for a wide range of features and libraries, and is a great place to start. Once you've decided on a library to use, the next step is finding its website and documentation. Most open-source libraries have extensive documentation that covers getting started, usage examples, and complete references. You can use these resources to implement your feature and debug issues along the way. Finally, if you encounter issues that documentation alone can't solve, you should search Google for to find similar issues and solutions others have encountered.


## Abstratction: Spring Boot
* Embedded App Server
* Implementation can  be reeplaced
* Apache Tomcat by Default( we also have Glassfish, Netty, WldFly)
* Design Feature First, Choose Tools Second

## Common Features for Web App
* Database Access
* Login Security
* Rendering HTML
* Logging
* Testing

## Using a New Tool
* RTFM - Read The Free Manual
* To the Google
* Rinse and Reoeat
