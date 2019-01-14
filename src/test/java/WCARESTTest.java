import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class WCARESTTest {
    WCAREST wcarest;


    @Test
    public void canDoGetAllFunction() throws musicParameterException, IOException, musicYearException {
//        Test whether the WCACOntroller can do getall request

//      Arrange
        WCAController wcaController=mock(WCAController.class);
        Crawler crawler=mock(Crawler.class);
        Scrapper scrapper=mock(Scrapper.class);
        Search search=mock(Search.class);

        wcarest=new WCAREST(wcaController,crawler,scrapper,search);

        String baseaddress="baseAddress";
        String parameter="";
        CombinedLink combinedLink=mock(CombinedLink.class);

//      Act
        when(wcaController.combine(baseaddress,parameter)).thenReturn(combinedLink);
        when(combinedLink.getBase()).thenReturn(baseaddress);

        when(wcaController.getAll(crawler,scrapper,baseaddress,1,search)).thenReturn("getAll");
//        indirect in/out
        String output=wcarest.receive(1,baseaddress,parameter);

//      Assert
//              ver param call
        verify(wcaController,times(1)).getAll(crawler,scrapper,baseaddress,1,search);
//              ver dir out
        Assert.assertEquals("getAll",output);
    }

    @Test
    public void canDoGetSpecificFunction() throws IOException, musicParameterException, musicYearException {
//      Test whether the WCAController can do getspecific request
//      Arrange
        WCAController wcaController=mock(WCAController.class);
        Crawler crawler=mock(Crawler.class);
        Scrapper scrapper=mock(Scrapper.class);
        Search search=mock(Search.class);
        CombinedLink combinedLink=mock(CombinedLink.class);
        wcarest=new WCAREST(wcaController,crawler,scrapper,search);
        String baseaddress="baseAddress";
        String parameter="specific";
        String combined="combined";

//      Act
        when(wcaController.combine(baseaddress,parameter)).thenReturn(combinedLink);
        when(combinedLink.getBase()).thenReturn(baseaddress);
        when(combinedLink.getParam()).thenReturn(parameter);
        when(wcaController.getSpecific(crawler,scrapper,baseaddress,parameter,1,search)).thenReturn("getSpecific");
//        indirect in/out
        String output=wcarest.receive(2,baseaddress,parameter);

//      Assert

//              ver param call
        verify(wcaController,times(1)).getSpecific(crawler,scrapper,baseaddress,parameter,1,search);
//              ver dir out
        Assert.assertEquals("getSpecific",output);
    }

    @Test
    public void canDoGetCrawlDepthFunction() throws IOException, musicParameterException, musicYearException {
//        Test whether the WCACOntroller can do getcrawlData request

//        Arrange
        WCAController wcaController=mock(WCAController.class);
        Crawler crawler=spy(Crawler.class);
        Scrapper scrapper=mock(Scrapper.class);
        Search search=mock(Search.class);
        CombinedLink combinedLink=mock(CombinedLink.class);
        wcarest=new WCAREST(wcaController,crawler,scrapper,search);
        String baseaddress="baseAddress";
        String parameter="3";

//        Act
        when(wcaController.combine(baseaddress,parameter)).thenReturn(combinedLink);
        when(combinedLink.getBase()).thenReturn(baseaddress);
        when(combinedLink.getParam()).thenReturn(parameter);
        when(wcaController.crawlDepth(crawler,scrapper,baseaddress,Integer.parseInt(parameter),search)).thenReturn("getDepth");
//        indirect in out
        String output=wcarest.receive(3,baseaddress,parameter);

//        Assert
//        ver param call
        verify(wcaController,times(1)).crawlDepth(crawler,scrapper,baseaddress,Integer.parseInt(parameter),search);
//      ver dir out
        Assert.assertEquals("getDepth",output);
    }

    private static final Object[] getParam() {
        return new Object[]{-1, 0, 4};

    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParam")
//    public void intChoiceShouldBeBetweenOneandThree(int parameter){
////        Parameterized Test
////        Arrange
//        WCAREST wcarest=new WCAREST();
////        Act
//        wcarest.receive(parameter,"dummy","");
////Expect exception
//
//
//
//    }

}