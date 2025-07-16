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