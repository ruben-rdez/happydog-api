# HappyDog RESTful API

A complete Spring Boot 3.5 REST API for managing Pet resources with CRUD operations.

## 🚀 Technologies

- **Spring Boot 3.5.0**
- **Java 21**
- **Spring Data JPA**
- **MySQL / H2 Database**
- **Lombok**
- **Maven**

## 📦 Project Structure

```
happydog-api/
├── src/main/java/com/happydog/api/
│   ├── HappydogApiApplication.java
│   ├── entity/
│   │   └── Pet.java
│   ├── repository/
│   │   └── PetRepository.java
│   ├── service/
│   │   ├── PetService.java
│   │   └── impl/
│   │       └── PetServiceImpl.java
│   ├── controller/
│   │   └── PetController.java
│   └── exception/
│       ├── ResourceNotFoundException.java
│       ├── ErrorResponse.java
│       └── GlobalExceptionHandler.java
└── src/main/resources/
    └── application.properties
```

## 🔧 Setup Instructions

### Prerequisites
- Java 21
- Maven 3.8+
- MySQL 8.0+ (or use H2 for development)
- IntelliJ IDEA (recommended)

### Database Setup

#### Option 1: MySQL
1. Create database:
```sql
CREATE DATABASE happydog_db;
```

2. Update `application.properties`:
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

#### Option 2: H2 (Development)
Uncomment H2 configuration in `application.properties` and comment out MySQL config.

### Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start at: `http://localhost:8080`

## 📡 API Endpoints

| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET | `/api/pets` | Get all pets | 200 |
| GET | `/api/pets/{id}` | Get pet by ID | 200, 404 |
| POST | `/api/pets` | Create new pet | 201 |
| PUT | `/api/pets/{id}` | Update pet | 200, 404 |
| DELETE | `/api/pets/{id}` | Delete pet | 204, 404 |

## 📝 Sample Request

### Create a Pet
```bash
curl -X POST http://localhost:8080/api/pets \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Buddy",
    "age": 3,
    "weight": 25.5,
    "breed": "Golden Retriever",
    "gender": "Male",
    "color": "Golden"
  }'
```

### Get All Pets
```bash
curl http://localhost:8080/api/pets
```

## 🎯 Features

- ✅ Complete CRUD operations
- ✅ RESTful API design
- ✅ Layered architecture
- ✅ Global exception handling
- ✅ Proper HTTP status codes
- ✅ MySQL & H2 support
- ✅ Lombok integration
- ✅ JPA/Hibernate ORM

## 📄 License

This project is open source and available under the MIT License.

## 👨‍💻 Author

Created with ❤️ for learning Spring Boot development
