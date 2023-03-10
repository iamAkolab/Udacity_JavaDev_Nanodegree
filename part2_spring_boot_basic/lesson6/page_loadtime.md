## Page Load Times
In the real world, things get complicated, fast. Nowhere is this more apparent than when trying to account for page load times when automating user testing.

On the web, page load times can vary wildly according to different internet providers, the size of the resources a page has to load, the speed at which the server handles requests, and so on. It's virtually impossible to predict exactly when a page will load, and this presents a problem for testing; if we ask Selenium to find an element on a page before the page finishes loading, it's going to fail and we're going to have something like a big, fat NullpointerException or a StaleElementReferenceException on our hands. The StaleElementReferenceException may occur in case of a delayed-reload.

So how do we make sure an element is on the page before we ask Selenium to look for it?

The answer is to use a WebDriverWait, which is a class Selenium provides just for this purpose. Let's look at the following code:

WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement marker = wait.until(webDriver -> webDriver.findElement(By.id("page-load-marker")));
In this example, we create a new WebDriverWait instance using a driver and a timeout in seconds. WebDriverWait defines a method called until that we use in the next line to force Selenium to pause until the specified element is found, or the timeout is reached.

This is extremely handy, since we can now ensure that Selenium waits and continues in a structured way.
