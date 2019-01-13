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
    @Test
    public void assertThatUrlIsIterableAndAbleToReceiveLinks(){
        //Arrange

        //Act

        //Assert
    }
    @Test
    public void assertThatCrawlerAbleToReceiveLinks() throws IOException {
        //Arrange
        Crawler a=new Crawler();
        String url = "http://localhost/sample_sit/";
        //Act
        Elements links=a.getLinks(url);
        //Assert
        assertTrue("Links is not empty",links.size()>0);
    }



}