import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

/**
 * Test function for WCA Controller
 */
public class WCAControllerTest {
    /**
     * WCA Controller should be able to insert and also access movies data
     */
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

}
