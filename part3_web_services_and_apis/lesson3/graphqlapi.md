# GraphQL APIs

GraphQL is a query language for APIs or a syntax that describes how to ask for data and is generally used to load data from a server to a client. 
GraphQL offers maximum efficiency and flexibility because it allows the calling client to specify exactly what data it needs.

To include GraphQL in your project, a couple of dependencies are needed:
* __graphql-spring-boot-starter__ - This starter is very helpful because it will add and automatically configure a GraphQL Servlet that you can access at /graphql . This starter will also use a GraphQL schema library to parse all schema files found on the classpath. The starter will also set up an endpoint that can access POST requests.
* __graphql-java-tools__ - A helper library to parse the GraphQL schema.
