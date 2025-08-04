package com.homebotanicalsbible.homebotanicalsbiblebackend.service;
// Declares the package this class belongs to

import jakarta.persistence.EntityManager;
// Allows direct interaction with the persistence context (i.e., the database)

import jakarta.persistence.PersistenceContext;
// Injects the EntityManager instance into this class

import org.springframework.stereotype.Service;
// Marks the class as a Spring service component

import org.springframework.transaction.annotation.Transactional;
// Ensures that method execution is wrapped in a database transaction

@Service
// Indicates that this class is a service bean managed by Spring
public class PlantService {

    @PersistenceContext
    // Injects an EntityManager instance for database operations
    private EntityManager entityManager;

    @Transactional
    // Ensures the method executes in a single transaction (atomic operation)
    public void realignPlantIds() {
        // Step 1: Back up existing data into a temporary table
        entityManager.createNativeQuery(
                "CREATE TABLE plant_temp AS " +
                        "SELECT name, description, light, size, petSafe, imageUrl, careInstructions, wateringIntervalDays " +
                        "FROM plant"
        ).executeUpdate();

        // Step 2: Clear the original table
        entityManager.createNativeQuery("TRUNCATE TABLE plant").executeUpdate();

        // Step 3: Reset the auto-increment ID counter
        entityManager.createNativeQuery("ALTER TABLE plant AUTO_INCREMENT = 1").executeUpdate();

        // Step 4: Re-insert the data from the temporary table back into the original table
        entityManager.createNativeQuery(
                "INSERT INTO plant (name, description, light, size, petSafe, imageUrl, careInstructions, wateringIntervalDays) " +
                        "SELECT name, description, light, size, petSafe, imageUrl, careInstructions, wateringIntervalDays " +
                        "FROM plant_temp"
        ).executeUpdate();

        // Step 5: Drop the temporary table
        entityManager.createNativeQuery("DROP TABLE plant_temp").executeUpdate();
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