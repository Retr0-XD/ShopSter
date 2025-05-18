# ShopSter - Shop Management System

ShopSter is a comprehensive shop management application with a Spring Boot backend and PostgreSQL database.

## System Requirements

- Java 11+
- Maven
- Docker and Docker Compose
- PostgreSQL (provided via Docker)

## Running the Application

1. Start the PostgreSQL database using Docker Compose:

```bash
docker-compose up -d
```

2. Build and run the Spring Boot backend:

```bash
cd spring-boot-backend
mvn clean install -DskipTests
java -jar target/spring-boot-backend-0.0.1-SNAPSHOT.jar
```

The application will be accessible at http://localhost:8080.

## API Documentation

The API documentation is available using Swagger UI at:

http://localhost:8080/swagger-ui/index.html

## Available Endpoints

### Products

- GET `/api/products` - Get all products
- GET `/api/products/{id}` - Get product by ID
- GET `/api/products/category/{category}` - Get products by category
- GET `/api/products/search?name={searchTerm}` - Search products by name
- POST `/api/products` - Create a new product
- PUT `/api/products/{id}` - Update a product
- DELETE `/api/products/{id}` - Delete a product

### Categories

- GET `/api/categories` - Get all categories
- GET `/api/categories/{id}` - Get category by ID
- POST `/api/categories` - Create a new category
- PUT `/api/categories/{id}` - Update a category
- DELETE `/api/categories/{id}` - Delete a category

### Customers

- GET `/api/customers` - Get all customers
- GET `/api/customers/{id}` - Get customer by ID
- POST `/api/customers` - Create a new customer
- PUT `/api/customers/{id}` - Update a customer
- DELETE `/api/customers/{id}` - Delete a customer

### Orders

- GET `/api/orders` - Get all orders
- GET `/api/orders/{id}` - Get order by ID
- GET `/api/orders/customer/{customerId}` - Get orders by customer ID
- GET `/api/orders/{id}/summary` - Get detailed order summary (with customer and payment info)
- POST `/api/orders` - Create a new order
- PUT `/api/orders/{id}` - Update an order
- DELETE `/api/orders/{id}` - Delete an order

### Employees

- GET `/api/employees` - Get all employees
- GET `/api/employees/{id}` - Get employee by ID
- POST `/api/employees` - Create a new employee
- PUT `/api/employees/{id}` - Update an employee
- DELETE `/api/employees/{id}` - Delete an employee

### Payments

- GET `/api/payments` - Get all payments
- GET `/api/payments/{id}` - Get payment by ID
- POST `/api/payments` - Create a new payment
- PUT `/api/payments/{id}` - Update a payment
- DELETE `/api/payments/{id}` - Delete a payment

### Sample Data

- POST `/api/setup/sample-data` - Initialize sample data

## Database Configuration

The application is configured to connect to PostgreSQL with the following settings:

- Host: localhost
- Port: 5432
- Database: shopster
- Username: postgres
- Password: postgres

## Security

Basic security measures have been implemented, including:

- CORS configuration to allow cross-origin requests
- Input validation for all endpoints

## Next Steps

1. Implement authentication and authorization
2. Create a frontend application to interact with the API
3. Add more advanced features like inventory management and reporting