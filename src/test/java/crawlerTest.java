import org.junit.Test;

import static org.junit.Assert.*;

public class crawlerTest {
    Crawler crawler=new Crawler();
    @Test
    public void verifyThatUrlIsValidBeforeAddedToUrlQueue(){
        //arrange
        String url="https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/";
        boolean validUrl;
        //act
        validUrl=crawler.verifyUrl(url);
        //assertion is done by the exception
        assertTrue(validUrl);

    }
}