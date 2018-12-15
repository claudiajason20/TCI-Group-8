import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
        String WRITER=null;
        String STAR=null;
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,null,null);
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

    @Test(expected = IllegalArgumentException.class)
    public void nameShouldNotBeNull(){
        //arrange
        int ID=1;
        String NAME=null;
        String GENRE="Drama";
        String FORMAT="DVD";
        String YEAR="1997";
        String DIRECTOR="Jack";
        String WRITER=null;
        String STAR=null;
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,null,null);
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
        String WRITER=null;
        String STAR="star";
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,null,null);
        //exception

    }

/////////////////
////////////////
///////////////

    @Test
    public void thereISMoreThanOneWriter(){
        //arrange
        int ID=1;
        String NAME="Jack on the go";
        String GENRE="Drama";
        String FORMAT="DVD";
        String YEAR="1997";
        String DIRECTOR="Jack";
        String WRITER1="Jok";
        String WRITER2="Joky";
        String STAR=null;
        ArrayList<String> writers=new ArrayList<>();
        writers.add(WRITER1);
        writers.add(WRITER2);
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,writers,null);
        //assert
        Assert.assertEquals(2,movies.getwriter().size());

    }

    @Test
    public void thereISMoreThanOneStar(){
        //arrange
        int ID=1;
        String NAME="Jack on the go";
        String GENRE="Drama";
        String FORMAT="DVD";
        String YEAR="1997";
        String DIRECTOR="Jack";
        String WRITER1="Jok";
        String WRITER2="Joky";
        String STAR1="star";
        String STAR2="star2";
        ArrayList<String> writers=new ArrayList<>();
        writers.add(WRITER1);
        writers.add(WRITER2);
        ArrayList<String> stars=new ArrayList<>();
        stars.add(WRITER1);
        stars.add(WRITER2);
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,writers,stars);
        //assert
        Assert.assertEquals(2,movies.getstar().size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void yearBiggerThan1900(){
        //arrange
        int ID=1;
        String NAME="Jack on the go";
        String GENRE="Drama";
        String FORMAT="DVD";
        String YEAR="1900";
        String DIRECTOR="Jack";
        String WRITER1="Jok";
        String WRITER2="Joky";
        String STAR1="star";
        String STAR2="star2";
        ArrayList<String> writers=new ArrayList<>();
        writers.add(WRITER1);
        writers.add(WRITER2);
        ArrayList<String> stars=new ArrayList<>();
        stars.add(WRITER1);
        stars.add(WRITER2);
        //act
        Movies movies=new Movies(ID,NAME,GENRE,FORMAT,YEAR,DIRECTOR,writers,stars);
        //exception

    }
}
