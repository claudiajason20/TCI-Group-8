import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class WCAControllerTest {
@Test
    public void canInsertAndAccessMovies(){
//    dummy
//    Can insert and access movies data
//    Arrange
    WCAController wcaController=new WCAController();
    Movies movie=mock(Movies.class);
//    Act
    wcaController.insertMovie(movie);
    ArrayList<Movies> resultList=wcaController.getMovies();
    Movies result= resultList.get(0);
//    Assert
    Assert.assertEquals(result,movie);

}



    @Test
    public void documentIsNotEmpty(){
        //arrange
        Document doc = mock(Document.class);
        WCAController wcaController=mock(WCAController.class);
        when(wcaController.getDocument()).thenReturn(doc);

        //act
        wcaController.setDocument(doc);
        Document getdoc= wcaController.getDocument();
        //
        verify(wcaController,times(1)).setDocument(doc);

        Assert.assertEquals(doc, getdoc);
    }

    @Test
    public void htmlIsNotEmpty(){
        //arrange
        String html = any(String.class);
        WCAController wcaController=mock(WCAController.class);
        when(wcaController.getHtml()).thenReturn(html);

        //act
        wcaController.setHtml(html);
        String gethtml= wcaController.getHtml();

        //assert
        verify(wcaController,times(1)).setHtml(html);
        Assert.assertEquals(html, gethtml);
    }

}
