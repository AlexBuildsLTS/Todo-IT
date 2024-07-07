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
