# Developing Web Sites from the Back-End

![The Relationship Between Spring MVC and the Client](https://video.udacity-data.com/topher/2020/June/5ed974a8_l3-7-big-picture/l3-7-big-picture.png)

The figure above shows the relationship between Spring MVC and the client. Spring MVC uses HTML templates and application data to render a view 
for the client browser to display. The view exposes certain actions to the user, which when triggered are sent to Spring MVC, which processes the 
actions and renders new views for the client.

## Interacting with a simple web application
In a web application, there are two components: the client that sends HTTP requests, and the server, which sends HTTP responses back. 
In the case of a web browser client, the responses the server sends need to be in the format of HTML, the document language of the web. 
The HTML that is sent to the client both defines the data that the user sees, as well as the actions a user can take - things like buttons, 
links, and input forms are all part of what the server is responsible for generating.

This process of generating an entire UI from HTML would be tedious if we had to do it by hand. Luckily, we don't have to - Thymeleaf is an HTML 
template engine that, when used with Spring MVC, can simplify things greatly.

## HTML templates
HTML templates are essentially just HTML files with special tags and attributes that can be combined with a data model by a template engine like 
Thymeleaf to generate fully functional HTML documents. Spring MVC provides a standard way to choose a template and supply the necessary data model 
when a request comes in, which allows for a truly dynamic user experience.

```
Data model defines how the application stores and retrieves (serialize and deserialize) the Java objects into/from the database. Data modeling starts 
with designing the database tables which are analogous to the Java classes ("model" classes of the MVC).
```

## Key Terms
* GET Request: an HTTP request for data at a specific URL. This type of request cannot include any additional data.
* POST Request: and HTTP request that usually represents "posting" new data to the server. This is a common catch-all request method used for many data-bearing requests to the server.
* Dynamic: Something that is dynamic changes in response to external stimuli. In the case of HTML templates, dynamic sections of the template are ones that can be replaced or configured with data on-demand.
* Static: Something that is static does not change. In the case of HTML templates, static sections of the template are the ones that cannot be changed and will be the same no matter what data is used with the template.
* MVC: Model-View-Controller, a design pattern that emphasizes the separation of application components into those three categories or layers for more-structured user-facing application development.
