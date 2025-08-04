package com.homebotanicalsbible.homebotanicalsbiblebackend.model; // Package declaration

import jakarta.persistence.*; // JPA annotations for ORM mapping
import lombok.*; // Lombok annotations for reducing boilerplate
import java.util.Objects; // For concise null handling

@Entity // Marks this class as a JPA entity for persistence
@Getter // Lombok: generates getters
@Setter // Lombok: generates setters
@NoArgsConstructor // Lombok: no-args constructor
@AllArgsConstructor // Lombok: all-args constructor
public class Plant { // Entity representing a plant

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
    private Long id; // Unique plant ID

    private String name; // Plant name

    @Column(length = 1000) // Limit description length
    private String description; // Plant description

    private String light; // Light requirement (e.g., Low, Bright)
    private String size; // Size category (e.g., Small, Medium, Large)
    private Boolean petSafe; // Pet safety flag

    private String imageUrl; // Image URL

    @Column(length = 3000) // Limit care instructions length
    private String careInstructions; // Care instructions

    private Integer wateringIntervalDays = 7; // Default watering interval in days

    public Integer getWateringIntervalDays() {
        return wateringIntervalDays;
    }

    public void setWateringIntervalDays(Integer wateringIntervalDays) {
        // Fallback to 7 if null to ensure data integrity
        this.wateringIntervalDays = Objects.requireNonNullElse(wateringIntervalDays, 7);
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