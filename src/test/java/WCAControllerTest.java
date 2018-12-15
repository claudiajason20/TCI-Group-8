import org.junit.Assert;
import org.junit.Test;


public class WCAControllerTest {
    WCAController controller;

    @Test
    public void moviesClassCanBeMocked(){
        Movies movies=mock(Movies.class);
        Assert.assertTrue(movies instanceof Movies);
    }
}
