# UI Test Automation Framework

This is a personal UI test automation framework built with **Java**, **Selenium**, **Serenity BDD**, **Cucumber**, **JUnit** and **Spring Framework**.

The project uses [Swag Labs](https://www.saucedemo.com/) as the application under test and was created as a **portfolio project to demonstrate practical skills in UI test automation, framework design, BDD and maintainable automation practices**.

---

## Project Goals

The main goals of this project are to demonstrate:

* UI test automation using Selenium WebDriver
* Behaviour-Driven Development (BDD) with Cucumber
* Maintainable test automation architecture
* Environment-specific configuration and secure test data management
* Cross-browser test execution

---

## Technology Stack

| Technology             | Purpose                                               |
| ---------------------- |-------------------------------------------------------|
| **Java 25**            | Programming language                                  |
| **Maven**              | Build and dependency management                       |
| **Selenium WebDriver** | Browser automation                                    |
| **Serenity BDD**       | Test automation framework                             |
| **Cucumber**           | BDD and Gherkin-based test scenarios                  |
| **JUnit 6**            | Test execution infrastructure                         |
| **Spring Framework**   | Dependency injection and configuration                |
| **Jasypt**             | Encryption/decryption of sensitive configuration data |
| **Lombok**             | Boilerplate code reduction                            |

---

## Framework Architecture

The framework separates Gherkin scenarios and step definitions from the underlying automation implementation.

The general flow is:

```text
┌──────────────────┐
│   Feature File   │
│    (Gherkin)     │
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│  Step Definition │
└────────┬─────────┘
         │
         ├──────────────┐
         ▼              ▼
┌────────────────┐  ┌────────────────┐
│     Actions    │  │    Questions   │
└───────┬────────┘  └───────┬────────┘
        │                   │
        └─────────┬─────────┘
                  ▼
        ┌─────────────────────┐
        │ Serenity PageObject │
        └──────────┬──────────┘
                   │
                   ▼
        ┌─────────────────────┐
        │  Selenium WebDriver │
        └─────────────────────┘

```

### Feature Files

Feature files contain the business-readable scenarios written using Gherkin syntax.

They describe **what** should happen rather than how the application should be interacted with.

### Step Definitions

Cucumber step definitions connect Gherkin steps with the automation framework.

Step definitions are intentionally kept lightweight and do not contain hard-coded Selenium interactions or business logic.

Instead, they delegate the actual implementation to Actions and Questions.

### Actions

Actions contain the implementation required to interact with the application.

Examples include:

* Entering credentials
* Clicking buttons
* Navigating through the application
* Interacting with page elements

### Questions

Questions contain the logic used to retrieve or verify information from the application.

This keeps assertions and verification logic separate from the actions that manipulate the application.

### Serenity PageObject

Actions and Questions make use of Serenity BDD's `PageObject` functionality to interact with the browser and application.

This provides access to Serenity's browser interaction capabilities while keeping the test implementation organized and reusable.

---

## Project Structure

```text
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── package
│   │   │       ├── actions
│   │   │       ├── configuration
│   │   │       ├── domain
│   │   │       ├── locators
│   │   │       ├── questions
│   │   │       └── utils
│   │   │
│   │   └── resources
│   │       └── application-*.yaml
│   │
│   └── test
│       ├── java
│       │   └── package
│       │       ├── runner
│       │       └── stepdefs
│       │
│       └── resources
│           ├── features
│           └── serenity.conf
│
├── run_test.sh
├── pom.xml
└── README.md
```

### Main packages

| Package         | Responsibility                                                   |
| --------------- |------------------------------------------------------------------|
| `actions`       | Application interactions and business actions                    |
| `configuration` | Application and environment configuration                        |
| `domain`        | Domain objects, beans and enums                                  |
| `locators`      | Application element locators                                     |
| `questions`     | Verification and assertion-related logic                         |
| `utils`         | Reusable utilities such as waits and browser/window interactions |
| `runner`        | Test suite runner                                                |
| `stepdefs`      | Cucumber step definitions                                        |
| `features`      | Gherkin feature files                                            |

---

## Configuration

Application configuration is separated from the test implementation and stored in environment-specific YAML files.

For example:

```text
src/main/resources/
├── application-test.yaml
├── application-preprod.yaml
└── ...
```

These files can contain environment-specific information such as:

* Application URLs
* User credentials
* Test data
* Other environment-dependent configuration

### Sensitive Data

Sensitive values are encrypted using **Jasypt**.

The encryption password is supplied at runtime through an environment variable.

This allows encrypted configuration to remain in the repository without exposing the key required to decrypt it.

---

### Browser Configuration

Browser configuration is managed through Serenity's `serenity.conf`.

The framework currently supports Chrome, Firefox and Edge.

---

## Running the Tests

### Prerequisites

Make sure the following are installed:

* JDK 25
* Maven
* A supported web browser
* Git

### Execute the Tests

The project can be executed using Maven:

```bash
mvn clean verify -Dcucumber.filter.tags="@Regression" -Djasypt.encryptor.password=${ENCRYPTION_PASSWORD} -Denvironment=chrome -Dspring.profiles.active=test
```

The main parameters used by the execution command are:

| Parameter                   | Purpose                                                                                      |
|-----------------------------|----------------------------------------------------------------------------------------------|
| `cucumber.filter.tags`      | Selects the Cucumber scenarios to execute based on their tags                                |
| `jasypt.encryptor.password` | Provides the password used to decrypt encrypted configuration values                         |
| `environment`               | Selects the browser configuration, e.g. `chrome`, `firefox` or `edge`                        |
| `spring.profiles.active`    | Selects the application environment configuration, e.g. `test` loads `application-test.yaml` |

The `ENCRYPTION_PASSWORD` environment variable must be available in the local environment before executing the tests.

The included `run_test.sh` script can also be used to simplify test execution.

---

