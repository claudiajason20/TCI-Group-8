import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 *This is the test unit for the music model
 *
 */
public class musicTest {

    /**
     * This test asserts whether the year of the released music is valid or not, music are not supposed to be recorded from the future
     *
     * @throws musicYearException
     */
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

    /**
     * This test have the intention to check whether the music came earlier from the date of recording history or nto
     * @throws musicYearException
     */
    @Test(expected=musicYearException.class)
    public void musicYearDoesNotComeFromBeyondRecordingTimeAssertion() throws musicYearException{
        //arrange

        int id=302;
        String Title="Title";

        String Category="Music";
        String Genre="Classical";
        String Format="CD";
        int Year=1500;
        String Artist="Harry Bieber";

        //act
        Music musicTest=new Music(id,Title,Category,Genre,Format,Year,Artist);
        //assert is handled by the exception


    }

  }