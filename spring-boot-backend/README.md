# ShopSter Backend

This is the backend service for the ShopSter Shop Management System, providing comprehensive REST APIs for shop management operations including inventory, customer, order, employee, and payment processing.

## Project Structure

```
spring-boot-backend
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── demo
│   │   │               ├── DemoApplication.java       # Entry point of the application
│   │   │               ├── controller
│   │   │               │   └── ApiController.java    # Handles HTTP requests
│   │   │               ├── model
│   │   │               │   └── Entity.java           # Data model representation
│   │   │               ├── repository
│   │   │               │   └── EntityRepository.java  # Database operations
│   │   │               └── service
│   │   │                   └── EntityService.java     # Business logic
│   │   └── resources
│   │       ├── application.properties                  # Configuration properties
│   │       ├── static                                  # Static files (CSS, JS, images)
│   │       └── templates                               # Template files
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── demo
│                       └── DemoApplicationTests.java  # Test cases
├── pom.xml                                             # Maven configuration
├── .gitignore                                          # Git ignore file
└── README.md                                           # Project documentation
```

## Setup Instructions

### Prerequisites

- Java 17
- Docker and Docker Compose

### Database Setup

1. **Start the PostgreSQL Database**:
   ```
   # From the root of the project (where docker-compose.yml is located)
   docker-compose up -d
   ```

2. **Verify PostgreSQL is running**:
   ```
   docker ps
   ```
   
   You should see the shopster-postgres container running.

### Running the Application

1. **Build the project**:
   ```
   cd spring-boot-backend
   mvn clean install
   ```

2. **Run the application**:
   ```
   mvn spring-boot:run
   ```

3. **Access the API**:
   The application will run on `http://localhost:8080`.
   
   API Documentation will be available at:
   `http://localhost:8080/swagger-ui/index.html`

## Available APIs

This application provides RESTful APIs for managing:

- **Products**: `/api/products`
- **Customers**: `/api/customers`
- **Orders**: `/api/orders`
- **Employees**: `/api/employees`
- **Categories**: `/api/categories`
- **Payments**: `/api/payments`

Each entity supports the following operations:

- **Create**: POST request 
- **Get All**: GET request 
- **Get One**: GET request with ID
- **Update**: PUT request with ID
- **Delete**: DELETE request with ID

## Deployment to Render

To deploy this application to Render:

1. Create a new PostgreSQL database in your Render dashboard
2. Create a new Web Service that uses the Git repository
3. Set the environment variables to match your Render PostgreSQL database:

   ```
   SPRING_DATASOURCE_URL=jdbc:postgresql://[YOUR_RENDER_POSTGRESQL_HOST]:5432/[YOUR_DB_NAME]
   SPRING_DATASOURCE_USERNAME=[YOUR_RENDER_POSTGRESQL_USERNAME]
   SPRING_DATASOURCE_PASSWORD=[YOUR_RENDER_POSTGRESQL_PASSWORD]
   ```

4. Set the build command to:
   ```
   cd spring-boot-backend && mvn clean package -DskipTests
   ```

5. Set the start command to:
   ```
   cd spring-boot-backend && java -jar target/*.jar
   ```

## Dependencies

This project uses the following dependencies:

- Spring Boot 2.7.5
- Spring Data JPA
- PostgreSQL
- SpringDoc OpenAPI (Swagger UI)

## License

This project is licensed under the MIT License.