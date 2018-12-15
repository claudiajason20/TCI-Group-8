import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;


public class WCAControllerTest {
    WCAController controller;

    @Test
    public void moviesClassCanBeMocked(){
        Movies movies=mock(Movies.class);
        Assert.assertTrue(movies instanceof Movies);
    }
}
