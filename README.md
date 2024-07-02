# Todo IT - Part 1

## Overview
This is the first part of a three-part project to build a Todo application. This initial phase focuses on creating the fundamental models (classes) with an emphasis on encapsulation and abstraction.

## Project Structure
The project consists of three main classes:
1. Person
2. TodoItem
3. TodoItemTask

Each class is implemented according to specific requirements and includes unit tests.

## Technologies Used
- Java
- Maven
- JUnit 5 for unit testing

## Key Features
- Object-Oriented Programming principles applied
- Encapsulation of data within classes
- Comprehensive unit testing for each class


-------
## Classes 
### Person
Represents an individual user in the system.
- Fields: id, firstName, lastName, email
- Methods: Getters, setters, and getSummary()

### TodoItem
Represents a task to be completed.
- Fields: id, title, description, deadline, done, creator
- Methods: Getters, setters, isOverdue(), and getSummary()

### TodoItemTask
Represents the assignment of a TodoItem to a Person.
- Fields: id, assigned, todoItem, assignee
- Methods: Getters, setters, and getSummary()

## TodoItem
Represents a task to be completed.
- Fields: id, title, description, deadline, done, creator
- Methods: Getters, setters, isOverdue(), and getSummary()


## Part 1 of TODO-IT