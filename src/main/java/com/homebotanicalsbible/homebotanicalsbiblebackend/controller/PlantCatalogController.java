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