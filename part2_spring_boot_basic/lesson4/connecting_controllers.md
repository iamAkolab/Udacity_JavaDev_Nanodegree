# Connecting Controllers to Templates

The final piece of the Spring MVC puzzle we need to build fully capable web apps is the ability to handle user-submitted data. 
As before, there are two main components to this, one on the template side, the other on the controller side.

* On the template side, we need to define input fields for each piece of data we want to capture, and a <form> element to group them. 
When the form is submitted, the data will be encoded in the HTTP request that is sent, and can be extracted on the Spring side.
* On the Spring side of things, we need to define a POJO to hold the form data. We'll look at code details in the next video, but by defining 
this POJO we can pre-fill the form by setting its fields and adding it as a Model attribute when first rendering the template, and Spring 
can automatically extract the request data into that POJO when the form is submitted. Let's see how that works!
  
## User-Inputted Data
In this video, we looked at the HTML tags and Thymeleaf attribute we need to set up a form for the user to fill and submit to the server. 
Here's the template code saw:
```
<form th:object="${newMessage}" th:action="@{/home}" action="#" method="POST">
    <input th:field="*{text}" type="text">
    <input type="submit">
</form>
```
  
We use the th:object attribute to choose the POJO our form data should be added to, and the th:actionattribute to choose the URL to send the form submission HTTP request to. We use the special @{} syntax in the latter to tell Thymeleaf to make sure the URL is always relative to the actual server address - this doesn't make a huge difference in our current project, but it's good practice when referring to URLs on our server in a Thymleaf template.

We also set method="POST" on the form to set the HTTP method of the resulting request. This is important! Remember that GET requests cannot contain any custom data - we need to use POST for our form data to actually get sent!

In order to bind the individual form input data fields to the form-backing POJO's fields, we need to add the th:field attribute. We also need to use another special Thymeleaf expression syntax - *{}. This allows us to refer to fields on the form-backing POJO without using dot syntax - th:field="*{text}" in this example is equivalent to th:field="${newMessage.text}"
  
## Persisting Data
In this video, we looked at how to handle user-submitted data from the Spring controller side of things. Here are the finalized controller methods we saw:
 ```
    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }
  ```

The key elements to focus on are the new arguments to each of these methods - the MessageForm class is a POJO specifically designed to hold the form data we defined in the previous video.

For the GET request handling method, we declare the MessageForm argument to ensure that the object exists and is added to the model by Spring automatically. This is necessary, because Thymeleaf needs an object with the name newMessage to be present in the model to render properly, even if there isn't any data in the object yet.

For the POST request handling method, we declare the MessageForm argument to tell Spring that it should look for data that matches that in the body of the request we're handling. Spring will then automatically extract that data and put it in a MessageForm object before calling our method, passing it to us so we can use the data as we see fit.

In both cases, we're annotating this argument with @ModelAttribute. This allows us to specify that Spring should add the object to our Model before asking Thymeleaf to render the template. That means we don't have to add it manually! Pretty handy.

# Key Terms
* Form-Backing Object: This is a term used by Spring MVC and Thymeleaf to mean an object that represents the data contained in a form. On the Spring side, this is usually an additional argument to the relevant Controller method, and on the Thymeleaf side, this is referred to in the th:object attribute on the form.

# Exercise: Connecting Controllers to Templates
This is another short HTML snippet like the one from our last exercise, but let’s make things a little trickier! This time, we have two fields and we’d like to map them to the variables on our message form called animalName and adjective.

In the first <h1> element, you should list all the elements in our return list of greetings, just like we learned earlier, but this time we only want to do that if the size of our list is 5 or less. Once the list has more than 5 items in it, we want to display the second <h1> element.
```
<body>
   <form action="#">
       <label for="animalText">Enter an Animal: </label>
       <input type="text" id="animalText" name="animalText">
       <label for="adjective">Enter an Adjective:</label>
       <input type="text" id="adjective" name="adjective">
       <input type="submit">
   </form>
   <h1>Hello, homepage!</h1>
   <h1>I think that's enough!</h1>
</body>
```
  
To complete this exercise. You need to use Thymeleaf to do four things:
* Add an action to the form that directs it to the endpoint /animal using a POST request type and binds the form data to an object called messageForm.
* Bind the input text to two fields called animalName and adjective.
* Display the contents of the list greetings in the first <h1> element. You should display all the elements in the list.
* Use conditional logic to only show the list of greetings if there are 5 or fewer messages. Otherwise, show the message ‘I think that’s enough!’
