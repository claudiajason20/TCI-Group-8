import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class WCARESTTest {
    WCAREST wcarest;


    @Test
    public void canDoGetAllFunction(){
//        Test whether the WCACOntroller can do getall request

//      Arrange
        WCAController wcaController=mock(WCAController.class);
        wcarest=new WCAREST(wcaController);
        String baseaddress="baseAddress";
        String parameter="";

//      Act
        when(wcaController.combine(baseaddress,parameter)).thenReturn(baseaddress);
        when(wcaController.getAll(baseaddress)).thenReturn("getAll");
//        indirect in/out
        String output=wcarest.receive(1,baseaddress,parameter);

//      Assert
//              ver param call
        verify(wcaController).getAll(baseaddress);
//              ver dir out
        Assert.assertEquals("getAll",output);
    }

    @Test
    public void canDoGetSpecificFunction(){
//        Test whether the WCACOntroller can do getspecific request
//      Arrange
        WCAController wcaController=mock(WCAController.class);
        wcarest=new WCAREST(wcaController);
        String baseaddress="baseAddress";
        String parameter="specific";
        when(wcaController.getSpecific(baseaddress,parameter)).thenReturn("getSpecific");
//        Act
        String output=wcarest.receive(2,baseaddress,parameter);
//        Assert
        verify(wcaController,times(1)).getSpecific(baseaddress,parameter);
        Assert.assertEquals("getSpecific",output);
    }

    @Test
    public void canDoGetCrawlDataFunction(){
//        Test whether the WCACOntroller can do getcrawlData request
//        Arrange
        WCAController wcaController=mock(WCAController.class);
        wcarest=new WCAREST(wcaController);
        String baseaddress="baseAddress";
        String parameter="3";
        when(wcaController.getCrawlData(baseaddress,parameter)).thenReturn("getCrawlData");
//        Act
        String output=wcarest.receive(3,baseaddress,parameter);
//        Assert
        verify(wcaController,times(1)).getCrawlData(baseaddress,parameter);
        Assert.assertEquals("getCrawlData",output);
    }
}