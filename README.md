# Public-Library-Book-Management-System
# Library System Management System

A Java-based console application for managing a library's collection of books, handling loans, and performing various administrative tasks.

## Overview

This Library Management System similiar to a digital library system provides a complete solution for library management with separate interfaces for library managers and users. The system allows for efficient management of books, including adding new books, editing book details, searching for books, and handling book loans.

## Features

### For Library Managers
- Add new books to the library collection
- Delete books from the collection
- Edit book details (title, publisher, publication year, author, genre)
- View all books in the library
- Search books by title
- Find books by their unique ID

### For Library Users
- View all books available in the library
- Search for books by title
- Find books by their unique ID
- Borrow books with a specified due date
- Return borrowed books

## System Architecture

The system is built with object-oriented design principles using the following key components:

### Core Classes
- **LibraryItem**: Abstract base class for all library items with common attributes
- **Book**: Represents a book with additional book-specific attributes
- **Loan**: Represents a book loan transaction with book and due date information
- **Library**: Main class representing the physical library and its operations
- **Utility**: Helper class providing utility methods for library operations
- **ItemNotFoundException**: Custom exception for handling cases when items are not found
- **LibrarySystem**: Main class with the user interface and menu system

### Sorting and Searching Algorithms
- Selection Sort: Used to sort library items by ID
- Insertion Sort: Used to sort books by publication year
- Binary Search: Used to efficiently find books by their ID

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (Eclipse, IntelliJ IDEA, etc.) or command-line tools

### Compilation
1. Compile all Java files:
```
javac *.java
```

### Execution
Run the main class:
```
java LibrarySystem
```

## User Interface

The system provides a text-based console interface with the following menus:

### Main Menu
- Manager Mode: For library staff to manage the collection
- User Mode: For library patrons to use the library services
- Exit: To close the application

### Manager Menu
- Add new book
- Delete book
- Edit book
- View all books
- Search books by title
- Find book by ID
- Return to main menu

### User Menu
- View all books
- Search books by title
- Borrow a book
- Return a book
- Return to main menu

## Class Descriptions

### LibraryItem.java
An abstract base class providing common attributes and behaviors for different types of library items:
- Item ID
- Title
- Publication Year
- Publisher

### Book.java
Extends LibraryItem with book-specific attributes:
- Author
- Genre

### Loan.java
Represents a book loan transaction with:
- Book reference
- Due date

### Library.java
Represents a physical library with:
- Name
- Location
- Collection management methods

### Utility.java
Helper class providing:
- Collection management
- Sorting algorithms
- Search algorithms

### ItemNotFoundException.java
Custom exception for handling cases when items are not found in the library.

### LibrarySystem.java
Main class with:
- User interface
- Menu system
- Input handling

## Data Management

The system currently uses in-memory collections to store data:
- ArrayList for library items
- ArrayList for loans

## Sample Data

The system comes pre-loaded with sample books for testing purposes.

## Error Handling

The system includes robust error handling for:
- Invalid user input
- Books not found
- Type mismatches

## Future Enhancements

Potential areas for improvement:
1. Persistent storage (database integration)
2. User authentication system
3. Fine calculation for overdue books
4. Enhanced reporting capabilities
5. GUI interface
6. Additional library item types (DVDs, journals, etc.)
7. Reservation system