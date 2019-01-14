import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class WCAController {
    static int id = 1;

    public void insertmovies(Movies movies) {
    }

    public Movies getmovies() {
        return null;
    }

    public Books getbooks() {
        return null;
    }

    public void insertbooks(Books books) {
    }

    public Music getmusics() {
        return null;
    }

    public void insertmusic(Music music) {
    }

    /**
     * @return Jsoup Document
     */
    public Document getDocument() {
        return null;
    }

    public void setDocument(Document doc) {
    }

    public String getHtml() {
        return null;
    }

    /**
     * @param html html is the code, not the link. It will be used for scrapping with jsoup.
     */
    public void setHtml(String html) {
    }

    /**
     * THis function runs the function crawl all, with the option of running the dfs/bfs crawl, then
     * it runs the function parse all to get all the data from the links
     *
     * @param webCrawl
     * @param extractor
     * @param url
     * @param type
     * @param newSearch
     * @return
     * @throws IOException
     * @throws musicParameterException
     * @throws musicYearException
     */
    public static String getAll(Crawler webCrawl, Scrapper extractor, String url, int type, Search newSearch) throws IOException, musicParameterException, musicYearException {
        Instant start = Instant.now();
        if (type == 1) webCrawl.recursiveCrawl(url);
        else webCrawl.crawl(url);
        int size = webCrawl.getVisitedPagesSize();
        System.out.println("Size" + size);
        for (int i = 0; i < size; i++) {//indirect input
            System.out.println("in");
            extractor.parseAll(webCrawl.getUrl(i));//input output
        }
        Instant end = Instant.now();
        int timeElapsed = Duration.between(start, end).getNano();
        newSearch.addList(extractor.getMusicList(), extractor.getBookList(), extractor.getMovieList());
        return newSearch.getJson();
    }

    /**
     * This function calls the crawlWithDepth function which recursively crawls until a specified Depth is reached, then it will parse all the information from the links given
     * @param webCrawl
     * @param extractor
     * @param url
     * @param max_depth
     * @param newSearch
     * @return
     * @throws IOException
     */
    public String crawlDepth(Crawler webCrawl, Scrapper extractor, String url, int max_depth, Search newSearch) throws IOException {
        Instant start = Instant.now();
        webCrawl.setMax_depth(max_depth);
        webCrawl.crawlWithDepth(url, 0);
        int size = webCrawl.getVisitedPagesSize();
        for (int i = 0; i < size; i++) {
            extractor.parseAll(webCrawl.getUrl(i));
        }
        Instant end = Instant.now();

        newSearch.addList(extractor.getMusicList(), extractor.getBookList(), extractor.getMovieList());
        return newSearch.getJson();
    }

    /**
     * This test crawl all of the website, and then give it to the parser to find the specific query given, it will stop when the given query is found
     * @param webCrawl
     * @param extractor
     * @param url
     * @param query
     * @param type
     * @param newSearch
     * @return
     * @throws IOException
     */
    public String getSpecific(Crawler webCrawl, Scrapper extractor, String url, String query, int type, Search newSearch) throws IOException {
        Instant start = Instant.now();
        if (type == 1) webCrawl.recursiveCrawl(url);
        else webCrawl.crawl(url);
        int size = webCrawl.getVisitedPagesSize();

        for (int i = 0; i < size; i++) {
            boolean out = false;
            out = extractor.parseSpecific(webCrawl.getUrl(i), query);//indirect input and output
            if (out) break;
        }
        Instant end = Instant.now();
        int timeElapsed = Duration.between(start, end).getNano();
        newSearch.addList(extractor.getMusicList(), extractor.getBookList(), extractor.getMovieList());
        return newSearch.getJson();
    }
}
