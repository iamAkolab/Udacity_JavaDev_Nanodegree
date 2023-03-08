# Selenium/WebDrive

Our goal in this section is to expand our testing acumen beyond simple unit tests into the realm of integration tests. Specifically, we want to be able to test our 
web application's abilities from the high-level perspective of user actions. In order to do this, we need a way to programmatically simulate a user's action in the 
browser. That's where Selenium comes in.

Selenium is a cross-platform tool for browser automation and scripting, and we're going to use it to write tests that simulate a user's actions in a browser. In the 
next video, we'll look at how Selenium's API functions in detail.

![The Architecture of Selenium](https://user-images.githubusercontent.com/77028341/222947978-f91bdbad-053f-4bfe-ae28-6e0b08213540.png)
The figure above shows the architecture of selenium. Test scripts written using Selenium's Java API are translated by Selenium to work on different browsers using different drivers.


In this video, we looked at the basic elements of a Selenium script. Here's the full script we examined:

```
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("selenium");
        inputField.submit();
        List<WebElement> results = driver.findElements(By.cssSelector("div.g a"));
        for (WebElement element : results) {
            String link = element.getAttribute("href");
            System.out.println(link);
        }
        Thread.sleep(5000);
        driver.quit();
    }
    ```
Every Selenium script has to start by initializing a web driver. Since we're using WebDriverManager (documentation links below), we can use it to automatically download the binary file for Selenium's driver for Google Chrome, and then we can initialize the driver without any additional work.

Once we have a driver, we need to tell it which web page to visit. We do this with driver.get("http://www.google.com"); in the script, but if we were testing one of our own applications, like the message page from earlier this course, we would have to change the URL to something like http://localhost:8080/home.

In order to interact with or extract data from the web page, we first need to select the required HTML elements on the page. In this example, we use driver.findElement(By.name("q")); to select the google search input element. A detailed explanation of this process can be found below.

In order to interact with the elements we've selected, we can call various methods on them. In this case, we're using inputField.sendKeys("selenium"); to simulate typing the word selenium into google, and we're using inputField.submit(); to simulate submitting the search form.

Once we've interacted with the web page, we want to read in the results and print them out. Again, we use the same process for finding an element, but this time, we use driver.findElements() to get a list of matching elements, instead of a single one.

The final part of every Selenium script is shutting down the driver. Since the driver is an external program, if we don't call driver.quit(), the automated browser window will never close on its own.

## Key Terms
* Web Driver: In order for Selenium to assume control of a browser, it needs a program to interface with the specific browser's API. This program is called a web driver, and there are different web drivers for each major browser.
