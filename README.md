# Automation web project for the cinemark testing environment using Serenity-BDD with Cucumber y screenplay pattern

## How to use

This is a GitHub repository. You can download in .zip format or clone it using the command:
```
git clone https://github.com/cesaragudeloh/cinemark-web-automation.git
```

### Installation

To execute this project, you'll need:

- Java Development Kit (JDK) version 11 or later - [download](https://adoptopenjdk.net/)
- Chrome web browser - [download](https://www.google.com/chrome/)

### Execution

The project can be executed by the command line using the gradle wrapper including inside, like this

```
gradlew clean test aggregate            
```
**gradlew** This is the Gradle Wrapper, a script that comes with your Gradle project. It ensures that the correct Gradle version is used to build your project, even if you don't have Gradle installed locally.

**clean:** This is a Gradle task that cleans your project's build directory, removing any compiled classes, generated files, and previous build artifacts. This helps to ensure a fresh start for the next build.
test: This is another Gradle task that executes all the unit tests in your project. This helps to ensure the correctness of your code.

**aggregate:** This is likely referring to a task that aggregates test reports from different subprojects or modules in your project into a single, combined report. However, this is not a standard Gradle task, and it's possible that it's a custom task defined in your project's build script. 

When executing the tests, the evidence of the execution of the tests will remain in the following directory:

•	$(Repository.Name)/OnlineStore/target/site/serenity