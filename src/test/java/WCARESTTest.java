import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WCARESTTest {

    @Test
    public void CanMockWCAController(){
//        Check whether the WCAController can be mocked here
//        Arrange
        WCAController wcaController;
//        Act
        wcaController=mock(WCAController.class);
//        Assert
        Assert.assertTrue(wcaController instanceof WCAController);

    }

    @Test
    public void  canReceiveMessage(){

    WCAREST wcarest;
    wcarest=mock(WCAREST.class);
    when(wcarest.receive()).thenReturn("OK");
    Assert.assertEquals("OK",wcarest.receive());


    }
}