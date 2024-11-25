# User Management System

This repository contains a **User Management System** implemented in **Java** using **Spring Boot**. It provides CRUD operations for managing user data, leveraging RESTful APIs, and integrating with a database using JPA and Hibernate.

---

## Features

- Create a new user.
- Retrieve a list of all users.
- Get details of a specific user by ID.
- Update user information.
- Delete a user by ID.
- Input validation using **Jakarta Validation** annotations.
- Robust exception handling for invalid inputs and resource not found scenarios.

---

## Project Structure

### 1. **Controller**
`UserController`  
Handles API requests and routes them to the service layer.  
Endpoints:
- `POST /users` - Create a new user.
- `GET /users` - Get all users.
- `GET /users/{id}` - Get a user by ID.
- `PUT /users/{id}` - Update a user by ID.
- `DELETE /users/{id}` - Delete a user by ID.

---

### 2. **Model**
- `UserEntity`  
  Entity class representing the database structure.
- `UserPOJO`  
  Plain Old Java Object (POJO) with validation rules for user input.
- `UserMapper`  
  Utility for converting between `UserEntity` and `UserPOJO`.

---

### 3. **Repository**
`UsersRepo`  
Extends `JpaRepository` for database operations.

---

### 4. **Service**
- `UserServices`  
  Interface defining the methods for user operations.
- `UserServicesImpl`  
  Implementation of `UserServices`, containing the business logic.

---

## Validation Rules
User input is validated using **Jakarta Validation** annotations:
- `name`: Must not be blank.
- `email`: Must be a valid email format.
- `password`: Must:
  - Be at least 8 characters long.
  - Contain at least one digit, one lowercase letter, one uppercase letter, and one special character.

---

## Technologies Used
- **Java**  
- **Spring Boot**  
- **Hibernate/JPA**  
- **Jakarta Validation**  
- **Maven**  
- **MySQL**  

---

## Getting Started

### Prerequisites
- Java 17 or higher
- MySQL database
- Maven

### Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/user-management-system.git
   cd user-management-system
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/<your-database>
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## API Endpoints

| HTTP Method | Endpoint       | Description             |
|-------------|----------------|-------------------------|
| POST        | `/users`       | Create a new user       |
| GET         | `/users`       | Get all users           |
| GET         | `/users/{id}`  | Get user by ID          |
| PUT         | `/users/{id}`  | Update user by ID       |
| DELETE      | `/users/{id}`  | Delete user by ID       |

---

## Example Request and Response

### Create a New User
**Request:**  
`POST /users`  
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "P@ssw0rd123"
}
```
**Response:**  
`201 Created`  
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "P@ssw0rd123"
}
```



## Acknowledgments
This project demonstrates the integration of Spring Boot with Hibernate, JPA, and RESTful web services for learning and implementation purposes.
