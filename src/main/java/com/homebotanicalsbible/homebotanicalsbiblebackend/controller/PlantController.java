package com.homebotanicalsbible.homebotanicalsbiblebackend.controller; // Declares the package for this controller class

import com.homebotanicalsbible.homebotanicalsbiblebackend.model.Plant; // Imports the Plant model
import com.homebotanicalsbible.homebotanicalsbiblebackend.repository.PlantRepository; // Imports the Plant repository interface
import com.homebotanicalsbible.homebotanicalsbiblebackend.service.PlantService; // Imports the Plant service class
import org.springframework.web.bind.annotation.*; // Imports Spring Web annotations for REST controllers
import org.springframework.http.ResponseEntity; // Imports Response Entity for HTTP responses
import java.util.List; // Imports List for handling collections

@RestController // Marks this class as a REST controller
@RequestMapping("/api/plants") // Sets the base URL for all endpoints in this controller
@CrossOrigin(origins = "*") // Allows cross-origin requests from any domain
public class PlantController { // Declares the PlantController class

    private final PlantRepository plantRepository; // Declares a final reference to the PlantRepository
    private final PlantService plantService; // Declares a final reference to the PlantService

    public PlantController(PlantRepository plantRepository, PlantService plantService) { // Constructor for dependency injection
        this.plantRepository = plantRepository; // Assigns the injected PlantRepository
        this.plantService = plantService; // Assigns the injected PlantService
    }

    @GetMapping // Handles HTTP GET requests to /api/plants
    public List<Plant> getAllPlants() { // Returns a list of all plants
        return plantRepository.findAll(); // Fetches all plants from the repository
    }

    @PostMapping // Handles HTTP POST requests to /api/plants
    public ResponseEntity<List<Plant>> addPlants(@RequestBody List<Plant> plants) { // Adds a list of plants from the request body
        plants.forEach(plant -> { // Iterates over each plant
            if (plant.getWateringIntervalDays() == null) { // Checks if watering interval is not set
                plant.setWateringIntervalDays(7); // Sets default watering interval to 7 days
            }
        });
        return ResponseEntity.ok(plantRepository.saveAll(plants)); // Saves all plants and returns them in the response
    }

    @DeleteMapping // Handles HTTP DELETE requests to /api/plants
    public ResponseEntity<Void> deletePlants(@RequestBody List<Long> ids) { // Deletes plants by their IDs from the request body
        plantRepository.deleteAllById(ids); // Deletes all plants with the given IDs
        return ResponseEntity.noContent().build(); // Returns a 204 No Content response to indicate success
    }

    @DeleteMapping("/{id}") // Handles HTTP DELETE request to /api/plants/{id}
    public ResponseEntity<Void> deletePlantById(@PathVariable Long id) { // Deletes a single plant by ID
        if (plantRepository.existsById(id)) { // Checks if plant with the given ID exists
            plantRepository.deleteById(id); // Deletes the plant
            return ResponseEntity.noContent().build(); // Returns 204 No Content for successful deletion
        }
        return ResponseEntity.notFound().build(); // Returns 404 Not Found if plant does not exist
    }

    @PostMapping("/realign-ids") // Handles HTTP POST requests to /api/plants/realign-ids
    public ResponseEntity<Void> realignPlantIds() { // Realigns plant IDs using the service
        plantService.realignPlantIds(); // Calls the service to realign IDs
        return ResponseEntity.noContent().build(); // Returns a 204 No Content response
    }

    @PutMapping("/{id}") // Handles HTTP PUT requests to /api/plants/{id}
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant updatedPlant) { // Updates an existing plant by ID
        return plantRepository.findById(id) // Finds the plant by ID
                .map(existingPlant -> { // If found, update the fields
                    copyPlantProperties(updatedPlant, existingPlant); // Copies updated fields to existing plant
                    Plant savedPlant = plantRepository.save(existingPlant); // Saves the updated plant
                    return ResponseEntity.ok(savedPlant); // Returns 200 OK with updated plant
                })
                .orElse(ResponseEntity.notFound().build()); // Returns 404 Not Found if plant doesn't exist
    }

    // Helper method to copy all relevant properties from source to target Plant
    private void copyPlantProperties(Plant source, Plant target) {
        target.setName(source.getName()); // Updates the plant's name
        target.setDescription(source.getDescription()); // Updates the plant's description
        target.setLight(source.getLight()); // Updates the light requirement
        target.setSize(source.getSize()); // Updates the plant size
        target.setPetSafe(source.getPetSafe()); // Updates pet safety info
        target.setImageUrl(source.getImageUrl()); // Updates the image URL
        target.setCareInstructions(source.getCareInstructions()); // Updates care instructions
        target.setWateringIntervalDays(source.getWateringIntervalDays()); // Updates watering interval
    }

} // End of PlantController class

// Notes:
// - Used @RestController and @RequestMapping to define clear REST endpoints for plant management.
// - Constructor injection for PlantRepository and PlantService improves testability and loose coupling.
// - Defaulted watering interval to 7 days for data consistency when not provided.
// - Allowed CORS from any origin with @CrossOrigin to support frontend development.
// - Used ResponseEntity for flexible and explicit HTTP responses.
// - Returned 204 No Content for delete and realign operations to indicate successful processing without returning data.
// - Added a realign-ids endpoint to maintain sequential plant IDs in the database.
// - Added a PUT endpoint to update an existing Plant by ID with full field updates and appropriate 404 handling.
// - Added a DELETE endpoint to delete a single plant by ID with existence check and appropriate 404 handling.
// - Extracted a helper method copyPlantProperties() to keep updatePlant method concise and clear.
