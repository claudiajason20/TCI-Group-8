import org.jsoup.nodes.Document;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class crawlerTest {
    Crawler crawler = new Crawler();

    /**
     * THis test verifies whetehr the verifyUrl returns the correct value
     */
    @Test
    public void verifyThatUrlIsValidBeforeAddedToUrlQueue() {
        //arrange
        boolean validUrl;
        String url = "https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/";
        //act
        validUrl = crawler.verifyUrl(url);
        //assertion is done by the exception
        assertTrue(validUrl);
    }

    /**
     * Verification of direct input method calls for verifyUrl
     */
    @Test
    public void verifyThatVerifyUrlMethodRuns() {
        //arrange
        String url = "https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/";
        //act
        Crawler spyCrawl = Mockito.spy(crawler);
        spyCrawl.verifyUrl(url);
        //assert
        verify(spyCrawl).verifyUrl(url);
    }

    /**
     * Test whether the add pages functions runs
     */
    @Test
    public void verifyThatAddPagesToVisitMethodRuns() {
        //arrange
        String url = "https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/";
        //act
        Crawler spyCrawl = Mockito.spy(crawler);
        spyCrawl.addPageToVisit(url);
        //assert
        verify(spyCrawl).addPageToVisit(url);
    }

    /**
     * THis method verifies whether the method for getLink runs
     *
     * @throws IOException
     */
    @Test
    public void verifyThatGetLinkMethodRuns() throws IOException {
        //arrange
        String url = "https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/";
        //act
        Crawler spyCrawl = Mockito.spy(crawler);
        spyCrawl.getLink(url);
        //assert
        verify(spyCrawl).getLink(url);
    }

    /**
     * This test has the function to test whether the parser is able to receive the link from the given url, if the condition is true
     * then the link for addPages to visit size must be larger than 0
     * @throws IOException
     */
    @Test
    public void assertThatCrawlerAbleToReceiveLink() throws IOException {
        //arrange
        String url = "https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/";
        Document jsoupDoc=Mockito.mock(Document.class);
        //act
//       when(crawler.loadUrl(url)).then (jsiupdoc)
        when(crawler.parseLinks(url)).thenReturn(jsoupDoc);
        assertEquals(jsoupDoc,crawler.parseLinks(url));
        //assertuRL
      //  verify crawler has called loaad
        verify
//        assertTrue("Crawler able to receive link correctly!",crawler.getPagesToVisitSize()>0);
    }
    @Test
    public void assertThatReturnedLinkIsInOrder(){


    }


}