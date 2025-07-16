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