import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class scrapperTest {
    @Test
    public void bookIsNotEmpty() {
        //arrange
        Books book = mock(Books.class);
        Scrapper scrapperData = new Scrapper();
        //act
        when(book.getYear()).thenReturn("1987");
        //assert
        scrapperData.decodeBook(book);
    }
}
