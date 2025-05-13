# SimpleLibrary
SimpleLibrary is a **basic Java project** that models the core functionality of a public library system. **The goal of this excercise was to design clean, testable object-oriented code** that captures key library operations such as adding books, checking out and returning books, and managing users - without any database or UI concerns.

## Project Description
This project was built in response to the following prompt:

**Design a simple library system.**
Create a set of classes in Java to represent a basic library system. It should allow:
* Adding a book to the library
* Checking out a book to a user
* Returning a book

Keep it simple: assume the library only has one copy of each book, and users can check out multiple books. Do so by implementing the following classes:
* `Book`
* `User`
* `Library`

## Bonus: Track Book Ownership
As an extension of the original prompt, modify the Library class to include a `Map<Book, User>` to keep track of which user has which book(s) checked out. This addition allows the system to clearly associate borrowed books with users and enforces single-copy constraints more effectively.

## Testing
All core classes and features are covered with unit tests:
* `BookTest.java`
* `UserTest.java`
* `LibraryTest.java`

## Technologies Used
* Java 24
* JUnit 5
* Intellij IDEA (for development and test execution)
