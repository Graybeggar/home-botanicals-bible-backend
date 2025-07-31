package com.homebotanicalsbible.homebotanicalsbiblebackend; // Declares the package for the main application class

import org.springframework.boot.SpringApplication; // Imports Spring Boot's class to launch the application
import org.springframework.boot.autoconfigure.SpringBootApplication; // Imports annotation to enable auto-configuration and component scanning

@SpringBootApplication // Marks this class as a Spring Boot application entry point
public class HomeBotanicalsBibleBackendApplication { // Defines the main application class
    public static void main(String[] args) { // Main method, application entry point
        SpringApplication.run(HomeBotanicalsBibleBackendApplication.class, args); // Starts the Spring Boot application
    }
}

// Notes:
// package com.homebotanicalsbible.homebotanicalsbiblebackend;
// - Organizes the main application class in a dedicated package for clarity and maintainability.

// import org.springframework.boot.SpringApplication;
// - Imports the class needed to launch the Spring Boot application.

// import org.springframework.boot.autoconfigure.SpringBootApplication;
// - Imports the annotation that enables auto-configuration and component scanning, simplifying setup.

// @SpringBootApplication
// - Marks this class as the entry point for Spring Boot, enabling essential framework features.

// public class HomeBotanicalsBibleBackendApplication
// - Defines the main application class, following Spring Boot naming conventions.

// public static void main(String[] args)
// - Provides the standard Java entry point for running the application.

// SpringApplication.run(HomeBotanicalsBibleBackendApplication.class, args);
// - Starts the Spring Boot application, initializing the context and all components.