package Model;

import java.util.Objects;

/**
 * Represents a book in the library system.
 * A book is uniquely identified by its ISBN.
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publishYear;

    /**
     * Constructs a new book.
     *
     * @param isbn - unique ISBN of the book.
     * @param title - title of the book.
     * @param author - author of the book.
     * @param publishYear - year the book was published.
     */
    public Book(String isbn, String title, String author, int publishYear) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return a formatted string describing the book.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ");
        sb.append(this.title);
        sb.append("\nAuthor: ");
        sb.append(this.author);
        sb.append("\nPublication Year: ");
        sb.append(this.publishYear);

        return sb.toString();
    }

    /**
     * Determines equality based on ISBN.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return this.isbn.equals(book.isbn);
    }

    /**
     * Computes hash code using ISBN.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.isbn);
    }

    // Getters
    /**
     * Returns the ISBN of the book.
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the author of the book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the publication year of the book.
     */
    public int getPublishYear() {
        return this.publishYear;
    }
}
