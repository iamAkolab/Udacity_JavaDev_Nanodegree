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
Data model defines how the application stores and retrieves (serialize and deserialize) the Java objects into/from the database. 
Data modeling starts with designing the database tables which are analogous to the Java classes ("model" classes of the MVC).
```

## Key Terms
* GET Request: an HTTP request for data at a specific URL. This type of request cannot include any additional data.
* POST Request: and HTTP request that usually represents "posting" new data to the server. This is a common catch-all request method used for many data-bearing requests to the server.
* Dynamic: Something that is dynamic changes in response to external stimuli. In the case of HTML templates, dynamic sections of the template are ones that can be replaced or configured with data on-demand.
* Static: Something that is static does not change. In the case of HTML templates, static sections of the template are the ones that cannot be changed and will be the same no matter what data is used with the template.
* MVC: Model-View-Controller, a design pattern that emphasizes the separation of application components into those three categories or layers for more-structured user-facing application development.


# Servers, Templates, and MVC
There are three basic scenarios that comprise the majority of web-based user interaction flows.

* The first is when a user follows a link to our application from an external source, like a marketing email or google search. This kind of cold-call request means will always be a GET request, and our application's responsibility is to choose a response template (appropriate for the request URL - you don't want to send the register.html if the link the user clicked was for /shopping-cart!) and populate it with relevant application data.
* The second scenario is when a user navigates within our app, either by clicking a link or a button or performing some action we need to process on the server, like adding an item to their shopping cart. This case is very similar to the first, as it involves the server choosing a response template and populating it with data, but in this case, the action the user performs is completely up to us - since they're initiating the action from a web page we designed, only the actions we included in that design are available. We can use this to add additional data to requests at the template-level, for example by generating each "add item to cart" button to include the item's identifier in the request that is sent.
* The final scenario is when the user submits completely custom data to our app using form input. This is again similar to the previous two, in that the exact shape of the form is something our template design determines, and that we still need to choose a template to send in response and the data we should use to populate this template. The main difference is that the request no longer includes "safe" data - when a user can enter any data that they'd like, our application is responsible for vetting and validating that data, showing the user an error if something goes wrong.


These scenarios may seem simple, but they are the building blocks of web development. Regardless of the application, user interaction flows on the web are all built out of these basic building blocks.
