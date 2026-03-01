# Book Collection API Tests

The project focuses on automated API tests for a Book Collection Management System. It covers authentication mechanisms, user collection operations (such as adding and removing books), and negative test scenarios related to unauthorized access to the global catalog.

The system under test is based on the DemoQA Book Store application: [DemoQA Book Store](https://demoqa.com/books)

API documentation and available endpoints can be accessed via Swagger: [Swagger API Documentation](https://bookstore.toolsqa.com/swagger/)

The tests were designed based on the official API specification provided in the Swagger documentation.

## Tech Stack

- **Java**
- **Maven**
- **Cucumber (BDD)**
- **REST Assured**
- **JUnit**

## Project Structure
```
src
├── main
│   └── java
└── test
├── java
│   ├── api              # API communication layer
│   ├── services         # Business logic wrappers
│   ├── data             # Test data
│   ├── runners          # Cucumber runner
│   └── stepdefinitions  # Step definitions
└── resources
└── features         # Cucumber feature files
```
## Covered Scenarios

**Authentication**
- Successful login
- Token validation

**User Collection**
- Add book to user collection
- Remove book from user collection

**Negative Case**
- Attempt to add book to global catalog (request rejected)

## How to Run Tests

Run all tests:
```bash
mvn test
```

Run specific runner:
```bash
mvn test -Dtest=TestRunner
```