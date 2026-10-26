import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    void testGetCreator(){
        //Arrange
        Book book =new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        String creator = book.getCreator();
        //Assert
        assertEquals("Allan B. Downey", creator);
        assertNotEquals("J.K. Rowling",creator);

    }
    @Test
    void testGetCreator2() {
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        String creator = book.getCreator();
        //Assert
        assertSame(creator, book.getCreator());
        assertSame("Allan B. Downey", creator);
    }

    @Test
    void testGetCreatorFalse(){
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        String creator = book.getCreator();
        //Assert
        assertTrue(creator == "Allen G. Bowney");
    }

    @Test
    void testToString(){
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        String toString = book.toString();
        //Assert
        assertEquals("Allan B. Downey; Think Java; 9781492072508", toString);
    }

    @Test
    void testToStringFalse(){
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        String toString = book.toString();
        //Assert
        assertEquals("Allan B. Downey Think Java 9781492072508", toString);
    }

    @Test
    void testEquals(){
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act

        //Assert
        assertFalse(book.equals(null));
    }
    @Test
    void testEquals2(){
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        Book book2 = new Book("J.k. Rowling", "Think Java", "9781492072508", 250);
        //Assert
        assertFalse(book.equals(book2));
    }
    @Test
    void testEquals3(){
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        Book book2 = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Assert
        assertTrue(book.equals(book2));
    }

    @Test
    void testEqualsFalse(){
        //Arrange
        Book book = new Book("Allan B. Downey", "Think Java", "9781492072508", 250);
        //Act
        Book book2 = new Book("J.k. Rowling", "Think Java", "9781492072508", 250);
        //Assert
        assertTrue(book.equals(book2));
    }
}