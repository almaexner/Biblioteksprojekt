import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class TestDanishSorting {

    @Test
    void testDanishSorting(){
        //Arrange
        ArrayList<Book> book = new ArrayList<>();
        Book bookå = new Book("1", "Signe", "Åen af i går", 100);
        Book bookø = new Book("2", "Alma", "Øen af i går", 100);
        book.add(bookå);
        book.add(bookø);
        Collator collator = Collator.getInstance(new Locale("da"));
        String expected = "Øen af i går";
        //Act
        Collections.sort(book, new ResourceTitleComparator(collator));
        //Assert
        assertEquals(expected, book.get(0).getTitle());
    }

    @Test
    void testDanishSortingFail(){
        //Arrange
        ArrayList<Book> book = new ArrayList<>();
        Book bookå = new Book("1", "Signe", "Åen af i går", 100);
        Book bookø = new Book("2", "Alma", "Øen af i går", 100);
        book.add(bookå);
        book.add(bookø);
        Collator collator = Collator.getInstance(new Locale("sv"));
        String expected = "Øen af i går";
        //Act
        Collections.sort(book, new ResourceTitleComparator(collator));
        //Assert
        assertNotEquals(expected, book.get(0).getTitle());
    }
}
