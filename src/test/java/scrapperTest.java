import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class scrapperTest {
    @Test
    public void documentIsNotEmpty() {
        //arrange
        Jsoup jsoup = mock(Jsoup.class);
        String html = "Hello World";
        Document doc = mock(Document.class);
        Scrapper scrapperData = new Scrapper();

        //act
//        when(jsoup.).thenReturn("Hello World");
//        Scrapper.setDoc(jsoup.parse(html));
//        //assert
//        verify(scrapperData).getBodyText();
    }

}
