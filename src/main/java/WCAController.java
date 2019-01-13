import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class WCAController {

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


    public static void getAll(Crawler webCrawl, Scrapper extractor, String url, int type) throws IOException, musicParameterException, musicYearException {
        ArrayList<Music> musicList = new ArrayList<>();
        ArrayList<Movies> movieList = new ArrayList<>();
        ArrayList<Books> bookList = new ArrayList<>();
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
        System.out.println(timeElapsed);
    }
}
