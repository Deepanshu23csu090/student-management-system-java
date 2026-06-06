# Student Management System

A workflow-driven Java console application for managing student records using Object-Oriented Programming principles, file persistence, and business-rule validation.

## Workflow Lifecycle

<img width="1181" height="1331" alt="WorkFlow" src="https://github.com/user-attachments/assets/2490108f-6f57-42a0-bd29-88788dc0128b" />


The application implements a student onboarding workflow with status tracking:

PENDING → VERIFIED → APPROVED

or

PENDING/VERIFIED → REJECTED

## Features

* Add Student
* View Students
* Search Student
* Update Student
* Delete Student
* Verify Student
* Approve Student
* Reject Student
* Workflow Status Tracking
* Duplicate ID Validation
* Name Validation
* Exception Handling
* Persistent Storage using students.txt

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections Framework (ArrayList)
* File Handling
* Exception Handling
* Git & GitHub

## Concepts Demonstrated

* Classes and Objects
* Encapsulation
* CRUD Operations
* Workflow Lifecycle Management
* Business Rule Validation
* State Transitions
* Data Persistence
* Input Validation

## Project Structure

StudentManagementSystem

├── Main.java

├── Student.java

├── StudentManager.java

├── students.txt

├── workflow/

│   └── workflow.png

└── README.md

## Screenshots

### Main Menu

<img width="518" height="277" alt="image" src="https://github.com/user-attachments/assets/598509c6-3ad1-42d1-bac8-33c6491d7d17" />


### Student Approval Workflow

<img width="608" height="637" alt="image" src="https://github.com/user-attachments/assets/1efc7076-0661-4f6d-a302-a85e2499ae9c" />

### Approved Student Record

<img width="357" height="552" alt="image" src="https://github.com/user-attachments/assets/df55a580-cd8d-482d-a279-50ffbef7f2e7" />

## Future Enhancements

* MySQL Database Integration
* Spring Boot REST API
* BPMN Workflow Engine Integration
* GUI using JavaFX
* Authentication & Role-Based Access Control

## Learning Outcomes

This project helped strengthen concepts in Java programming, Object-Oriented Design, file handling, workflow lifecycle management, validation techniques, and business process modeling.
