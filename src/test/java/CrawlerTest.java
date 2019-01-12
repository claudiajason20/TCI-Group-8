import org.junit.Test;

import static org.junit.Assert.*;

public class CrawlerTest {
    @Test
    public void AssertThatReceivedStringUrlIsValid(){
        //Arrange
        String url = "http://localhost/sample_sit/";
        boolean status;
        //Act
        status=verifyUrl(url);
        //Assert
        assertTrue("Url is valid!",status);
    }
}