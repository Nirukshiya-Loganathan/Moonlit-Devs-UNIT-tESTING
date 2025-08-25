# Library System Unit Testing

This repository contains the unit testing implementation for a Library Management System. It demonstrates the testing of key modules, focusing on data access objects (DAOs) and database connectivity. The purpose of this repository is to showcase best practices in unit testing for Java applications using JUnit 5

## Project Overview

The project focuses on:

- Testing the UserDAO and BookDAO classes which handle CRUD operations.
- Verifying database connections via DatabaseHelper.
- Ensuring data integrity and proper handling of edge cases.
- Using mocks for isolating database dependencies.

 The actual Library System source code is located in a separate repository . 


## Technologies Used

- Java 11 – Main programming language
- JUnit 5  – Testing framework
- Maven – Project management and build tool
- Mockito – Mocking objects for unit tests
- MySQL – Database (for testing connection, can be mocked)
- Maven Surefire Plugin – Test execution and reporting



## Features Tested

 UserDAO
  - Add, retrieve, update, and delete users
  - Get all users
- BookDAO
  - Add, retrieve, update, and delete books
  - Get all books
- DatabaseHelper
  - Successful and failed database connections
- Edge cases and input validation
