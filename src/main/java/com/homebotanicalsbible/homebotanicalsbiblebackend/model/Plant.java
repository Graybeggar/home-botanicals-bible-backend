package com.homebotanicalsbible.homebotanicalsbiblebackend.model; // Package declaration

import jakarta.persistence.*; // Import JPA annotations for ORM mapping
import lombok.*; // Import Lombok annotations to reduce boilerplate

@Entity // Marks this class as a JPA entity for database persistence
@Getter // Lombok: generates getters for all fields
@Setter // Lombok: generates setters for all fields
@NoArgsConstructor // Lombok: generates a no-argument constructor
@AllArgsConstructor // Lombok: generates a constructor with all fields
public class Plant { // Entity class representing a plant

    @Id // Marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates id values using identity strategy
    private Long id; // Unique identifier for each plant

    private String name; // Name of the plant

    @Column(length = 1000) // Limits description field to 1000 characters in the database
    private String description; // Description of the plant

    private String light; // Light requirements (e.g., Low, Bright)
    private String size;  // Size category (e.g., Small, Medium, Large)
    private Boolean petSafe; // Indicates if the plant is safe for pets

    private String imageUrl; // URL to an image of the plant

    @Column(length = 3000) // Limits careInstructions field to 3000 characters
    private String careInstructions; // Detailed care instructions

    private Integer wateringIntervalDays = 7; // Default watering interval in days

    public Integer getWateringIntervalDays() { // Getter for watering interval
        return wateringIntervalDays;
    }

    public void setWateringIntervalDays(Integer wateringIntervalDays) { // Setter with default fallback
        this.wateringIntervalDays = (wateringIntervalDays != null) ? wateringIntervalDays : 7;
    }
}

// End of Plant class

// Notes:
// - @Entity: Makes the class a JPA entity, enabling ORM and database persistence.
// - Lombok annotations (@Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor): Reduce boilerplate by auto-generating common methods and constructors.
// - @Id and @GeneratedValue(strategy = GenerationType.IDENTITY): Provide a unique, auto-incremented primary key for each plant.
// - Field choices (name, description, light, size, petSafe, imageUrl, careInstructions): Represent essential plant attributes for the application.
// - @Column(length = ...): Set character limits for large text fields to optimize database storage and prevent overflow.
// - wateringIntervalDays with default value and custom setter: Ensures a sensible default and guards against null assignments, improving data integrity.