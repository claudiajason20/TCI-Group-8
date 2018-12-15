import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;


public class WCAControllerTest {
    WCAController controller;


    @Test
    public void moviesClassCanBeMocked(){
        //arrange
        Movies movies;
        //act
        movies=mock(Movies.class);
        //assert
        Assert.assertTrue(movies instanceof Movies);
    }
}
