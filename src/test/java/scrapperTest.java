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
    public void parseAllHasRun() throws IOException, musicParameterException, musicYearException {
        //arrange
        Scrapper sc = new Scrapper();
        Document doc = mock(Document.class);
        Elements ele = mock(Elements.class);

        //act
        when(doc.getElementsByClass("media-details")).thenReturn(ele);
        sc.parseAll("http://this.com");

        //assert
        verify(doc,times(0)).getElementsByClass("media-details");
    }

    @Test
    public void getIdReturnInt(){
        //arangge
        Scrapper sc = new Scrapper();
        String url = "x=100";

        //act
        int x = sc.getId(url);

        //assert
        assertEquals(100,x);

    }

    @Test
    public void getAttributeReturnString(){
        Scrapper sc = new Scrapper();
        Element content = mock(Element.class);
        Element ele = mock(Element.class);
        String attribute = "genre";

        when(content.select("tr:contains(" + attribute + ")").get(0)).thenReturn(ele);
        //when(ele.select("td").get(0).text()).thenReturn("Pop");

        sc.getAttribute(attribute,content);

        verify(content).select("tr:contains(" + attribute + ")").get(0);
        //assertEquals(text,ele.select("td").get(0).text());

    }

}