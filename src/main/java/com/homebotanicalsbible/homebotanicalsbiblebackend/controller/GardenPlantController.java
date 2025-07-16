// Package declaration: this class is part of the controller package
package com.homebotanicalsbible.homebotanicalsbiblebackend.controller;

// Import the GardenPlant model class to use as a data type
import com.homebotanicalsbible.homebotanicalsbiblebackend.model.GardenPlant;

// Import the JPA repository interface to perform DB operations on GardenPlant entities
import com.homebotanicalsbible.homebotanicalsbiblebackend.repository.GardenPlantRepository;

// Spring annotation that allows dependency injection (@Autowired) and other core features
import org.springframework.beans.factory.annotation.Autowired;

// Annotations for building RESTful APIs
import org.springframework.web.bind.annotation.*;

// Import for using lists as return types
import java.util.List;

// Marks this class as a REST controller — all methods return JSON responses by default
@RestController

// Maps the base URL path "/api/garden" to this controller
@RequestMapping("/api/garden")

// Allows this controller to accept cross-origin requests from the React frontend (running at localhost:5173)
@CrossOrigin(origins = "http://localhost:5173")

// This is the controller class for handling HTTP requests related to GardenPlant entities
public class GardenPlantController {

    // Injects the GardenPlantRepository so it can be used to access the database
    @Autowired
    private GardenPlantRepository gardenPlantRepository;

    // Handles GET requests to /api/garden — returns a list of all plants saved in the garden
    @GetMapping
    public List<GardenPlant> getAllGardenPlants() {
        return gardenPlantRepository.findAll(); // fetch all garden plants from the DB
}

    // Handles POST requests to /api/garden — adds a new plant to the garden
    @PostMapping
    public GardenPlant addPlantToGarden(@RequestBody GardenPlant gardenPlant) {
        return gardenPlantRepository.save(gardenPlant); // save the new plant in the DB
    }

    // Handles PUT requests to /api/garden/{id} — updates the plant with the given ID
    @PutMapping("/{id}")
    public GardenPlant updateGardenPlant(@PathVariable Long id, @RequestBody GardenPlant updatedPlant) {
        // Try to find the plant by ID in the DB
        return gardenPlantRepository.findById(id)
                .map(plant -> {
                    // If found, update its properties with the new values from the request body
                    plant.setLastWatered(updatedPlant.getLastWatered());
                    plant.setNotes(updatedPlant.getNotes());
                    plant.setNickname(updatedPlant.getNickname());
                    // Save the updated plant back to the DB
                    return gardenPlantRepository.save(plant);
    }