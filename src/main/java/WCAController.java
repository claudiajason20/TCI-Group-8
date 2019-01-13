import java.util.ArrayList;

import org.jsoup.nodes.Document;

/**
 *  WCA Controller class
 *  Handle request from WCA Rest
 */
public class WCAController {

ArrayList<Movies> movies=new ArrayList<>();

    /**
     * To get all of the item from the web
     * @param baseaddress
     * @return JSON in String
     */
    public String getAll(String baseaddress) {

        return null;
    }

    /**
     * To get the specific item from web based on parameter sent on link
     * @param baseaddress
     * @return JSON in String
     */
    public String getSpecific(String baseaddress) {
        return null;
    }

    /**
     * Get the crawl data
     * @param baseaddress
     * @return JSOn in String
     */
    public String getCrawlData(String baseaddress) {
        return null;
    }

    /**
     * To combine baseaddress and parameter
     * @param baseaddress
     * @param parameter
     * @return String
     */
    public String combine(String baseaddress, String parameter) {
        return null;
    }

    /** To insert new movie
     * @param movie
     */
    public void insertMovie(Movies movie) {
        movies.add(movie);
    }

    /**
     * To return list of movies
     * @return list of Movies
     */
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
