import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

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


    @Test
    public void CanMocksMoviesData(){
        //arrange
        Movies movies=mock(Movies.class);
        when(movies.getid()).thenReturn(1);
        //act
        int id=movies.getid();
        //arrange
        Assert.assertEquals(1,id);


    }


}
