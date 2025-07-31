package com.homebotanicalsbible.homebotanicalsbiblebackend.service; // Declares the package for the service class

import jakarta.persistence.EntityManager; // Imports EntityManager for database operations
import jakarta.persistence.PersistenceContext; // Imports annotation to inject EntityManager
import org.springframework.stereotype.Service; // Imports Service annotation to mark this as a Spring service
import org.springframework.transaction.annotation.Transactional; // Imports annotation to manage transactions

@Service // Marks this class as a Spring service component
public class PlantService { // Defines the PlantService class

    @PersistenceContext // Injects the EntityManager for persistence operations
    private EntityManager entityManager; // EntityManager instance for executing queries

    @Transactional // Ensures all operations in this method run in a single transaction
    public void realignPlantIds() { // Method to reset and realign plant IDs

        entityManager.createNativeQuery( // Executes a native SQL query
                "CREATE TABLE plant_temp AS SELECT name, description, light, size, petSafe, imageUrl, careInstructions, wateringIntervalDays FROM plant" // Creates a temporary table with selected columns from plant
        ).executeUpdate(); // Runs the query

        entityManager.createNativeQuery("TRUNCATE TABLE plant").executeUpdate(); // Removes all data from plant table

        entityManager.createNativeQuery("ALTER TABLE plant AUTO_INCREMENT = 1").executeUpdate(); // Resets auto-increment counter

        entityManager.createNativeQuery( // Executes a native SQL query
                "INSERT INTO plant (name, description, light, size, petSafe, imageUrl, careInstructions, wateringIntervalDays) " + // Inserts data back into plant table
                        "SELECT name, description, light, size, petSafe, imageUrl, careInstructions, wateringIntervalDays FROM plant_temp" // Selects data from temporary table
        ).executeUpdate(); // Runs the query

        entityManager.createNativeQuery("DROP TABLE plant_temp").executeUpdate(); // Drops the temporary table
    }
}

// Notes:
// package com.homebotanicalsbible.homebotanicalsbiblebackend.service;
// - Organizes the service class in a dedicated package for better structure and maintainability.

// import jakarta.persistence.EntityManager;
// - Imports the EntityManager to perform direct database operations.

// import jakarta.persistence.PersistenceContext;
// - Allows Spring to inject the EntityManager automatically.

// import org.springframework.stereotype.Service;
// - Marks the class as a Spring service, enabling component scanning and dependency injection.

// import org.springframework.transaction.annotation.Transactional;
// - Ensures that the method runs within a transaction for data consistency.

// @Service
// - Declares the class as a service layer component in the Spring context.

// @PersistenceContext
// - Injects the EntityManager for database access.

// @Transactional
// - Guarantees that all database changes in the method are atomic.

// realignPlantIds()
// - Encapsulates the logic to reset and realign plant IDs, keeping the operation reusable and maintainable.

// Native SQL queries
// - Used for direct control over table structure and data manipulation, which is not easily achieved with JPA methods.