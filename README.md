# rest-task-mate

#  Project Description
This simple library application with:
- creating, deleting, editing, displaying books 
- creating, deleting, editing, displaying authors

##  Project Structure

This Project is based on 3-layered architecture:

- Data access layer (repository)

- Application layer (service)

- Presentation layer (controllers)

## Technologies:
- JAVA 11+
- Spring Boot, REST, Spring Boot Data JPA
- Git
- SQL
- Maven

## System requirements

- IntelliJ IDEA Ultimate IDEA
- Postman
- Database (H2 -database in memory)

## Configure you env

- First, make sure your env meets requirements listed above
- Then clone project on your IDE
- Install Postman
- After loading app you can test app in Postman using next urls:

POST http://localhost:8080/authors (create author)

POST http://localhost:8080/books (create book)

PUT http://localhost:8080/authors/1 (get author by id and update him)

PUT http://localhost:8080/books/1 (get book by id and update it)

DELETE http://localhost:8080/authors/1 (delete author)

DELETE http://localhost:8080/books/1 (delete book)

GET http://localhost:8080/books/by-author-name?authorName=... (displaying list of books by author name)

GET http://localhost:8080/books/most-selling?authorName=... (displaying most selling book by author name)

GET http://localhost:8080/books/most-published?authorName=... (displaying most published book by author name)

GET http://localhost:8080/books/most-selling/by-part-name?authorPartName=... (displaying list of most selling 
books by part author name)

GET http://localhost:8080/most-published/by-part-name?authorPartName=... (displaying list of most published
books by part author name)

GET http://localhost:8080/books/most-successful-book/by-part-name?authorPartName=...
(displaying list of most successful books by part author name)