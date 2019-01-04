import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class WCARESTTest {

    @Test
    public void CanMockWCAController(){
        WCAController wcaController;
        wcaController=mock(WCAController.class);
        Assert.assertTrue(wcaController instanceof WCAController);

    }
}