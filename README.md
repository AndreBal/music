This Spring Boot application demonstrates a one-to-many relationship between two objects, `Artist` and `Song`, and provides REST APIs to perform CRUD operations on these objects.

## Models

### Artist

The `Artist` model represents a musical artist entity with the following properties:

- `id`: Int (auto-generated)
- `name`: String represents name of the artist
- `songs`: List of associated `Song` objects
- `isActive`: Boolean that shows whether the artist's career continues
- `country`: String of artist's country of origin
- `albumsNum`: Int of artist's number of albums
- `genre`: String of artist's main music genre

### Song

The `Song` model represents a song entity with the following properties:

- `id`: Int (auto-generated)
- `name`: String represents name of the song
- `year`: Int represents year of song recording
- `duration`: Int song duration in seconds
- `number`: Int number of song in album
- `album`: String the name of the album containing the song
- `artist`: Associated `Artist` object, represents song performer

## Dependencies

The project has the following dependencies:

- Spring Boot Starter Web: Provides the necessary dependencies to build RESTful APIs.
- Spring Boot Starter Data JPA: Provides the dependencies to work with JPA and the database.
- MySQL Connector: Enables connectivity to a MySQL database.
- HikariCP: Provides the connection pool implementation for database connection management.
- Lombok: Reduces boilerplate code by generating getter, setter, and other utility methods.
- Spring Boot Starter Test: Provides dependencies for testing the application.

## Prerequisites

To run this application, you need to have the following installed on your system:

- Java Development Kit (JDK) 11 or later
- MySQL database server
- Maven (for building the project)

## How to Run the Application

1. Clone the repository to your local machine.
git clone <repository-url>

2. Execute musicdb-init.sql to create app database

3. Navigate to the project directory.
cd music

4. Build and run the application using Maven.
mvn spring-boot:run

The application will start, and you can access the REST APIs at http://localhost:8080

## API Documentation

Artist APIs

GET /api/artists: Retrieve all artists.

GET /api/artists/{id}: Retrieve a artist by ID.

POST /api/artists: Create a new artist.

PUT /api/artist/{id}: Update a artist by ID.

DELETE /api/artists/{id}: Delete a artist by ID.


Song APIs

GET /api/songs: Retrieve all songs.

GET /api/songs/{id}: Retrieve an song by ID.

POST /api/songs: Create a new song.

PUT /api/songs/{id}: Update an song by ID.

DELETE /api/songs/{id}: Delete an song by ID.
