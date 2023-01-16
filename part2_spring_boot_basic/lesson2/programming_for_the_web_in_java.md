# How a Java Application Server Connects Applications to the Web

A web server's primary role is listening for HTTP requests and handling them with application logic, sending an HTTP response to the client that indicates the 
result of the operation. Simple HTTP servers host directories of HTML files directly, sending files in response to requests for specific URLs. This is enough 
for static websites with no dynamic server operations, but modern web apps support users accounts, complex interactions, and persistent data. 
Java application servers make these features more accessible by hosting many individual applications, managing them over a common interface, the servlet. 
This allows developers to focus on application logic and features, with HTTP request handling and routing handled by the server.

Spring provides additional sets of libraries that integrate with the servlet interface to provide applications with even more utilities that focus on database access, 
security, and HTML generation, and it's the tool we'll use to build our web applications.

![Java App Server](https://github.com/iamAkolab/udacity_javadev_nanodegree/blob/main/part2_spring_boot_basic/lesson2/l1-06-big-picture.jpg)

# Key Terms
HTTP Request/Response: HTTP, or HyperTextTransferProtocol, is a binary data format for communication between programs over the web. It can be broken down into two basic 
message types: requests and responses. Clients send requests for resources to servers, which respond with the requested data. Read more about the protocol here.
HTTP GET and POST: Every HTTP request has an important header that determines its method. GET and POST are two of the most common; GET indicates a request for data from 
the server, and POST represents a request to "post" new data to the server - this usually represents some action on server data like submitting search terms, posting an 
update, or adding new data to the server.
