// Declares the package where this class is located.
// This is the root package for the entire Spring Boot application.
package com.homebotanicalsbible.homebotanicalsbiblebackend;

// Imports the SpringApplication class, which is used to launch the Spring Boot application.
import org.springframework.boot.SpringApplication;

// Imports the @SpringBootApplication annotation, which marks this class as the main entry point.
// It also enables component scanning, auto-configuration, and configuration support.
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation does three things:
// 1. @Configuration – marks the class as a source of bean definitions.
// 2. @EnableAutoConfiguration – enables Spring Boot’s auto-configuration based on dependencies.
// 3. @ComponentScan – enables scanning for @Component, @Service, @Repository, and @Controller classes.
@SpringBootApplication

// Declares the main application class.
// This class serves as the entry point when starting the Spring Boot application.
public class HomeBotanicalsBibleBackendApplication {

    // This is the main method that gets called when the app starts.
    // It delegates to Spring Boot to start the entire application context.
    public static void main(String[] args) {
        // This line starts the Spring Boot application by:
        // - Initializing the Spring context
        // - Starting embedded server
        // - Performing classpath scanning
        // - Setting up all Spring-managed beans
        SpringApplication.run(HomeBotanicalsBibleBackendApplication.class, args);
    }
}

// Notes
//@SpringBootApplication - Flags the main config class and enables auto-setup, scanning, and config.
//SpringApplication.run(...) - Boots the Spring context, initializes beans, and starts the app.
//main(String[] args) - Standard Java entry point for running a Java app.