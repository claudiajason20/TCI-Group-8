import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class scrapperTest {
    @Test
    public void parseAllHasRun() throws IOException {
        //arrange
        Scrapper sc = new Scrapper();
        Document doc = mock(Document.class);
        Elements ele = mock(Elements.class);

        //act
        when(doc.getElementsByClass("media-details")).thenReturn(ele);
        sc.parseAll("http://this.com");

        //assert
        assertEquals(ele,doc.getElementsByClass("media-details"));
    }

    @Test
    public void getIdReturnId(){
        //arangge
        Scrapper sc = new Scrapper();
        String url = "x=100";

        //act
        Integer x = getId(url);

        //assert
        assertEquals(100,x);


        //act
    }

}