import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class WCAControllerTest {
    WCAController controller;


    @Test
    public void moviesClassCanBeMocked(){
//        dummy
        //arrange
        Movies movies;
        //act
        movies=mock(Movies.class);
        //assert
        Assert.assertTrue(movies instanceof Movies);

    }


    @Test
    public void CanMocksAccessMoviesData(){
// indirect output,verification of direct output
        //arrange
        Movies movies=mock(Movies.class);
        when(movies.getid()).thenReturn(1);
        //act
        int id=movies.getid();
        //arrange
        verify(movies,times(1)).getid();
//        Assert.assertEquals(1,id);

    }

    @Test
    public void CanMocksChangeMoviesData(){
// verification of direct input,indirect input
        //arrange
        Movies movies=mock(Movies.class);
        int id=2;
        //act
        movies.setid(id);
        //arrange
        verify(movies,times(1)).setid(id);

    }

    @Test
    public void shouldBeAbleToAddMoviesClass(){
//      Ver dir out/in,indirect in/out
        //arrange
        Movies movies=mock(Movies.class);
        WCAController wcaController=mock(WCAController.class);
        when(wcaController.getmovies()).thenReturn(movies);
        //act
        wcaController.insertmovies(movies);
        Movies getmovies=wcaController.getmovies();
        //assert
        verify(wcaController,times(1)).insertmovies(movies);
//        Assert.assertEquals(movies,getmovies);

    }

    @Test
    public void shouldBeAbleToAddBookClassTest(){
//      Ver dir out/in,indirect in/out

        //arrange
        Books books=mock(Books.class);
        WCAController wcaController=mock(WCAController.class);
        when(wcaController.getbooks()).thenReturn(books);
        //act
        wcaController.insertbooks(books);
        Books getbooks=wcaController.getbooks();
        //assert
        verify(wcaController,times(1)).insertbooks(books);

        Assert.assertEquals(books,getbooks);

    }
    @Test
    public void shouldBeAbleToAddMusicClassTest(){
//      Ver dir out/in,indirect in/out

        //arrange
        Music music=mock(Music.class);
        WCAController wcaController=mock(WCAController.class);
        when(wcaController.getmusics()).thenReturn(music);
        //act
        wcaController.insertmusic(music);
        Music getmusic=wcaController.getmusics();
        //assert
        verify(wcaController,times(1)).insertmusic(music);

        Assert.assertEquals(music,getmusic);

    }

}
