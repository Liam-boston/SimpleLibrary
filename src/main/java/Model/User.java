package Model;

import java.util.*;

/**
 * Represents a user in the library system.
 * A user can check out and return books.
 */
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Book> books;

    /**
     * Constructs a new user.
     *
     * @param firstName - the user's first name.
     * @param lastName - the user's last name.
     * @param email - the user's email.
     */
    public User(String firstName, String lastName, String email) {
        this.id = UUID.randomUUID().toString(); // Generates a unique UUID for each user.
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.books = new HashSet<>();
    }

    /**
     * Returns a string representation of the user and their books.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ");
        sb.append(firstName);
        sb.append("\nLast Name: ");
        sb.append(lastName);
        sb.append("\nEmail: ");
        sb.append(email);
        sb.append("\nBooks Checked Out: ");

        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getTitle());

            if (it.hasNext()) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    /**
     * Determines equality based on user ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.id.equals(user.id);
    }

    /**
     * Computes hash code using user ID.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    /**
     * Adds a book to the user's checked-out collection.
     *
     * @param book - the book to check out.
     * @return - true if the book was successfully added, false otherwise.
     */
    public boolean addBook(Book book) {
        return this.books.add(book);
    }

    /**
     * Removes a book from the user's collection.
     *
     * @param book - the book to remove.
     * @return - true if the book was successfully removed, false otherwise.
     */
    public boolean removeBook(Book book) {
        return this.books.remove(book);
    }

    // Getters & Setters

    /**
     * Returns the user's unique ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the user's first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the user's last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the user's full name (first + last).
     */
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Returns the user's email address.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email - new email address to replace user's current email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the set of books checked out by the user.
     */
    public Set<Book> getBooks() {
        return this.books;
    }
}
