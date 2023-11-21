Project: eCommerce Application
Authentication and Authorization
Success Criteria	Specifications
Demonstrate appropriate repository management using git.

All project code has been organized properly and is in git, with proper branching.

No extra files have been included using .gitignore.

Demonstrate correct handling of authorization with proper security using JWT.

App validates authentication of the user to let them into the project. Proper JWT headers are present and utilized correctly.

The following are only accessible after authenticated:

Logged in, user profile
Cart details
Purchase History
Password should check some length requirement and a confirmation field in the request to check for typos
Write proper tests for the above module and meet an acceptable code coverage level.

Code coverage of 60% is met through tests. The tests include sanity and regression test cases and take care of negative tests as well.

Metrics, Dashboards and Alerts
Success Criteria	Specifications
Identify the correct metrics to log, to monitor the system and Index metrics to Splunk.

The code traces at least the following:

CreateUser request successes
CreateUser request failures
Exceptions
order requests successes
order requests failures
Logs are indexed to Splunk.

The code sets up at least one alert (of your choice) for the system. For example: Create dashboard for success rate per minute of any one CreateUser and order, and take a screenshot.

Screenshots are provided showing some query results and the alert setup.

CI/CD
Success Criteria	Specifications
Demonstrate configuration and automation of the CI/CD pipeline.

The submission manages build and deployment of the application with Jenkins:

Submission includes logs or screenshot showing successful Jenkins build and project setup
Suggestions to Make Your Project Stand Out
Setup Jenkins in docker and submit a screenshot of the result

Create a docker image for the project and deploy it to a docker container; submit a screenshot of the result
