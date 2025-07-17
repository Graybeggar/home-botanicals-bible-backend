// Declares the package where this class (interface) resides — the 'repository' layer of Spring Boot app
package com.homebotanicalsbible.homebotanicalsbiblebackend.repository;

// Imports the GardenPlant model class, which represents the entity this repository will manage
import com.homebotanicalsbible.homebotanicalsbiblebackend.model.GardenPlant;

// Imports Spring Data JPA's JpaRepository interface, which provides built-in CRUD operations
import org.springframework.data.jpa.repository.JpaRepository;

// Marks this interface as a Spring-managed repository bean, making it eligible for component scanning and injection
import org.springframework.stereotype.Repository;

// Indicates that this interface is a Spring Repository component
@Repository

// Declares a repository interface for the GardenPlant entity
// By extending JpaRepository, it inherits methods like save(), findAll(), findById(), delete(), etc.
//
// <GardenPlant, Long> means:
//   - GardenPlant is the type of entity the repository works with
//   - Long is the type of the primary key (id) in the GardenPlant class
public interface GardenPlantRepository extends JpaRepository<GardenPlant, Long> {

}

//Notes
//@Repository - Registers the interface as a Spring bean for data access.
//extends JpaRepository - Gives all standard CRUD methods without writing implementation code.
//GardenPlant, Long - Tells Spring the entity type and its ID type.