# HTML Templates with Thymeleaf

The nature of Spring MVC's data flow - the controller has to provide the data for the template it wants to render - means that often, 
when designing a new user-facing feature, it makes sense to start with the template.

Thymeleaf is the HTML template engine we're using in this class, which means that it's a library that can take a template, a data model,
and combine them to generate a final HTML document.

The way that Thymeleaf applies the data model to the template is based on the Thymeleaf attributes we add to the template, like th:text 
from the previous lecture on MVC. These attributes can have complex expressions as their values, which are processed by Thymeleaf in the 
context of the data model provided. In the next video, we'll look at some of the effects those attributes and expressions can achieve!

In addition to setting text values, we can use Thymeleaf attributes to perform basic control flow in our templates. The main two types of 
control flow in templates are iteration and conditional rendering.

Iteration in Thymeleaf templates works very similarly to an enhanced for-loop in Java. The main attribute used in template iteration is th:each, 
and its use looks like this:
```
<h1  th:each="msg : ${greetings}" th:text="${msg}">Hello, homepage!</h1>
```
We can read the attribute th:each="msg : ${greetings}" as "for each msg in greetings", and it essentially means "repeatedly render this element 
for each value in the greetings collection, and name that element msg for any expressions that need that name to have a value associated with it.

So in this example, the h1 tag will be repeatedly rendered, once for each element in greetings, and the text rendered by th:text="${msg}" will be 
the current element of greetings being rendered. If greetings contained the Strings "Hi" and "Hello", the final rendered html would be
```
<h1>Hi</h1>
<h1>Hello</h1>
```

Conditional rendering in Thymeleaf usually looks like an if statement in Java, or occasionally a switch statement. The attribute we examined in the 
example was th:unless, as in:
```
<h1  th:unless="${msg.contains('goodbye')}" th:text="${msg}">Hello, homepage!</h1>
```
In this case, if the msg contains the String "goodbye", the h1 tag will not be rendered. This is particularly useful when choosing whether or not to 
render an error message, for example. If you need the opposite condition, in this case only showing messages that contain "goodbye", you can simply 
replace the th:unless with th:if.

![How Thymeleaf Renders a View](https://video.udacity-data.com/topher/2020/July/5f247177_l3-32-html-templates-with-thymeleaf-1/l3-32-html-templates-with-thymeleaf-1.png)

The figure above shows how Thymeleaf renders a view. In order to render a view, Thymeleaf must be given a template and a model to use. Thymeleaf scans 
through the template to find dynamic data expressions and resolves the variables in those expressions using the model. Some dynamic data expressions 
result in iterated or conditional rendering in addition to more typical text replacement.

## Key Terms
* User Action: Broadly, a user action is simply some specific action a user can take, provided by the user interface they're interacting with. In the case 
of web applications, we usually think of user actions as clicks on a web page that often result in a HTTP request sent to the backend.
* Prototype/Wireframe In the development process for a web application, it's common to first design the full HTML and CSS for all of the screens a user is 
expected to see. These pages have no actual functionality, and are usually called prototypes. Wireframes are an even earlier product of the design process, 
and usually are simple images that show what the prototypes should look like.

# Exercise: HTML Templates with Thymeleaf
Let’s start with a simple example on our new webpage, simple-home.html. We have two different messages for our page, and we want to pick one or the other depending on whether we’re first landing on the page, or if we’ve submitted the form.

