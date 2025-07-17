// Declares the package where this class (interface) is located.
package com.homebotanicalsbible.homebotanicalsbiblebackend.repository;

// Imports the PlantCatalog entity class from the "model" package.
// This is the JPA entity that the repository will interact with.
import com.homebotanicalsbible.homebotanicalsbiblebackend.model.PlantCatalog;

// Imports the JpaRepository interface from Spring Data JPA.
// This provides built-in methods like save(), findAll(), findById(), deleteById(), etc.
import org.springframework.data.jpa.repository.JpaRepository;

// Marks this interface as a Spring Repository component.
// Spring will automatically detect and manage it via component scanning.
import org.springframework.stereotype.Repository;

// Indicates that this interface is a Spring-managed repository bean.
@Repository

// Defines a repository interface for the PlantCatalog entity.
// By extending JpaRepository, it inherits a full set of CRUD operations and query methods.
//
// <PlantCatalog, Long> means:
// - This repository works with PlantCatalog entities.
// - The primary key (ID) of PlantCatalog is of type Long.
public interface PlantCatalogRepository extends JpaRepository<PlantCatalog, Long> {

}

//Notes
//@Repository - Marks the interface as a Spring-managed data access component.
//JpaRepository<PlantCatalog, Long> - Gives full CRUD functionality for PlantCatalog using its Long ID.