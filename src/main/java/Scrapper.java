import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Scrapper {
    private static Document docu;

    ArrayList<Music> musicList = new ArrayList<>();
    ArrayList<Movies> movieList = new ArrayList<>();
    ArrayList<Books> bookList = new ArrayList<>();

    public ArrayList<Music> getMusicList() {
        return musicList;
    }

    public ArrayList<Movies> getMovieList() {
        return movieList;
    }

    public ArrayList<Books> getBookList() {
        return bookList;
    }

    public static void setDoc(Document doc) {
        docu = doc;
    }

    public boolean text(Document doc) {
//        return doc.body().hasText();
        return true;
    }

    public String getBodyText() {
        return docu.body().text();
    }

    public Boolean hasVisited(Node node) {
        return null;
    }

    public Boolean checkDoc(Document doc) {
        String title = doc.title();
        if (title.isEmpty()){
            return false;
        }
        else
            return true;
    }


    public void parseAll(String url) {
    }

    public boolean parseSpecific(String url, String query) {
    return true;
    }
}
