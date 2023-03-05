# JUnit in Situ

When we write tests, it's with the intention to run them and report on the results. Test runners like JUnit provide many ways to report the results of a test run, but one of the most useful ways to interact with that reporting is through an IDE, like IntelliJ.

There are three main advantages to running JUnit tests from an IDE:

* Interactive Reporting: When we run tests in an IDE, we can usually inspect the results of each test individually. If an assertion fails or an unexpected exception is triggered, the stack trace and circumstances will be shown in the details for each test, and clickable links in the results help you navigate to problem areas in your code.
* Interactive Debugging: When a pernicious problem persists, it can often be helpful to step through the code's execution line-by-line to inspect both the control flow and the values in memory used by the program. This is called debugging, and while it's technically possible to do outside of an IDE, IDEs like IntelliJ provide many useful tools for making the process as painless as possible.
* Code Coverage Reports: When we run code in an IDE like IntelliJ, we can choose to have the IDE track which lines of our code were visited, and how many times. This can be wildly useful when trying to track down why a branch of a condition isn't being reached, as well as when determining how much the entire code base is covered by the currently-implemented tests.
