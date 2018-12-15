import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class musicTest {

    @Test(expected = musicYearException.class)
    public void musicYearDoesNotComeFromFutureAssertion() throws musicYearException {
        //arrange
        int id=302;
        String Title="Title";

        String Category="Music";
        String Genre="Classical";
        String Format="CD";
        int Year=2020;
        String Artist="Harry Bieber";

        //act
        Music musicTest=new Music(id,Title,Category,Genre,Format,Year,Artist);
        //assert is handled by the exception

    }
}