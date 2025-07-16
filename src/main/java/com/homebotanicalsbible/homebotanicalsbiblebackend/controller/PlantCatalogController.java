// Defines the package
package com.homebotanicalsbible.homebotanicalsbiblebackend.controller;

// Import the PlantCatalog entity/model class
import com.homebotanicalsbible.homebotanicalsbiblebackend.model.PlantCatalog;

// Import the repository interface that provides database access methods for PlantCatalog
import com.homebotanicalsbible.homebotanicalsbiblebackend.repository.PlantCatalogRepository;

// Import annotation to allow Spring to automatically inject dependencies
import org.springframework.beans.factory.annotation.Autowired;

// Import Spring annotations used to define RESTful web controllers and route requests
import org.springframework.web.bind.annotation.*;

// Import List class to return a list of PlantCatalog objects
import java.util.List;

// Marks this class as a REST controller — it handles HTTP requests and returns data (usually JSON)
@RestController

// Sets the base path for all request mappings in this controller to /api/plants
@RequestMapping("/api/plants")