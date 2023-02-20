# Lesson Outline

* MVC and You: We introduce the model-view-controller pattern and discuss how Spring MVC adapts it for use on the web.
* HTML Templates and Thymeleaf: We look at how Thymeleaf's HTML templates work and how we can populate them with data using Spring controllers.
* Connecting Controllers to Templates: We dive deeper into the relationship between controllers and templates to see how to bind data from a web form to a controller method

![Spring MVC and Thymeleaf](https://video.udacity-data.com/topher/2020/June/5ed9745e_l3-03-lesson-outline/l3-03-lesson-outline.png)

## Glossary
* GET Request: an HTTP request for data at a specific URL. This type of request cannot include any additional data.
* POST Request: and HTTP request that usually represents "posting" new data to the server. This is a common catch-all request method used for many data-bearing requests to the server.
* Dynamic: Something that is dynamic changes in response to external stimuli. In the case of HTML templates, dynamic sections of the template are ones that can be replaced or configured with data on-demand.
* Static: Something that is static does not change. In the case of HTML templates, static sections of the template are the ones that cannot be changed and will be the same no matter what data is used with the template.
* MVC: Model-View-Controller, a design pattern that emphasizes the separation of application components into those three categories or layers for more-structured user-facing application development.
* Model: in MVC, the Model is responsible for maintaining the state of an application,
* View: in MVC, the View is responsible for displaying the UI to the user,
* Controller: in MVC, the Controller is responsible for processing user actions (sent from the View) to update the Model, and for forwarding those updates back to the View
* Template: In software development, templates are used in many different contexts - in general, they are a way to define some often-repeated or reused text or code in a specific format, like HTML, along with code hooks that indicate portions of the template that should be replaced dynamically when the template is rendered. In our context, we mostly use Thymeleaf's HTML templates, which mostly look like plain HTML with a few extra Thymeleaf-specific attributes. These attributes are our code hooks, and allow us to define what data Thymeleaf uses when generating the final HTML from our template.
* User Action: Broadly, a user action is simply some specific action a user can take, provided by the user interface they're interacting with. In the case of web applications, we usually think of user actions as clicks on a web page that often result in a HTTP request sent to the backend.
* Prototype/Wireframe In the development process for a web application, it's common to first design the full HTML and CSS for all of the screens a user is expected to see. These pages have no actual functionality, and are usually called prototypes. Wireframes are an even earlier product of the design process, and usually are simple images that show what the prototypes should look like.
* Form-Backing Object: This is a term used by Spring MVC and Thymeleaf to mean an object that represents the data contained in a form. On the Spring side, this is usually an additional argument to the relevant Controller method, and on the Thymeleaf side, this is referred to in the th:object attribute on the form.
