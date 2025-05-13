package Service;

import Exceptions.BookNotAvailableException;
import Exceptions.BookNotCheckedOutException;
import Model.Book;
import Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library lib;
    private User mike;
    private User john;
    private Book lotr;
    private Book mockingbird;
    private Book gatsby;

    @BeforeEach
    public void setUp() {
        // Initialize a test library
        lib = new Library("Fairfax County Public Library");

        // Initialize test users
        mike = new User("Mike", "Myers", "mm@gmail.com");
        john = new User("John", "Cena", "ucantcme@gmail.com");

        // Initialize test books
        lotr = new Book("978-0-09-556397-5", "The Lord of the Rings", "J.R.R. Tolkien", 1954);
        mockingbird = new Book("978-0-06-112008-4", "To Kill a Mockingbird", "Harper Lee", 1960);
        gatsby = new Book("978-0-7432-7356-5", "The Great Gatsby", "F. Scott Fitzgerald", 1925);

        // Add users/books to test library
        lib.addMember(mike);
        lib.addMember(john);
        lib.addBook(lotr);
        lib.addBook(mockingbird);
        lib.addBook(gatsby);
    }

    @Test
    public void testConstructor() {
        // Test that the constructor correctly sets properties
        Library test = new Library("Fairfax County Public Library");
        assertEquals("Fairfax County Public Library", test.getName());
        assertTrue(test.getBooks().isEmpty());
        assertTrue(test.getMembers().isEmpty());
    }

    @Test
    public void testReturnBook() {
        try {
            // check book out
            lib.checkout(mockingbird, mike);

            // confirm book is no longer in library list
            assertFalse(lib.getBooks().contains(mockingbird));

            // confirm book has been added to user collection
            assertTrue(mike.getBooks().contains(mockingbird));

            // return book
            lib.returnBook(mockingbird, mike);

            // confirm book has been added back to library list
            assertTrue(lib.getBooks().contains(mockingbird));

            // confirm book is no longer in user collection
            assertFalse(mike.getBooks().contains(mockingbird));
        } catch (BookNotCheckedOutException ex) {
            fail("BookNotCheckedOutException should not have been thrown.");
        } catch (BookNotAvailableException ex) {
            fail("BookNotAvailableException should not have been thrown.");
        }
    }

    @Test
    public void testCheckout() {
        try {
            // confirm book is available in library list
            assertTrue(lib.getBooks().contains(gatsby));

            // check book out
            lib.checkout(gatsby, john);

            // confirm book is longer in library list
            assertFalse(lib.getBooks().contains(gatsby));

            // confirm book has been added to user collection
            assertTrue(john.getBooks().contains(gatsby));
        } catch (BookNotAvailableException ex) {
            fail("BookNotAvailableException should not have been thrown.");
        }

    }

    @Test
    public void testAddBook() {
        // initialize new test book
        Book flies = new Book("978-0-03-491532-9", "Lord of the Flies", "William Golding", 1954);

        // add book to library list
        lib.addBook(flies);

        // confirm book is available in library list
        assertTrue(lib.getBooks().contains(flies));
    }

    @Test
    public void testAddMember() {
        // initialize new test user
        User james = new User("James", "Bond", "007@gmail.com");

        // add user to members list in library
        lib.addMember(james);

        // confirm user is in library members list
        assertTrue(lib.getMembers().contains(james));
    }
}
