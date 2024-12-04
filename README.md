# County and user management application

This is a Spring Boot application for managing users and searching for counties. It provides endpoints to create, retrieve, and manage user data. It also provides an endpoint to get a county name 
from the county number.

## Technologies used

- Java
- Spring Boot
- Maven
- H2 Database
- RestTemplate
- Postman (for API testing)

## Getting started

### Clone the repository

```bash
git clone https://github.com/livmettehamre/geo.git
cd geo
```

Build the project
```bash
mvn clean install
```

Run the application
```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080.


## User endpoints
### Create user  
<pre>POST /user </pre> 
Request body:  
<pre>{ "email": "newuser@example.com", "type": "USER" } </pre>
### Get user by ID  
<pre>GET /user/{id} </pre> 
Example:  
<pre>GET /user/1 </pre>
### Get all users for a user type 
<pre>GET /user </pre> 
Example:  
<pre>GET /user?type=USER </pre>
### County endpoint
Get county by number. County number needs to be two digits.  
<pre>GET /county/{countyNumber} </pre> 
Example:
<pre>GET /county/03 </pre>

##### Error handling
If a county number does not exist, a 404 Not Found status will be returned.
If there is an internal server error, a 500 Internal Server Error status will be returned.