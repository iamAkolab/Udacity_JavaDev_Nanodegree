# Selenium/WebDriver

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
