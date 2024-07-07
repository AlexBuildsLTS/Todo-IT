# Todo IT - Part 1

## Overview
This is the first part of a three-part project to build a Todo application. 
This initial phase focuses on creating the fundamental models (classes) with an
emphasis on encapsulation and abstraction.

## Project Structure
The project consists of three main classes:
1. Person
2. TodoItem
3. TodoItemTask

# Todo Application

## UML Class Diagram

|                      Person                      |                      TodoItem                      |                   TodoItemTask                   |
|--------------------------------------------------|----------------------------------------------------|--------------------------------------------------|
| - id: int                                        | - id: int                                          | - id: int                                        |
| - firstName: String                              | - title: String                                    | - assigned: boolean                              |
| - lastName: String                               | - description: String                              | - todoItem: TodoItem                             |
| - email: String                                  | - deadline: LocalDate                              | - assignee: Person                               |
| + getId(): int                                   | - done: boolean                                    | + getId(): int                                   |
| + getFirstName(): String                         | - creator: Person                                  | + isAssigned(): boolean                          |
| + getLastName(): String                          | + getId(): int                                     | + getTodoItem(): TodoItem                        |
| + getEmail(): String                             | + getTitle(): String                               | + getAssignee(): Person                          |
| + setFirstName(String)                           | + setTitle(String)                                 | + setAssignee(Person)                            |
| + setLastName(String)                            | + isOverdue(): boolean                             | + getSummary(): String                           |
| + setEmail(String)                               | + getSummary(): String                             |                                                  |
| + getSummary(): String                           |                                                    |                                                  |



# Todo IT - Part 2

## Overview
This is the second part of the three-part project to build a Todo application.
In this phase, we focus on adding new classes and enums, as well as modifying the existing ones to enhance functionality and maintainability.

## New Classes and Enums
1. AppUser
2. AppRole (enum)

## Modified Classes
1. Person
2. TodoItem
3. TodoItemTask

## Project Structure

### AppUser Class

|       AppUser       |
|---------------------|
| - username: String  |
| - password: String  |
| - role: AppRole     |
| + getUsername(): String |
| + setUsername(String) |
| + getPassword(): String |
| + setPassword(String) |
| + getRole(): AppRole |
| + setRole(AppRole) |
| + toString(): String |
| + equals(Object): boolean |
| + hashCode(): int  |

### AppRole Enum

|  AppRole    |
|-------------|
| ROLE_APP_USER |
| ROLE_APP_ADMIN |

### Updated UML Class Diagram

|                      Person                      |                      TodoItem                      |                   TodoItemTask                   |                     AppUser                     |
|--------------------------------------------------|----------------------------------------------------|--------------------------------------------------|--------------------------------------------------|
| - id: int                                        | - id: int                                          | - id: int                                        | - username: String                               |
| - firstName: String                              | - title: String                                    | - assigned: boolean                              | - password: String                               |
| - lastName: String                               | - description: String                              | - todoItem: TodoItem                             | - role: AppRole                                  |
| - email: String                                  | - deadline: LocalDate                              | - assignee: Person                               | + getUsername(): String                          |
| - credentials: AppUser                           | - done: boolean                                    | + getId(): int                                   | + setUsername(String)                            |
| + getId(): int                                   | - creator: Person                                  | + isAssigned(): boolean                          | + getPassword(): String                          |
| + getFirstName(): String                         | + getId(): int                                     | + getTodoItem(): TodoItem                        | + setPassword(String)                            |
| + getLastName(): String                          | + getTitle(): String                               | + getAssignee(): Person                          | + getRole(): AppRole                             |
| + getEmail(): String                             | + setTitle(String)                                 | + setAssignee(Person)                            | + setRole(AppRole)                               |
| + getCredentials(): AppUser                      | + isOverdue(): boolean                             |                                                  | + toString(): String                             |
| + setCredentials(AppUser)                        | + toString(): String                               |                                                  | + equals(Object): boolean                        |
| + toString(): String                             |                                                    |                                                  | + hashCode(): int                                |
| + equals(Object): boolean                        |                                                    |                                                  |                                                  |
| + hashCode(): int                                |              