import java.util.ArrayList;

import org.jsoup.nodes.Document;

public class WCAController {
ArrayList<Movies> movies=new ArrayList<>();

    public String getAll(String baseaddress) {

        return null;
    }

    public String getSpecific(String baseaddress) {
        return null;
    }

    public String getCrawlData(String baseaddress) {
        return null;
    }

    public String combine(String baseaddress, String parameter) {
        return null;
    }

    public void insertMovie(Movies movie) {
        movies.add(movie);
    }

    public ArrayList<Movies> getMovies() {
        return this.movies;
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
     * @param html
     * html is the code, not the link. It will be used for scrapping with jsoup.
     */
    public void setHtml(String html) {
    }
}
