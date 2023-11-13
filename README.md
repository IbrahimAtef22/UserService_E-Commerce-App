# UserService_REST-API

This service is my final project in Java Backend Training at JobHacker Community
and it is a part of an E-Commerce app.

This is a Spring Boot application that provides a RESTful API for managing users.
It allows you to perform CRUD operations on users, including getting all users, getting a user by email, adding a new user, updating user details, and deleting a user.

The application also implements basic authentication using Spring Security to ensure that only authorized users can access the API.

## API Endpoints

Once the application is running, you can access the API by making HTTP requests to the following endpoints:

- Get all users: GET http://localhost:8080/users/all
- Get user by email: GET http://localhost:8080/users/{email}
- Add a new user: POST http://localhost:8080/users/add
- Update user: PUT http://localhost:8080/users/update
- Delete user: DELETE http://localhost:8080/users/{email}
- Login user: POST http://localhost:8080/users/login

## Authentication

The application uses basic authentication to secure the API endpoints. To access the endpoints, include the Authorization header in the HTTP request with the value Basic Auth. The username and password should be the credentials of an authorized user stored in the database.

## Technologies Used

- Spring Boot 3.1.3
- Java 17
- MapStruct 1.5.5
- Lombok 1.18.28
- MySQL 8.0.32
- Spring Web
- Spring Data JPA
- Spring Security 6
- Maven