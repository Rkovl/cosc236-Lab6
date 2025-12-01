package lab5.tests;

import lab5.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestBookFactories {


    // Test PaperBookFactory
    @Test
    void testPaperBookFactory() {
        BookFactory factory = new PaperBookFactory();
        Book book = factory.createBook("Dune");

        assertNotNull(book, "Factory should never return null.");
        assertTrue(book instanceof PaperBook,
                "PaperBookFactory must create a PaperBook object.");
        assertEquals("Dune", book.getTitle(),
                "Book title should match input title.");
    }

    // Test EBookFactory
    @Test
    void testEBookFactory() {
        BookFactory factory = new EBookFactory();
        Book book = factory.createBook("1984");

        assertNotNull(book);
        assertTrue(book instanceof EBook,
                "EBookFactory must create an EBook object.");
        assertEquals("1984", book.getTitle());
    }


    // Test AudioBookFactory
    @Test
    void testAudioBookFactory() {
        BookFactory factory = new AudioBookFactory();
        Book book = factory.createBook("Sherlock Holmes Audio");

        assertNotNull(book);
        assertTrue(book instanceof AudioBook,
                "AudioBookFactory must create an AudioBook object.");
        assertEquals("Sherlock Holmes Audio", book.getTitle());
    }


    // Test generic addBook(BookFactory, title)
    @Test
    void testAddBook() {
        LibrarianController controller = new LibrarianController();
        controller.addBook(new PaperBookFactory(), "Moby Dick");

        Book found = controller.getLibrary().findBookByTitle("Moby Dick");

        assertNotNull(found, "Book should be added to the library.");
        assertTrue(found instanceof PaperBook,
                "Generic addBook() must use the correct factory.");
    }

    // Edge Case: Unsupported factory returns null
    @Test
    void testUnsupportedBook() {
        BookFactory unsupportedFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                // simulate invalid factory
                return null;
            }
        };

        Book created = unsupportedFactory.createBook("UnknownType");

        assertNull(created,
                "Unsupported factory should return null for invalid type.");
    }
}
