import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void BookIsEmpty(){
        //arrange
        Books book=new Books();
        //assert
        assertEquals(0,book.numberOfData());
    }
}
