import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class WCAControllerTest {
@Test
    public void canInsertAndAccessMovies(){
    WCAController wcaController=new WCAController();
    Movies movie=mock(Movies.class);
    wcaController.insertMovie(movie);
    ArrayList<Movies> resultList=wcaController.getMovies();
    Movies result= resultList.get(0);
    Assert.assertEquals(result,movie);

}



}
