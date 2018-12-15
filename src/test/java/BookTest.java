import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void bookIsEmpty() {
        //arrange
        Books book = new Books();
        //assert
        assertEquals(0, book.numberOfData());
    }

    @Test
    public void checkString() {
        //arrange
        Books book = new Books();
        //act
        //assert
        assertEquals("meow", book.getTitle());
    }

    @Test
    public void constructorIsNotNull(){
        //arrange
        ArrayList<String> author = new ArrayList<>();
        author.add("Robert C. Martin");
        //act
        Books book = new Books(1,"Audio",author,"007-6092046981","Prentice Hall","2011","Tech");
        //assert
        assertEquals(1,book.getId());
        assertEquals("Audio",book.getFormat());
        assertEquals("2011", book.getYear());
        assertEquals("Robert C. Martin", book.getAuthors().get(0));
        assertEquals("Prentice Hall", book.getPublisher());
        assertEquals("Tech",book.getGenre());
        assertEquals("007-6092046981", book.getIsbn());
    }




}