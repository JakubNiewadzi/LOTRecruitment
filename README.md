# LOTRecruitment

Flight and passenger management app.

# How to run

* Clone this repository
* Navigate to directory with compose.yml file
* Use docker compose command

```bash
docker compose up [-d]
```

* If there is a problem with compose, you may want to change the line separator in mvnw to LF

* Navigate to http://localhost:8080/swagger-ui/index.html in your browser

# Tech stack

* Java 17
* Spring Boot 3.2.4
* Spring Data Jpa
* Hibernate Validator
* PostgreSQL
* OpenApi Swagger
* Lombok
* Docker

# Documentation

Documentation has been written with the help of Open API.

* Flight api preview
<div align="center">
    <img src=".github/screenshots/flight_api.png" alt="flight api preview">
</div>

* Passenger api preview
<div align="center">
    <img src=".github/screenshots/passenger_api.png" alt="passenger api preview">
</div>

* Example schema definitions
<div align="center">
    <img src=".github/screenshots/schema_definitions.png" alt="schema definitions">
</div>

* Post request example
<div align="center">
    <img src=".github/screenshots/add_passenger_request.png" alt="post request">
</div>

* Post response example
<div align="center">
    <img src=".github/screenshots/add_passenger_response.png" alt="post response">
</div>