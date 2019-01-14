import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test function for WCA Controller
 */
public class WCAControllerTest {
    WCAController controller;


    /**
     * WCA Controller should be able to insert and also access movies data
     */
    @Test
    public void canInsertAndAccessMovies(){
//    dummy
//    Can insert and access movies data
//    Arrange
        WCAController wcaController=new WCAController();
        Movies movie=mock(Movies.class);
//    Act
        wcaController.insertMovie(movie);
        ArrayList<Movies> resultList=wcaController.getMovies();
        Movies result= resultList.get(0);
//    Assert
        Assert.assertEquals(result,movie);

    }

    /**
     * This test verifies whether the parse all method from the crawler works
     *
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
        Search newSearch = mock(Search.class);

        //Act
        controller.getAll(webCrawl, parser, url, 1, newSearch);//dummy testing
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
    public void verifyThatCrawlWithDepthMethodRuns() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        int starting_depth = 0;
        int max_depth = 5;
        String url = "http://localhost/sample_sit/";
        Search newSearch = mock(Search.class);

        //Act
        controller.crawlDepth(webCrawl, parser, url, max_depth, newSearch);
        when(webCrawl.getUrl(0)).thenReturn(url);//indirect input
        //Assert
        verify(webCrawl).crawlWithDepth(url, starting_depth);
        verify(parser).parseAll(url);
    }

    /**
     * Verifies that ParseSpecificMethod is called
     *
     * @throws IOException
     */
    @Test
    public void verifyThatParseSpecificMethodRuns() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        String query = "Beethoven";
        Search newSearch = mock(Search.class);
        //Act
        controller.getSpecific(webCrawl, parser, url, query, 2, newSearch);
        when(webCrawl.getUrl(0)).thenReturn(url);//indirect input
        when(parser.parseSpecific(url, query)).thenReturn(true);
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

    /**
     * This test asserts whether the searchClass is able to return expected json
     *
     * @throws IOException
     * @throws musicParameterException
     * @throws musicYearException
     */
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
        when(newSearch.getJson()).thenReturn(json);//indirect input
        result = controller.getAll(webCrawl, parser, url, type, newSearch);
        //Assert
        assertEquals(json, result);
    }

    /**
     * This test checks whether the return value from parseSpecific is correct
     *
     * @throws IOException
     * @throws musicParameterException
     * @throws musicYearException
     */
    @Test
    public void assertThatSearchClassIsAbleToReturnCorrectJsonFromParseSpecific() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        Search newSearch = mock(Search.class);
        String json = "sample";
        String query = "Beethoven";
        String result;
        int type = 1;
        //Act
        when(newSearch.getJson()).thenReturn(json);//indirect input
        result = controller.getSpecific(webCrawl, parser, url, query, 2, newSearch);
        //Assert
        assertEquals(json, result);
    }

    /**
     * This test checks whether the returned value of CrawlDepth function is as expected
     * this function also uses an extended search class that has additional pagesExplored and depth as it's attributes
     *
     * @throws IOException
     */
    @Test
    public void assertThatSearchClassIsAbleToReturnCorrectJsonFromCrawlDepth() throws IOException, musicParameterException, musicYearException {
        //Arrange
        Crawler webCrawl = spy(Crawler.class);
        Scrapper parser = mock(Scrapper.class);
        WCAController controller = new WCAController();
        String url = "http://localhost/sample_sit/";
        SearchWithDepth newSearch = mock(SearchWithDepth.class);
        String json = "sample";
        String result;
        int max_depth = 5;

        //Act
        when(newSearch.getJson()).thenReturn(json);//indirect input
        result = controller.crawlDepth(webCrawl, parser, url, max_depth, newSearch);
        //Assert
        assertEquals(json, result);
    }


}
