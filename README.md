# JSONPlaceholder API Test

This project is an automated test suite for the the JSONPlaceholder API programmed in *Java* and using **Maven** as project software management. **Frameworkium** is used to manage dependencies and
## Index

1. #### [Used Tools](#used-tools-1)
1. #### [Documentation](#documentation-1)
1. #### [Configuration](#configuration-1)
1. #### [How To Run](#how-to-run-1)


## Used Tools

#### JSONPlaceholder API
JSONPlaceholder is public fake API provides different operations on a list of resources. The goal of this is to use for for tutorials, testing new libraries, sharing code examples and projects such as this.

The API and its documentation is available on https://jsonplaceholder.typicode.com/.

#### Frameworkium (Maven, Allure and TestNG)

Frameworkium is an Java framework that provides the code structure guidelines and contains Java libraries to help with writing tests of several types. It can be used for UI, mobile app, API and other forms of testing.

Frameworkium uses Maven as project software management, TestNG as a testing framework and Allure for the generation of the test Report.

More information is available on https://frameworkium.github.io/.

#### Allure Report

It's a open-source framework designed to create a report with graphical representation of the results. This report tool is already included by [Frameworkium](#frameworkium-maven-allure-and-testng) and has compatibility with **TestNG** and **Maven**.

More information is available on http://allure.qatools.ru/.

## Project Documentation

The solution is divided in 4 folders (constant, dto, service and tests).

* **Constant**

The constant folder holds the endpoint of the API as well as the different paths available. It's responsible for retrieving the urls that will be consumed by the services. The endpoints mapped for the tests on the JSONPlaceholder API as the *BASE_URI* and the paths used in the tests.

* **DTO**

In this folder you will find all data structures used to transport data from and to the application.

* **Service**

Here is where the calls to the API service are implemented.

* **Tests**

The test definitions are found here. The methods in this class will connect to the Service class and using the DTOs will verify if the returns from the API are correct. The assertions are made only in this class. Since only little data was needed, it was create within the class but a CSV file or database connection could have been used.

## Configuration

In order to run these tests, you will need to install Java JDK 11 and Maven. Available on the following links:
* [Java JDK 11](https://www.oracle.com/java/technologies/javase-downloads.html#JDK11)
* [Maven](https://maven.apache.org/)

## How To Run

After having the **Java** and **Maven** installed, the tests should run successfully. Open a terminal in the folder where contains the `pom.xml` file, in this case, `JSONPlaceholder_API` folder.

1. ###### Run Automated Tests
    To run the test use the following command:
    ```unix
    mvn clean verify
    ```
    This command will run all the test suite, but if you want to run a specific test use this command:
    ```unix
    mvn clean verify -Dtest=<TestClassName>#<MethodName>
    ```
    If you want to run the List All Resources test for instance, the command would be:
    ```unix
    mvn clean verify -Dtest=ResourceTest#listAllResources
    ```

1. ###### Generate Allure Test Report
    After running the automated tests, you can generate a `HTML` test report running the following command:
    ```unix
    mvn allure:report
    ```

    The location of the report will be shown in the terminal.

