import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void BookIsEmpty() {
        Books book = new Books();
        assertEquals(0, book.numberOfData());
    }

    @Test
    public void checkString() {
        Books book = new Books();
        assertEquals("meow", book.getTitle());
    }
}
