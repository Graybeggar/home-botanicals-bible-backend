# 🌿 Home Botanicals Bible Backend

Welcome to the backend API for **Home Botanicals Bible**, your plant care companion!  
This Spring Boot service manages plant data and gardening tips, powering a rich frontend experience for plant lovers.

---

## ✨ Highlights

- 🌱 Manage detailed plant info: names, descriptions, light & watering needs, pet safety, and care tips  
- 📚 CRUD operations on plants and tips via clean REST endpoints  
- 🔄 Auto realignment of plant IDs for database consistency  
- 🌐 CORS enabled for seamless frontend-backend integration  
- 🚀 Built with Spring Boot, JPA, and a MySQL database backend  

---

## ℹ️ Overview

This project is the backend service powering **Home Botanicals Bible**, an app designed to help users care for their plants with personalized tips and reminders. It exposes RESTful API endpoints to add, update, fetch, and delete plants and gardening tips.

The backend uses Spring Boot for rapid development and Spring Data JPA for convenient database operations. It stores plant and tip data in a relational database, with features like default watering intervals and daily rotating tips to enrich the user experience.

---

Installation
Prerequisites
Java 17 or newer

Maven or Gradle (for building the project)

MySQL or compatible relational database (configured in application properties)

Steps
Clone the repository:


git clone https://github.com/yourusername/homebotanicalsbible-backend.git
Configure your database settings in src/main/resources/application.properties.

Build the project:


mvn clean install
or if using Gradle:


./gradlew build
Run the Spring Boot application:


mvn spring-boot:run


💡 Usage Examples
Fetch all plants:
GET /api/plants

## Useful Resources

- [Building a RESTful Web Service - Spring Guide](https://spring.io/guides/gs/rest-service/)
- [Spring @RequestMapping Guide - Baeldung](https://www.baeldung.com/spring-requestmapping)
- [Spring Boot REST API Tutorial with MySQL, JPA & Hibernate - Callicoder](https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/)
- [Handling CORS in Spring - Baeldung](https://www.baeldung.com/spring-cors)
- [Constructor Injection in Spring - Baeldung](https://www.baeldung.com/constructor-injection-in-spring)
- [Spring @RequestMapping POST Examples - Baeldung](https://www.baeldung.com/spring-requestmapping#post)
- [Spring Boot CRUD with Thymeleaf - Baeldung](https://www.baeldung.com/spring-boot-crud-thymeleaf)
- [Introduction to Java 8 Date and Time API - Baeldung](https://www.baeldung.com/java-8-date-time-intro#localdate)
- [Accessing Data with JPA - Spring Guide](https://spring.io/guides/gs/accessing-data-jpa)
- [Project Lombok: @Getter and @Setter](https://projectlombok.org/features/GetterSetter)
- [Spring Boot JPA Hibernate PostgreSQL RESTful CRUD API Example - Callicoder](https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/)
- [Java Persistence API: EntityManager - Oracle Docs](https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html)
- [Spring Data JPA Query Methods - Baeldung](https://www.baeldung.com/spring-data-jpa-query)
- [Getting Started with Spring Boot - Baeldung](https://www.baeldung.com/spring-boot-start)
- [Spring Boot First Application Tutorial](https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application)

Link to Wireframe: https://lucid.app/lucidchart/c7417e79-d8f3-4be6-b534-6b647baab445/edit?page=uP1BopAARZY8&invitationId=inv_f13fc2ec-2e86-42bd-80c3-5af43ed6b8d9#

Link to ER Diagram: https://dbdiagram.io/d/68755881f413ba3508d340be

🌟 Future Features

✅ User Authentication & Roles

Register, login, password reset

Admin role for managing the plant catalog

✅ Push Notifications & Reminders

Remind users to water or fertilize their plants

✅ Plant Recommendations

Suggest plants based on light conditions or skill level

✅ Weather Integration

Suggest plant care tips based on local weather data

✅ Community Tips & Comments

Users can submit and vote on care tips

✅ Favorite Plants

Let users favorite or bookmark plants

✅ Better Watering Schedule

Option to track watering frequency with notifications



Get today's gardening tip:
GET /tip-of-the-day

Add new plants (JSON body):
```json
[
  {
    "name": "Aloe Vera",
    "description": "A succulent plant species of the genus Aloe.",
    "light": "Bright indirect",
    "size": "Medium",
    "petSafe": true,
    "imageUrl": "https://example.com/aloe.jpg",
    "careInstructions": "Water every 2 weeks.",
    "wateringIntervalDays": 14
  }
