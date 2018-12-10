import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void BookIsEmpty() {
        Books book = new Books();
        assertEquals(2, book.numberOfData());
    }

    @Test
    public void checkString() {
        Books book = new Books();
        assertEquals("moew", book.getTitle());
    }
}
