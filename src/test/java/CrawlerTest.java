import org.junit.Test;

import static org.junit.Assert.*;

public class CrawlerTest {
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
}