🌿 Home Botanicals Bible Backend
Welcome to the backend API for Home Botanicals Bible, your plant care companion! This Spring Boot service manages plant data and gardening tips, powering a rich frontend experience for plant lovers.

✨ Highlights
🌱 Manage detailed plant info: names, descriptions, light & watering needs, pet safety, and care tips
📚 CRUD operations on plants and tips using clean REST endpoints
🔄 Auto realignment of plant IDs for database consistency
🌐 CORS enabled for seamless frontend-backend integration
🚀 Built with Spring Boot, JPA, and a MySQL database backend

ℹ️ Overview
This project is the backend service powering Home Botanicals Bible, an app designed to help users care for their plants with personalized tips and reminders. It exposes RESTful API endpoints to add, update, fetch, and delete plants and gardening tips.
The backend uses Spring Boot for rapid development and Spring Data JPA for convenient database operations. It stores plant and tip data in a relational database, with features like default watering intervals and daily rotating tips to enrich the user experience.

🚀 Quick Start

Prerequisites

Java 17+ installed
Maven
MySQL database

Installation
Clone the repo and run:
git clone https://github.com/yourusername/homebotanicalsbible-backend.git
cd homebotanicalsbible-backend
mvn clean install
mvn spring-boot:run

Configure your database connection in src/main/resources/application.properties before starting.

💡 Usage Examples
Fetch all plants:
GET /api/plants

Add new plants (JSON body):
[
  {
    "name": "Aloe Vera",
    "description": "Succulent known for medicinal uses.",
    "light": "Bright",
    "size": "Medium",
    "petSafe": true,
    "wateringIntervalDays": 3,
    "careInstructions": "Water every 3 days, indirect sunlight."
  }
]

Get today's gardening tip:
GET /tip-of-the-day
