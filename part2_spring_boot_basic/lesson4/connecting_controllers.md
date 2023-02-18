# Connecting Controllers to Templates

The final piece of the Spring MVC puzzle we need to build fully capable web apps is the ability to handle user-submitted data. 
As before, there are two main components to this, one on the template side, the other on the controller side.

* On the template side, we need to define input fields for each piece of data we want to capture, and a <form> element to group them. 
When the form is submitted, the data will be encoded in the HTTP request that is sent, and can be extracted on the Spring side.
* On the Spring side of things, we need to define a POJO to hold the form data. We'll look at code details in the next video, but by defining 
this POJO we can pre-fill the form by setting its fields and adding it as a Model attribute when first rendering the template, and Spring 
can automatically extract the request data into that POJO when the form is submitted. Let's see how that works!
  

In this video, we looked at the HTML tags and Thymeleaf attribute we need to set up a form for the user to fill and submit to the server. 
Here's the template code saw:
```
<form th:object="${newMessage}" th:action="@{/home}" action="#" method="POST">
    <input th:field="*{text}" type="text">
    <input type="submit">
</form>
```
  
