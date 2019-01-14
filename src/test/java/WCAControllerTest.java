import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WCAControllerTest {
    WCAController controller;


    @Test
    public void moviesClassCanBeMocked() {
        //arrange
        Movies movies;
        //act
        movies = mock(Movies.class);
        //assert
        Assert.assertTrue(movies instanceof Movies);

    }


    @Test
    public void CanMocksAccessMoviesData() {
        //arrange
        Movies movies = mock(Movies.class);
        when(movies.getid()).thenReturn(1);
        //act
        int id = movies.getid();
        //arrange
        verify(movies, times(1)).getid();
        Assert.assertEquals(1, id);

    }

    @Test
    public void CanMocksChangeMoviesData() {
        //arrange
        Movies movies = mock(Movies.class);
        //act
        movies.setid(2);
        //arrange
        verify(movies, times(1)).setid(2);

    }

    @Test
    public void shouldBeAbleToAddMoviesClass() {
        //arrange
        Movies movies = mock(Movies.class);
        WCAController wcaController = mock(WCAController.class);
        when(wcaController.getmovies()).thenReturn(movies);
        //act
        wcaController.insertmovies(movies);
        Movies getmovies = wcaController.getmovies();
        //assert
        verify(wcaController, times(1)).insertmovies(movies);
        Assert.assertEquals(movies, getmovies);

    }

    @Test
    public void shouldBeAbleToAddBookClassTest() {
        //arrange
        Books books = mock(Books.class);
        WCAController wcaController = mock(WCAController.class);
        when(wcaController.getbooks()).thenReturn(books);
        //act
        wcaController.insertbooks(books);
        Books getbooks = wcaController.getbooks();
        //assert
        verify(wcaController, times(1)).insertbooks(books);

        Assert.assertEquals(books, getbooks);

    }

    @Test
    public void shouldBeAbleToAddMusicClassTest() {
        //arrange
        Music music = mock(Music.class);
        WCAController wcaController = mock(WCAController.class);
        when(wcaController.getmusics()).thenReturn(music);
        //act
        wcaController.insertmusic(music);
        Music getmusic = wcaController.getmusics();
        //assert
        verify(wcaController, times(1)).insertmusic(music);

        Assert.assertEquals(music, getmusic);

    }

    @Test
    public void documentIsNotEmpty() {
        //arrange
        Document doc = mock(Document.class);
        WCAController wcaController = mock(WCAController.class);
        when(wcaController.getDocument()).thenReturn(doc);

        //act
        wcaController.setDocument(doc);
        Document getdoc = wcaController.getDocument();
        //
        verify(wcaController, times(1)).setDocument(doc);

        Assert.assertEquals(doc, getdoc);
    }

    @Test
    public void htmlIsNotEmpty() {
        //arrange
        String html = any(String.class);
        WCAController wcaController = mock(WCAController.class);
        when(wcaController.getHtml()).thenReturn(html);

        //act
        wcaController.setHtml(html);
        String gethtml = wcaController.getHtml();

        //assert
        verify(wcaController, times(1)).setHtml(html);
        Assert.assertEquals(html, gethtml);
    }

    /**
     * This test verifies whether the parse all method from the crawler works
     *
     * @throws IOException
     * @throws musicParameterException
     * @throws musicYearException
     */
    @Before
    public void setUp() {

    }

    @Test
    public void verifyThatExtractorParseAllMethodWorks() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        Search newSearch = mock(Search.class);

        //Act
        controller.getAll(webCrawl, parser, url, 1, newSearch);
        when(webCrawl.getUrl(0)).thenReturn(url);//indirect input
        //Assert
        verify(webCrawl).recursiveCrawl(url);
        verify(parser).parseAll(url);//indirect output
    }

    /**
     * * This test verifies whether the BFSCrawl method from the crawler works
     *
     * @throws IOException
     * @throws musicParameterException
     * @throws musicYearException
     */
    @Test
    public void verifyThatBFSCrawlMethodRuns() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        Search newSearch = mock(Search.class);

        String url = "http://localhost/sample_sit/";
        //Act
        controller.getAll(webCrawl, parser, url, 2, newSearch);
        //Assert
        verify(webCrawl).crawl(url);
    }

    /**
     * This test verifies that crawlWithDepthMethod is running
     *
     * @throws IOException
     */
    @Test
    public void verifyThatCrawlWithDepthMethodRuns() throws IOException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        int starting_depth = 0;
        int max_depth = 0;
        String url = "http://localhost/sample_sit/";
        Search newSearch = mock(Search.class);

        //Act
        controller.crawlWithDepth(webCrawl, parser, url, max_depth);
        //Assert
        verify(webCrawl).crawlWithDepth(url, starting_depth);
    }

    /**
     * Verifies that ParseSpecificMethod is called
     *
     * @throws IOException
     */
    @Test
    public void verifyThatParseSpecificMethodRuns() throws IOException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        String query = "Beethoven";
        //Act
        when(parser.parseSpecific(url, query)).thenReturn(true);
        when(webCrawl.getUrl(0)).thenReturn(url);//indirect input
        controller.getSpecific(webCrawl, parser, url, query, 1);

        //Assert
        verify(parser).parseSpecific(url, query);//indirect output
    }

    /**
     * This test verifies that arrayList is able to be added to the class
     *
     * @throws musicParameterException
     * @throws IOException
     * @throws musicYearException
     */
    @Test
    public void verifyThatSearchIsAbleToAddArrayListObjectFromTheParser() throws musicParameterException, IOException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        ArrayList<Music> musicList = mock(ArrayList.class);
        ArrayList<Books> bookList = mock(ArrayList.class);
        ArrayList<Movies> movieList = mock(ArrayList.class);
        Search newSearch = mock(Search.class);
        int type = 1;
        //Act
        when(parser.getMusicList()).thenReturn(musicList);//indirect input
        when(parser.getBookList()).thenReturn(bookList);
        when(parser.getMovieList()).thenReturn(movieList);

        controller.getAll(webCrawl, parser, url, type, newSearch);
        //Assert
        verify(newSearch).addList(musicList, bookList, movieList);//indirect output
    }

    @Test
    public void assertThatSearchClassIsAbleToReturnCorrectJson() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        Search newSearch = mock(Search.class);
        String json = "sample";
        String result;
        int type = 1;
        //Act
        when(newSearch.getJson()).thenReturn(json);
        result = controller.getAll(webCrawl, parser, url, type, newSearch);
        //Assert
        assertEquals(json, result);
    }


}
