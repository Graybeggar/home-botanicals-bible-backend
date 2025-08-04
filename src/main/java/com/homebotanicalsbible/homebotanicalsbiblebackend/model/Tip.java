package com.homebotanicalsbible.homebotanicalsbiblebackend.model; // Package declaration

import jakarta.persistence.*; // JPA annotations for ORM mapping

@Entity // Marks this class as a JPA entity
public class Tip { // Entity representing a tip

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    private Long id; // Unique tip identifier

    private String text; // Tip content

    public Tip() {} // JPA-required no-args constructor

    public Tip(String text) { // Constructor with tip text
        this.text = text;
    }

    public Tip(Long id, String text) { // Constructor with id and text
        this.id = id;
        this.text = text;
    }

    public Long getId() { return id; } // ID getter
    public String getText() { return text; } // Text getter
    public void setText(String text) { this.text = text; } // Text setter
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