import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

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
//        Test whether the receive function works or not
//Arrange
    WCAREST wcarest;
    wcarest=mock(WCAREST.class);
    when(wcarest.receive()).thenReturn("OK");
//    Act
    String a=wcarest.receive();
//    Assert
    Assert.assertEquals("OK",a);
    }

    @Test
    public void canDoGetAllFunction(){
//        Test whether the WCACOntroller can do getall request
//      Arrange
        WCAController wcaController=mock(WCAController.class);
        WCAREST wcarest=new WCAREST();
        String baseaddress="baseAddress";
        when(wcaController.getAll(baseaddress)).thenReturn("getAll");
//      Act
        String output=wcarest.receive(1,baseaddress,"",wcaController);
//      Assert
        verify(wcaController,times(1)).getAll(baseaddress);
        Assert.assertEquals("getAll",output);
    }

    @Test
    public void canDoGetSpecificFunction(){
//        Test whether the WCACOntroller can do getspecific request
//      Arrange
        WCAController wcaController=mock(WCAController.class);
        WCAREST wcarest=new WCAREST();
        String baseaddress="baseAddress";
        String parameter="specific";
        when(wcaController.getSpecific(baseaddress,parameter)).thenReturn("getSpecific");
//        Act
        String output=wcarest.receive(2,baseaddress,parameter,wcaController);
//        Assert
        verify(wcaController,times(1)).getSpecific(baseaddress,parameter);
        Assert.assertEquals("getSpecific",output);
    }

    @Test
    public void canDoGetCrawlDataFunction(){
//        Test whether the WCACOntroller can do getcrawlData request
//        Arrange
        WCAController wcaController=mock(WCAController.class);
        WCAREST wcarest=new WCAREST();
        String baseaddress="baseAddress";
        String parameter="3";
        when(wcaController.getCrawlData(baseaddress,parameter)).thenReturn("getCrawlData");
//        Act
        String output=wcarest.receive(3,baseaddress,parameter,wcaController);
//        Assert
        verify(wcaController,times(1)).getCrawlData(baseaddress,parameter);
        Assert.assertEquals("getCrawlData",output);
    }
}