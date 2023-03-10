# JUnit and Selenium

Selenium and JUnit are a natural fit for one another. Both are plain Java libraries, and don't require any special syntax or approach to integrate with one another. We can use Selenium's driver to navigate the web, interact with elements on the page, and extract data from those elements, and we can use JUnit's assertions to check the data that is returned against expected values.

Selenium also requires some initialization logic, like setting up the web driver and navigating to the correct URL to perform further actions on. JUnit's ```@BeforeAll``` annotation is perfect for writing a method to initialize the web driver, and we can use the ```@BeforeEach``` annotation to write a method that navigates to a common starting URL for all tests in the class. Finally, since we need to make sure we quit the web driver once our tests are finished, we can use JUnit's ```@AfterAll``` annotation to define a method that takes care of that.

Selenium provides another useful tool for JUnit test organization - the Page Object. A Page Object is a Java class that is meant to represent a specific web page under test. We can use Page Objects to reduce boilerplate when writing Selenium scripts, and, as we'll see in the next video, we can even use them to make our test code resemble the user stories under test.Selenium and JUnit are a natural fit for one another. Both are plain Java libraries, and don't require any special syntax or approach to integrate with one another. We can use Selenium's driver to navigate the web, interact with elements on the page, and extract data from those elements, and we can use JUnit's assertions to check the data that is returned against expected values.

Selenium also requires some initialization logic, like setting up the web driver and navigating to the correct URL to perform further actions on. JUnit's @BeforeAll annotation is perfect for writing a method to initialize the web driver, and we can use the @BeforeEach annotation to write a method that navigates to a common starting URL for all tests in the class. Finally, since we need to make sure we quit the web driver once our tests are finished, we can use JUnit's @AfterAll annotation to define a method that takes care of that.

Selenium provides another useful tool for JUnit test organization - the Page Object. A Page Object is a Java class that is meant to represent a specific web page under test. We can use Page Objects to reduce boilerplate when writing Selenium scripts, and, as we'll see in the next video, we can even use them to make our test code resemble the user stories under test.


# Coding Example
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

Defining Element Selectors 
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

