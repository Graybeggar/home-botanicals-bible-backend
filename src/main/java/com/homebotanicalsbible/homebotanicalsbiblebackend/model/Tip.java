package com.homebotanicalsbible.homebotanicalsbiblebackend.model; // Package declaration

import jakarta.persistence.*; // Import JPA annotations for ORM mapping

@Entity // Marks this class as a JPA entity for database persistence
public class Tip { // Entity class representing a tip

    @Id // Marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates id values using identity strategy
    private Long id; // Unique identifier for each tip

    private String text; // The tip's text content

    public Tip() {} // No-argument constructor required by JPA

    public Tip(String text) { // Constructor for creating a tip with text only
        this.text = text;
    }

    public Tip(Long id, String text) { // Constructor for creating a tip with id and text
        this.id = id;
        this.text = text;
    }

    public Long getId() { return id; } // Getter for id
    public String getText() { return text; } // Getter for text
    public void setText(String text) { this.text = text; } // Setter for text
}

// End of Tip class

// Notes:
// - @Entity: Marks the class as a JPA entity, enabling ORM and database persistence.
// - @Id and @GeneratedValue(strategy = GenerationType.IDENTITY): Provide a unique, auto-incremented primary key for each tip.
// - private Long id: Stores the unique identifier for each tip, required for entity management.
// - private String text: Holds the actual tip content, which is the main data for this entity.

// Constructors:
// - No-argument constructor is required by JPA for entity instantiation.
// - Constructor with text allows easy creation of tips with just the content.
// - Constructor with id and text supports scenarios like mapping or manual assignment.

// Getters and setter:
// - getId() and getText() provide access to fields for persistence and business logic.
// - setText() allows updating the tip content.