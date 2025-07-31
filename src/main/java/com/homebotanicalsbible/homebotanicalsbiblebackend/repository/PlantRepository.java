package com.homebotanicalsbible.homebotanicalsbiblebackend.repository; // Declares the package for repository classes

import com.homebotanicalsbible.homebotanicalsbiblebackend.model.Plant; // Imports the Plant entity
import org.springframework.data.jpa.repository.JpaRepository; // Imports Spring Data JPA repository interface

public interface PlantRepository extends JpaRepository<Plant, Long> { // Defines a repository interface for Plant entities with Long as the ID type
}

// Notes:
//package com.homebotanicalsbible.homebotanicalsbiblebackend.repository;
// - Organizes repository interfaces in a dedicated package for better project structure.

//import com.homebotanicalsbible.homebotanicalsbiblebackend.model.Plant;
// - Imports the Plant entity so the repository can manage its persistence.

//import org.springframework.data.jpa.repository.JpaRepository;
// - Imports the base interface providing CRUD and query methods for JPA entities.

//public interface PlantRepository extends JpaRepository<Plant, Long> {}
// - Defines a repository for Plant entities with Long as the ID type, inheriting all standard data access methods from Spring Data JPA.