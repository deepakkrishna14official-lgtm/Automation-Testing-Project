# Ecommerce Website Automation Testing Project

## 📌 Project Overview

This is a Selenium-based automation testing project developed for an ecommerce website that I created using AI.

The project was developed as a practical Software Testing portfolio project to demonstrate hands-on experience in web automation testing using Java, Selenium WebDriver, and TestNG.

The framework automates important ecommerce functionalities and uses reusable page classes, data-driven testing, Excel-based test data, explicit waits, and automatic screenshots for failed test cases.

---

# 🛠️ Technologies & Tools

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Apache POI**
- **WebDriverManager**
- **Page Object Model (POM)**
- **Eclipse IDE**
- **Git**
- **GitHub**
---

## 🌐 Application Under Test

The application under test is an ecommerce website created using AI.

The website contains common ecommerce functionalities such as:

- User registration
- User login
- Product search
- Product details
- Product variations
- Product quantity controls
- Add to Cart
- Product offers
- Delivery pincode checking
- Cart functionality
- Checkout functionality
- User profile functionality

The website was used as the application under test for developing and executing the Selenium automation framework.

---

# 🏗️ Automation Framework

The framework follows the Page Object Model (POM) design pattern.

The application pages are maintained as separate Page Object classes containing their locators and reusable actions.

The test classes are separated from the page classes so that test logic and page-level actions remain organized.

The framework also contains reusable utilities for common Selenium operations.

-> Key framework features

- Page Object Model
- Reusable page methods
- Explicit waits
- TestNG assertions
- Soft Assertions
- TestNG DataProviders
- Excel-based test data
- Screenshot capture on test failure
- Maven dependency management
- Browser driver management using WebDriverManager

---

# 📂 Project Structure

```text
Kartly-AI-Website
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Base
│   │   │   ├── DriveFactory
│   │   │   ├── Pages
│   │   │   └── Utilities
│   │   │
│   │   └── resources
│   │       └── Config.Properties
│   │
│   └── test
│       ├── java
│       │   ├── DataProviders
│       │   ├── tests
│       │   └── TestNG
│       │
│       └── resources
│           └── LogInData Ecommerce.xlsx
│
├── ScreenShots
│
├── pom.xml
├── testng.xml
├── .gitignore
├── target/
└── test-output/
