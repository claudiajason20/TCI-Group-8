import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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
     * @throws IOException
     * @throws musicParameterException
     * @throws musicYearException
     */
    @Test
    public void verifyThatExtractorParseAllMethodWorks() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        //Act
        controller.getAll(webCrawl,parser,url, 1);

        //Assert
        verify(webCrawl).recursiveCrawl(url);
        verify(parser).parseAll(webCrawl.getUrl(0));
    }

    /**
     *      * This test verifies whether the BFSCrawl method from the crawler works
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
        String url = "http://localhost/sample_sit/";
        //Act
        controller.getAll(webCrawl,parser,url,2);
        //Assert
        verify(webCrawl).crawl(url);
    }

    /**
     * This test verifies that crawlWithDepthMethod is running
     * @throws IOException
     */
    @Test
    public void verifyThatCrawlWithDepthMethodRuns() throws IOException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        int starting_depth=0;
        int max_depth=0;
        String url = "http://localhost/sample_sit/";
        //Act
        controller.crawlWithDepth(webCrawl,parser,url,max_depth);
        //Assert
        verify(webCrawl).crawlWithDepth(url,starting_depth);

    }



}
