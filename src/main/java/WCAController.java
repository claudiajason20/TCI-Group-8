import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class WCAController {
    static int id=1;
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


    public static void getAll(Crawler webCrawl, Scrapper extractor, String url, int type,Search newSearch) throws IOException, musicParameterException, musicYearException {
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
        System.out.println(timeElapsed);
    }

    public void crawlWithDepth(Crawler webCrawl, Scrapper extractor, String url, int max_depth) throws IOException {
        Instant start = Instant.now();
//        a.crawl(url);
        webCrawl.setMax_depth(max_depth);
        webCrawl.crawlWithDepth(url, 0);
//        links.addAll(webCrawl.getVisitedPages());
        for (int i = 0; i < webCrawl.getVisitedPages().size(); i++) {
            extractor.parseAll(webCrawl.getUrl(i));
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    public void getSpecific(Crawler webCrawl, Scrapper extractor, String url, String query, int type) throws IOException {
        Instant start = Instant.now();
//        a.crawl(url);
        if (type == 1) webCrawl.recursiveCrawl(url);
        else webCrawl.crawl(url);
        for (int i = 0; i < webCrawl.getVisitedPages().size(); i++) {
            boolean out = false;
            out = extractor.parseSpecific(webCrawl.getUrl(i), query);//indirect input and output
            if (out) break;
        }
        Instant end = Instant.now();
        int timeElapsed = Duration.between(start, end).getNano();

//
    }
}
