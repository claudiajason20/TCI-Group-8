import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URL;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class scrapperTest {
    @Test
    public void linkNotVisitedTwice(){
        //arrange
        Node node = mock(Node.class);
        Scrapper sc = mock(Scrapper.class);
        when(sc.hasVisited(node)).thenReturn(true);

        //act
        Boolean test = sc.hasVisited(node);

        //assert
        verify(sc).hasVisited(node);
        assertTrue(test);
    }

}
