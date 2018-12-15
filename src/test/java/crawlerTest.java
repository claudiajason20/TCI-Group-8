import org.junit.Test;

import static org.junit.Assert.*;

public class crawlerTest {
    Crawler crawler=new Crawler();
    @Test
    public void verifyThatUrlIsValidBeforeAddedToUrlQueue(){
        //arrange
        String url="google.com/";
        //act
        crawler.addLink(url);
        //assertion is done by the exception
    }
}