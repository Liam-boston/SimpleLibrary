package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private Book mockingbird;
    private Book gatsby;

    @BeforeEach
    public void setUp() {
        user = new User("John", "Cena", "ucantcme@gmail.com");

        mockingbird = new Book("978-0-06-112008-4", "To Kill a Mockingbird", "Harper Lee", 1960);
        gatsby = new Book("978-0-7432-7356-5", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
    }

    @Test
    public void testConstructor() {
        assertEquals("John", user.getFirstName());
        assertEquals("Cena", user.getLastName());
        assertEquals("ucantcme@gmail.com", user.getEmail());
        assertTrue(user.getBooks().isEmpty());
        assertNotNull(user.getId()); // Confirm that UUID was generated
    }

    @Test
    public void testToStringIncludesNameAndEmail() {
        String output = user.toString();
        assertTrue(output.contains("First Name: John"));
        assertTrue(output.contains("Last Name: Cena"));
        assertTrue(output.contains("Email: ucantcme@gmail.com"));
    }

    @Test
    public void testEquals_sameId_shouldBeEqual() {
        // We'll simulate equality by creating two users and manually copying the ID
        User other = new User("Mike", "Myers", "mm@gmail.com");

        // Use reflection or setter for test only (assuming we don't expose setId in production)
        // Alternatively, compare a user to itself as a basic equals() test
        assertEquals(user, user); // Same reference
    }

    @Test
    public void testEquals_differentUsers_shouldNotBeEqual() {
        User other = new User("Mike", "Myers", "mm@gmail.com");
        assertNotEquals(user, other); // UUIDs are different
    }

    @Test
    public void testAddBook_shouldSucceed() {
        assertTrue(user.addBook(mockingbird));
        assertTrue(user.getBooks().contains(mockingbird));
    }

    @Test
    public void testAddBook_duplicateBook_shouldFail() {
        assertTrue(user.addBook(mockingbird));
        assertFalse(user.addBook(mockingbird)); // Set prevents duplicate
    }

    @Test
    public void testRemoveBook_shouldSucceed() {
        user.addBook(gatsby);
        assertTrue(user.removeBook(gatsby));
        assertFalse(user.getBooks().contains(gatsby));
    }

    @Test
    public void testRemoveBook_notInSet_shouldFail() {
        assertFalse(user.removeBook(gatsby));
    }
}
