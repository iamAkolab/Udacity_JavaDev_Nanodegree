# Introduction
It’s very important to document your REST APIs. There could be other developers that need to use your APIs or you may have customers that want to use your APIs to help speed up their development time.

Documentation is a good way to communicate to others how they can use your APIs. Documentation communicates the operations available, the format for requesting data and the format data will be returned in.

Typically, the initial creation of documentation is easy, but the on-going maintenance of keeping that documentation up to date is hard. Imagine having to manually update documentation every time your code changes! It's good to use tools that automatically inspect your code and update the documentation.

# Swagger
One of the most popular API documentation specifications is [OpenApi](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md), formerly known as the Swagger Specification. OpenAPI allows you to describe your API using JSON or YAML. Swagger is the name associated with some of the most well-known, and widely used tools for implementing the OpenAPI specification. Swagger helps you design, build, document and consume REST APIs. SpringFox is a Swagger integration for the Spring Framework.
There are several parts to swagger, this include:
* Swagger Editor – A browser-based editor where you can write OpenAPI specs.
 * Swagger UI – A web application that renders OpenAPI specs as interactive API documentation.
 * Swagger Codegen – A tool that generates server stubs and client libraries from an OpenAPI spec.
