package com.homebotanicalsbible.homebotanicalsbiblebackend.repository; // Declares the package for repository classes

import com.homebotanicalsbible.homebotanicalsbiblebackend.model.Tip; // Imports the Tip entity class
import org.springframework.data.jpa.repository.JpaRepository; // Imports the Spring Data JPA repository interface

public interface TipRepository extends JpaRepository<Tip, Long> { // Defines a repository interface for Tip entities with Long as the ID type
}

// Notes:
// package com.homebotanicalsbible.homebotanicalsbiblebackend.repository;
// - Organizes repository interfaces in a dedicated package for maintainability and clarity.

// import com.homebotanicalsbible.homebotanicalsbiblebackend.model.Tip;
// - Imports the Tip entity so the repository can manage its persistence.

// import org.springframework.data.jpa.repository.JpaRepository;
// - Imports the base interface that provides standard CRUD and query methods for JPA entities.

// public interface TipRepository extends JpaRepository<Tip, Long> {}
// - Defines a repository for Tip entities with Long as the ID type, inheriting all basic data access methods from Spring Data JPA.