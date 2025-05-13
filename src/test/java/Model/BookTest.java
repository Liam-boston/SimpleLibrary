package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book lotr;
    private Book mockingbird;
    private Book gatsby;

    @BeforeEach
    public void setUp() {
        lotr = new Book("978-0-09-556397-5", "The Lord of the Rings", "J.R.R. Tolkien", 1954);
        mockingbird = new Book("978-0-06-112008-4", "To Kill a Mockingbird", "Harper Lee", 1960);
        gatsby = new Book("978-0-7432-7356-5", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
    }

    @Test
    public void testConstructor() {
        // Test that the constructor correctly sets the properties
        assertEquals("978-0-09-556397-5", lotr.getIsbn());
        assertEquals("The Lord of the Rings", lotr.getTitle());
        assertEquals("J.R.R. Tolkien", lotr.getAuthor());
        assertEquals(1954, lotr.getPublishYear());
    }

    @Test
    public void testToString() {
        // Get the expected output from the toString() method
        String expected = "Title: The Lord of the Rings\nAuthor: J.R.R. Tolkien\nPublication Year: 1954";

        // Test that the toString method returns the expected String
        assertEquals(expected, lotr.toString());
    }

    @Test
    public void testEquals_sameISBN_shouldBeEqual() {
        // Duplicate of mockingbird with same ISBN but different metadata
        Book duplicateMockingbird = new Book("978-0-06-112008-4", "Mockingbird Copy", "Another Author", 2000);
        assertEquals(mockingbird, duplicateMockingbird);
    }

    @Test
    public void testEquals_differentISBN_shouldNotBeEqual() {
        assertNotEquals(mockingbird, gatsby);
    }

    @Test
    public void testEquals_nullAndDifferentClass_shouldNotBeEqual() {
        assertNotEquals(mockingbird, null);
        assertNotEquals(mockingbird, "Not a Book");
    }
}
