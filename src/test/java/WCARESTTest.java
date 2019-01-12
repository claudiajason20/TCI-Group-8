import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
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
//      Test whether the WCAController can do getspecific request
//      Arrange
        WCAController wcaController=mock(WCAController.class);
        wcarest=new WCAREST(wcaController);
        String baseaddress="baseAddress";
        String parameter="specific";
        String combined="combined";

//      Act
        when(wcaController.combine(baseaddress,parameter)).thenReturn(combined);
        when(wcaController.getSpecific(combined)).thenReturn("getSpecific");
//        indirect in/out
        String output=wcarest.receive(2,baseaddress,parameter);

//      Assert

//              ver param call
        verify(wcaController,times(1)).getSpecific(combined);
//              ver dir out
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
        String combined="crawlcombined";

//        Act
        when(wcaController.combine(baseaddress,parameter)).thenReturn(combined);
        when(wcaController.getCrawlData(combined)).thenReturn("getCrawlData");
//        indirect in out
        String output=wcarest.receive(3,baseaddress,parameter);

//        Assert
//        ver param call
        verify(wcaController).getCrawlData(combined);
//      ver dir out
        Assert.assertEquals("getCrawlData",output);
    }

    private static final Object[] getParam() {
        return new Object[]{-1, 0, 4};

    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParam")
    public void intChoiceShouldBeBetweenOneandThree(int parameter){
        WCAREST wcarest=new WCAREST();
        wcarest.receive(parameter,"dummy","");




    }
}