# JUnit and Selenium

Selenium and JUnit are a natural fit for one another. Both are plain Java libraries, and don't require any special syntax or approach to integrate with one another. We can use Selenium's driver to navigate the web, interact with elements on the page, and extract data from those elements, and we can use JUnit's assertions to check the data that is returned against expected values.

Selenium also requires some initialization logic, like setting up the web driver and navigating to the correct URL to perform further actions on. JUnit's ```@BeforeAll``` annotation is perfect for writing a method to initialize the web driver, and we can use the ```@BeforeEach``` annotation to write a method that navigates to a common starting URL for all tests in the class. Finally, since we need to make sure we quit the web driver once our tests are finished, we can use JUnit's ```@AfterAll``` annotation to define a method that takes care of that.

Selenium provides another useful tool for JUnit test organization - the Page Object. A Page Object is a Java class that is meant to represent a specific web page under test. We can use Page Objects to reduce boilerplate when writing Selenium scripts, and, as we'll see in the next video, we can even use them to make our test code resemble the user stories under test.Selenium and JUnit are a natural fit for one another. Both are plain Java libraries, and don't require any special syntax or approach to integrate with one another. We can use Selenium's driver to navigate the web, interact with elements on the page, and extract data from those elements, and we can use JUnit's assertions to check the data that is returned against expected values.

Selenium also requires some initialization logic, like setting up the web driver and navigating to the correct URL to perform further actions on. JUnit's @BeforeAll annotation is perfect for writing a method to initialize the web driver, and we can use the @BeforeEach annotation to write a method that navigates to a common starting URL for all tests in the class. Finally, since we need to make sure we quit the web driver once our tests are finished, we can use JUnit's @AfterAll annotation to define a method that takes care of that.

Selenium provides another useful tool for JUnit test organization - the Page Object. A Page Object is a Java class that is meant to represent a specific web page under test. We can use Page Objects to reduce boilerplate when writing Selenium scripts, and, as we'll see in the next video, we can even use them to make our test code resemble the user stories under test.


# Coding Example - CounterPage
https://github.com/udacity/nd035-c1-spring-boot-basics-examples/tree/master/udacity-jwdnd-c1-l5-junit-and-selenium-master

In the previous video, we looked at a simple counter application, with some text to display the current count, an increment button, and a reset button. Our goal is to write some JUnit and Selenium code to test that all of the essential features of the app are functioning correctly. First, though, we want a Selenium Page Object to represent the page we're testing. Here's the full ```CounterPage``` class from the example:

```
public class CounterPage {

    @FindBy(id = "count-display")
    private WebElement countDisplay;

    @FindBy(id = "increment-button")
    private WebElement incrementButton;

    @FindBy(id = "reset-value-field")
    private WebElement resetValueField;

    @FindBy(id = "reset-button")
    private WebElement resetButton;

    public CounterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int getDisplayedCount() {
        return Integer.parseInt(countDisplay.getText());
    }

    public void incrementCount() {
        incrementButton.click();
    }

    public void resetCount(int value) {
        resetValueField.clear();
        resetValueField.sendKeys(String.valueOf(value));
        resetButton.click();
    }
}
```

There are three main sections to this, and any, Page Object:

## Defining Element Selectors 
```
    @FindBy(id = "count-display") 
    private WebElement countDisplay;

    @FindBy(id = "increment-button")
    private WebElement incrementButton;

    @FindBy(id = "reset-value-field")
    private WebElement resetValueField;

    @FindBy(id = "reset-button")
    private WebElement resetButton;
```

The goal of a Page Object is to simplify and abstract away common Selenium tasks, like finding elements on the page. Previously, we did this with ```driver.findElement``` and ```driver.findElements```, but in a Page Object, we can take a much more Spring-like approach by declaring annotated fields representing the elements we want to capture on the page. These element selectors will be automatically processed by Selenium, but we have to kick that process off ourselves - which we do in the next section:

## Initializing Elements in the Constructor 
```
Java public CounterPage(WebDriver driver) { PageFactory.initElements(driver, this); }
```

In this example, we declare a WebDriver as the only constructor argument, and we call ```PageFactory.initElements()``` with the driver and the ```this``` keyword as arguments. This is shorthand to tell Selenium to use the given driver to initialize the ```@FindBy```-annotated fields in the class. In principle, we could do this somewhere else, but as we'll see in the next video, initializing a Page Object in its constructor like this is pretty flexible and clean.

By adding this constructor, whenever we create a new ```CounterPage``` object, Selenium will automatically find and capture the elements we declared, reducing a bunch of similar calls to ```driver.findElement``` to a single ```new CounterPage()``` instantiation. Once we have those elements, we can move on to the next section:

## Creating Helper Methods 
```
   public int getDisplayedCount() { 
        return Integer.parseInt(countDisplay.getText()); 
    }
        
    public void incrementCount() {
        incrementButton.click();
    }

    public void resetCount(int value) {
        resetValueField.clear();
        resetValueField.sendKeys(String.valueOf(value));
        resetButton.click();
    }
```

Now that our Page Object has selected elements from the page it represents, we can define helper methods that encapsulate common tasks for the page. In this counter example, we need to be able to read the current count from the screen, we need to be able to increment the count, and we need to reset the count. Notice that I didn't mention any specific elements to describe the functionality of these actions - while we have to be specific in our implementation of these methods, as you can see in the code above, the goal of writing these helpers is to separate the action taken on the class from the specific element interactions required to fulfill that action. In some ways, this is another instance of separation of concerns - by hiding the implementation details in these methods, if the HTML of the page ever changes, we don't have to update anything except the code inside this class - the tests that will use this class can just continue to call the same methods they did before.

Speaking of tests - now that we've set up the ```CounterPage``` class, we can finally implement some tests for this app.
