package Service;

import Exceptions.BookNotAvailableException;
import Exceptions.BookNotCheckedOutException;
import Model.Book;
import Model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a library that contains books and registered users.
 * Supports book checkouts, returns, and member management.
 */
public class Library {
    private String name;
    private Set<Book> books;
    private Set<User> members;

    /**
     * Constructs a new Library with the given name.
     *
     * @param name - name of the Library.
     */
    public Library(String name) {
        this.name = name;
        this.books = new HashSet<>();
        this.members = new HashSet<>();
    }

    /**
     * Allows a user to return a Book to the Library.
     *
     * @param book - the book being returned.
     * @param user - the user returning the book.
     * @throws BookNotCheckedOutException - exception to throw if the user hasn't checked out the book trying to be returned.
     */
    public void returnBook(Book book, User user) throws BookNotCheckedOutException {
        boolean isCheckedOut = user.getBooks().contains(book);

        if (isCheckedOut) {
            user.removeBook(book);
            this.books.add(book);
        } else {
            throw new BookNotCheckedOutException("Book not checked out by User: " + user.getLastName() + ", " + user.getFirstName());
        }
    }

    /**
     * Allows a user to check out a book from the library.
     *
     * @param book - the book to check out.
     * @param user - the user checking the book out.
     * @throws BookNotAvailableException - Exception to throw if the book is not currently available.
     */
    public void checkout(Book book, User user) throws BookNotAvailableException {
        boolean isAvailable = this.books.contains(book);

        if (isAvailable) {
            user.addBook(book);
            this.books.remove(book);
        } else {
            throw new BookNotAvailableException("Book is not available for checkout.");
        }
    }

    /**
     * Adds a book to the library's collection.
     *
     * @param book - the book to add.
     * @return - true if the book was added, false otherwise.
     */
    public boolean addBook(Book book){
        return this.books.add(book);
    }

    /**
     * Registers a user as a member of the library.
     *
     * @param user - user to register.
     * @return - true if the user was added, false otherwise.
     */
    public boolean addMember(User user){
        return this.members.add(user);
    }

    // Getters
    /**
     * Returns the name of the library.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the set of books currently available in the library.
     */
    public Set<Book> getBooks() {
        return this.books;
    }

    /**
     * Returns the set of registered users in the library.
     */
    public Set<User> getMembers() {
        return this.members;
    }
}
