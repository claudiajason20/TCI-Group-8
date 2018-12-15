import org.junit.Assert;
import org.junit.Test;

public class moviesTest {


    @Test
    public void constructorSuccessful(){
        //arrange
        int ID=1;
        String NAME="Hi BEN";
        String GENRE="Drama";
        String FORMAT="DVD";
        String YEAR="1997";
        String DIRECTOR="Jack";
        String WRITER="Jok";
        String STAR="star";
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,WRITER,STAR);
        //assert
        Assert.assertEquals(ID,movies.getid());
        Assert.assertEquals(NAME,movies.getname());
        Assert.assertEquals(GENRE,movies.getgenre());
        Assert.assertEquals(FORMAT,movies.getformat());
        Assert.assertEquals(YEAR,movies.getyear());
        Assert.assertEquals(DIRECTOR,movies.getdirector());
        Assert.assertEquals(WRITER,movies.getwriter());
        Assert.assertEquals(STAR,movies.getstar());
    }

    @Test(expected = NullPointerException.class)
    public void nameShouldNotBeNull(){
        //arrange
        int ID=1;
        String NAME=null;
        String GENRE="Drama";
        String FORMAT="DVD";
        String YEAR="1997";
        String DIRECTOR="Jack";
        String WRITER="Jok";
        String STAR="star";
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,WRITER,STAR);
        //exception

    }
    @Test(expected = IllegalArgumentException.class)
    public void idShouldNotBeNullOrZero(){
        //arrange
        int ID=0;
        String NAME="Jack on the go";
        String GENRE="Drama";
        String FORMAT="DVD";
        String YEAR="1997";
        String DIRECTOR="Jack";
        String WRITER="Jok";
        String STAR="star";
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,WRITER,STAR);
        //exception

    }
}
