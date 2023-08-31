# Consuming REST

There are times when you want to consume (or call) publicly accessible web services or APIs in your application. If there is a web service or API available that provides the data you need, it doesn’t make sense for you to build one from scratch. This allows you to deliver your products and services faster to your end users.

[RestTemplate](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) allows you to consume a REST API programmatically from your code.


## REST Case Study
The code can be cloned from [GitLab](https://gitlab.com/videolearning/udacity-java/tree/master/Lesson6-consuming/consuming%20rest%20apis). The publicly accessible Joke API is https://official-joke-api.appspot.com/random_joke.
{
"id":94,
 "type":"general",
 "setup":"Did you hear about the new restaurant on the moon?",
 "punchline":"The food is great, but there’s just no atmosphere."
}

{
 "id":283,
 "type":"general",
 "setup":"What's the best thing about elevator jokes?",
 "punchline":"They work on so many levels."
}

