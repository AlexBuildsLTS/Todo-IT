# Todo IT - Part 1

## Overview
This is the first part of a three-part project to build a Todo application. This initial phase focuses on creating the fundamental models (classes) with an emphasis on encapsulation and abstraction.

## Project Structure
The project consists of three main classes:
1. Person
2. TodoItem
3. TodoItemTask

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






