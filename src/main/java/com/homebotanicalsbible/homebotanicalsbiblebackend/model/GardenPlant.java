// Package declaration — this file belongs to the "model" package of the backend
package com.homebotanicalsbible.homebotanicalsbiblebackend.model;

// Import JPA annotations like @Entity, @Id, @GeneratedValue, @ManyToOne, @JoinColumn, etc.
import jakarta.persistence.*;

// Import Lombok annotations to automatically generate boilerplate code (getters, setters, constructors)
import lombok.*;

// Import Java's LocalDate class for date handling
import java.time.LocalDate;

// Marks this class as a JPA entity, meaning it maps to a database table
@Entity

// Lombok annotation to generate getter methods for all fields
@Getter

// Lombok annotation to generate setter methods for all fields
@Setter

// Lombok annotation to generate a no-argument constructor (required by JPA)
@NoArgsConstructor

// Lombok annotation to generate a constructor with all fields as parameters
@AllArgsConstructor

// This is the entity class representing a plant in the user's personal garden
public class GardenPlant {

    // Marks this field as the primary key for the table
    @Id

    // Auto-generates the ID using the database's identity strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A user-defined nickname for the plant ("Spikey" for a cactus)
    private String nickname;

    // The date the plant was last watered
    private LocalDate lastWatered;

    // Any custom notes the user wants to save about the plant
    private String notes;

    // Defines a many-to-one relationship: many GardenPlant entries can relate to one PlantCatalog entry
    @ManyToOne

    // Specifies the foreign key column in the database that links to PlantCatalog
    @JoinColumn(name = "plant_id")
    private PlantCatalog plant;
}

//Notes
//@Entity - Maps this class to a garden_plant table (table name is inferred unless specified)
//Primary Key (@Id)	- Uniquely identifies each garden plant
//nickname, lastWatered, notes - Fields stored in the database
//@ManyToOne with @JoinColumn - Connects this garden entry to a plant in the main PlantCatalog (foreign key plant_id)
//Lombok Annotations - Eliminate need to manually write constructors, getters, and setters