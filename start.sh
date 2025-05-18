#!/bin/bash

# Start PostgreSQL container
echo "Starting PostgreSQL container..."
docker-compose up -d

# Wait for PostgreSQL to be ready
echo "Waiting for PostgreSQL to be ready..."
sleep 5

# Build and run the Spring Boot application
echo "Building and running Spring Boot application..."
cd spring-boot-backend
./mvnw spring-boot:run
