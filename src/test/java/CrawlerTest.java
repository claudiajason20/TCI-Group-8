import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrawlerTest {
    /**
     * This test is used to verify whether the verifyUrl method runs and returns the correct value
     */
    @Test
    public void AssertThatReceivedStringUrlIsValid(){
        //Arrange
        String url = "http://localhost/sample_sit/";
        Crawler a=new Crawler();
        boolean status;
        //Act
        status=a.verifyUrl(url);
        //Assert
        assertTrue("Url is valid!",status);
    }

    /**
     * This test verifies that the url came from the same website which is the local development website
     */
    @Test
    public void assertThatUrlCameFromTheSameWebsite(){
        //Arrange
        String url = "http://localhost/sample_sit/";
        Crawler a=new Crawler();
        boolean status;
        //Act
        status=a.verifyWebsiteOnly(url);
        //Assert
        assertTrue("Url came from the same website!",status);
    }

    /**
     * This test is to verify that the function only runs when the baseUrl received is correct
     * @throws IOException
     */
    @Test(expected = RuntimeException.class)
    public void checkThatDFSCrawlFunctionOnlyAcceptCorrectBaseUrl() throws IOException {
        //Arrange
        String url="falseWeb.com";
        Crawler a=new Crawler();
        //Act
        a.crawl(url);
        //Assertion is handled by runtime exception
    }

    /**
     * This test will check whether the element links has items inside or not. it gives a success if it has more
     * @throws IOException
     */
    @Test
    public void assertThatDFSCrawlerAbleToReceiveLinks() throws IOException {
        //Arrange
        Crawler a=new Crawler();
        String url = "http://localhost/sample_sit/";
        //Act
        Elements links=a.getLinks(url);
        //Assert
        assertTrue("Links is  empty",links.size()>0);
    }

    /**
     * If visited pages is not empty, then links are able to be able to be added to the
     * @throws IOException
     */
    @Test
    public void assertThatDFSCrawlMethodAbleToParseUniqueLinks() throws IOException {
        //Arrange
        Crawler a=new Crawler();
        String url = "http://localhost/sample_sit/";
        //Act
        a.crawl(url);
        //Assert
        assertTrue("Visited Pages is empty",a.getVisitedPages().size()>0);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void assertThatBFSCrawlMethodAbleToParseUniqueLinks() throws IOException {
        //Arrange
        Crawler a=new Crawler();
        String url = "http://localhost/sample_sit/";
        //Act
        a.recursiveCrawl(url);
        //Assert
        assertTrue("Visited Pages is empty",a.getVisitedPages().size()>0);
    }

    /**
     * If Max_depth is the same as the current depth, then the crawler succesfully reaches the specified level of depth
     * @throws IOException
     */
    @Test
    public void assertThatCrawlWithDepthReachesSpecifiedDepth() throws IOException {
        //Arrange
        Crawler a=new Crawler();
        int depth=0;
        int max_depth=5;
        String url = "http://localhost/sample_sit/";
        //Act
        a.setMax_depth(5);
        a.crawlWithDepth(url,depth);
        //Assert
        assertEquals(max_depth,a.getCurrentDepth());
    }




}