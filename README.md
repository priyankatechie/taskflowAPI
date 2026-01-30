

# taskflowAPI
TaskFlow API – A Spring Boot–based REST API with MySQL, featuring secure JWT authentication and task management.

# Project Description
This is a secure Task Management API built with Spring Boot and MySQL. 
Designed with scalability in mind, the system uses JWT (JSON Web Tokens) to handle user authentication and authorization safely. 
I developed this project to demonstrate core backend principles, including structured RESTful design, data validation, and efficient database management through ORM. 
It serves as a practical example of how to build a robust, real-world service that focuses on security and clean code.

TaskFlow allows users to:
Register and log in securely
Create, update, delete, and view tasks
Track task status and priority
Access protected APIs using JWT tokens
------------------------------------------------------------------------------------------------------------
# Technology Used
Category        |     	Technology
Language        |       Java 17
Framework       |       Spring Boot 
Database        |       My SQL
Security        |       Spring Security + JWT
ORM             |       Hibernate / JPA
Validation      |       Jakarta Validation 
Build Tool      |       Maven
API Testing     |       Postman 
----------------------------------------------------------------------------------------------------------
# Install 
- Java 17 
- IDE (Spring Tool for Eclipse / Vs Code )
- My SQL
- Postman
----------------------------------------------------------------------------------------------------------
# Architecture

        | Controller | -> | Service | -> | Repository | -> | Database |
              |
              |
        |  DTOs & Validation |
              |
              |
         | JWT Security Filter |
----------------------------------------------------------------------------------------------------------


# Project Structure
- controller – Handles API requests
- service – Business logic
- repository – Database operations
- entity – Database entities
- dto – Request validation
- security – JWT and security configuration

  ---------------------------------------------------------------------------------------------------------
  # Project Structure 
    
      com.taskflow
     ├── controller
     │ ├── AuthController
     │ └── TaskController
     ├── dto
     │ ├── LoginRequest
     │ ├── RegisterRequest
     │ └── TaskRequest
     ├── entity
     │ ├── User
     │ └── Task
     ├── repository
     │ ├── UserRepository
     │ └── TaskRepository
     ├── security
     │ ├── JwtFilter
     │ ├── JwtUtil
     │ └── SecurityConfig
     ├── service
     │ ├── UserService
     │ └── TaskService
     └── TaskFlowApplication

     -------------------------------------------------------------------------------------------------------
  # Database Design

-- User Table --
Field     |    	Type
id	      |      Long (PK)
name	    |      String
email	    |      String (Unique)
password  |      String
role      |      Enum

-- Task Table --
Field         |    	Type
id	          |       Long (PK)
title	        |       String
description   |       String
status	      |       Enum (PENDING, IN_PROGRESS, COMPLETED)
priority      |       Enum (LOW, MEDIUM, HIGH)
user_id	      |       FK

----------------------------------------------------------------------------------------------------------
  # Validation ( DTO)
  Implemented using Jakarta Validation:
- Email must be valid
- Password minimum 6 characters
- Task title cannot be blank
- Status & Priority must be valid enums
-----------------------------------------------------------------------------------------------------------
# API EndPoints

1) AuthAPI
Method	 |    Endpoint	           |    Description
POST	   |   /api/auth/registed  |    Register user
POST	   |   /api/auth/login	   |    Login & get token

2) Task APIs (JWT Required)
Method   |    	Endpoint	       |     Description
POST	   |    /api/tasks	       |     Create task
GET      |    /api/tasks	       |     Get all tasks
GET      |  	/api/tasks/{id}    |     Get task by ID
PUT      |    /api/tasks/{id}	   |     Update task
DELETE   |  	/api/tasks/{id}	   |      Delete task

-----------------------------------------------------------------------------------------------------------
# Application Configuration
application.properties

  spring.application.name=taskflow_api

spring.datasource.url=jdbc:mysql://localhost:3306/taskflow_db
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=taskflow_secret_key_123
jwt.expiration=86400000

-----------------------------------------------------------------------------------------------------------
#How to Install and Run the Project (Step‑by‑Step)

Make sure the following are installed:
-- Java 17 or above
-- MySQL 8.0+
-- IDE (IntelliJ IDEA / Eclipse / VS Code / Spring Tool for Eclipse )
-- Postman (for API testing)


  Step 1: Clone the Repository
  git clone https://github.com/your-username/taskflow-api.git
   cd taskflow-api

  Step 2: Create MySQL Database
 -  Login to My SQL
 -  create a Database --> CREATE DATABASE taskflow_db;
 -  Use taskflow_db;

  Step 3: Configure Application Properties
  - src/main/resources/application.properties
  - Add that above code 
  
 
  Step 4: Install Dependencies
  - Run Maven build:
  - mvn clean install

  Step 5: Run the Application
  - Using Maven: mvn spring-boot:run
        OR 
  -  Open TaskFlowApplication.java
     Right‑click → Run

   Step 6 : Verify Application
     - Once application start it runs on --> http://localhost:8080 

- for testing API  --> http://localhost:8080/api/auth/register
- 

   Step 7 : Test APIs Using Postman
  1)  Open Postman
  2) Register a user → /api/auth/register
  3)  Login → /api/auth/login
  4) Copy JWT token from response
  5) Add Header: Authorization: Bearer <JWT_TOKEN>
  6) Access protected task APIs

  Step 8 : Database Auto - Creation
  Tables are automatically created by Hibernate
  Check in MySQL:
        USE taskflow;
        SHOW TABLES;
-----------------------------------------------------------------------------------------------------------
   The application will start on `http://localhost:8080`
-----------------------------------------------------------------------------------------------------------
  # Environment Variables
- DB_URL
- DB_USERNAME
- DB_PASSWORD
- JWT_SECRET

-----------------------------------------------------------------------------------------------------------
# API Documentation
APIs can be tested using Postman. Authentication APIs are public, and task APIs require a valid JWT token.

    
Project Successfully Running 🎉
You can now perform full CRUD operations on tasks using secured APIs.
  
