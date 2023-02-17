# Server-Wide Configuration

Spring Boot does a lot to simplify the setup of a new Spring application, but sometimes, you need to change how it works. 
That's what the application.properties file is for! You can find it in the src/main/resources folder of a generated Spring 
Boot project, and it allows you to configure anything from the server's hostname and port to the size and colors of the Spring 
logo that appears in the console when starting an application.

## Key Terms
* Properties File: A file with the .properties extension that consists of plain-text key=value pairs separated by new lines. 
This format is often used by Java libraries and frameworks because it provides a simple way to specify named constants in a plain text file.

# When You have to Use XML Configuration
Spring's annotation-based configuration is really convenient and allows us to see directly in our Java code how Spring is configured. This is a new API, though, and Spring's original configuration format was through XML.

We won't be using this older format in the course, but it's important to be aware of because it's still supported by Spring, and many older projects still use it. The key thing to remember is that Spring's annotation- and XML-based configuration systems are both equally capable of configuring Spring, so if you ever find yourself in a situation where you need one but only know how to do it in the other, you can always find a way to translate between them.

## Key Terms
* Legacy: In a programming context, legacy usually refers to older code that still functions or is expected to function, but is on the verge of being made obsolete by newer technologies. A legacy application is one that is no longer being actively built upon, and is instead in maintenance mode.
* XML: eXtensible Markup Language. This is a flexible data format that allows for extension, as the name suggests. Many applications and libraries use XML as a way to store structured application data out of memory, and it's also a popular data interchange format on the web.
