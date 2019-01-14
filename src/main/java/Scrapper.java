import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Scrapper {
    ArrayList<Music> musicList = new ArrayList<>();
    ArrayList<Movies> movieList = new ArrayList<>();
    ArrayList<Books> bookList = new ArrayList<>();

    public void main(String args[]) {

    }

    public void parseAll(String pageLink) throws IOException, musicParameterException, musicYearException {
        Document page = Jsoup.connect(pageLink).get();
        Elements classElement = page.getElementsByClass("media-details");

        for (Element content : classElement) {
//            System.out.println();
            Element category = content.select("tr:contains(category)").get(0);
            String cat = category.select("td").get(0).text().toLowerCase();
            String title = content.select("h1").get(0).text();
            int id = getId(pageLink);
            addToList(id,cat,title,content);
        }
        System.out.println(pageLink + " :Parsing finished");
    }

    public boolean parseSpecific(String pageLink, String search) throws IOException, musicParameterException, musicYearException {
        Document page = Jsoup.connect(pageLink).get();
        Elements classElement = page.getElementsByClass("media-details");

        for (Element content : classElement) {
//            System.out.println();
            Element category = content.select("tr:contains(category)").get(0);
            String cat = category.select("td").get(0).text().toLowerCase();
            String title = content.select("h1").get(0).text();
            if (title.toLowerCase().contains(search)) {
                int id = getId(pageLink);
                addToList(id,cat,title,content);
                return true;
            }
        }
        return false;

    }

    public void addToList(int id,String cat, String title,Element content) throws musicParameterException, musicYearException {
        String genre = getAttribute("genre", content);
        String format = getAttribute("format", content);
        String year = getAttribute("year", content);
        if (cat.equals("music")) {
            String artist = getAttribute("artist", content);
            Music music = new Music(id, title, cat, genre, format, year, artist);
            musicList.add(music);
        } else if (cat.equals("movies")) {
            String director = getAttribute("director", content);
            ArrayList<String> Writers = getAttributeList("writers", content);
            ArrayList<String> Stars = getAttributeList("stars", content);
            Movies movie = new Movies(id, title, genre, format, year, director, Writers, Stars);
            movieList.add(movie);
        } else if (cat.equals("books")) {
            ArrayList<String> authors = getAttributeList("authors", content);
            String publisher = getAttribute("publisher", content);
            String isbn = getAttribute("isbn", content);
            Books book = new Books(id, format, authors, isbn, publisher, year, genre, title);
            bookList.add(book);
        }
    }

    public ArrayList<Music> getMusicList() {
        return musicList;
    }

    public ArrayList<Movies> getMovieList() {
        return movieList;
    }

    public ArrayList<Books> getBookList() {
        return bookList;
    }

    public String getAttribute(String attribute, Element content) {
        Element attributeElement = content.select("tr:contains(" + attribute + ")").get(0);
        String attributeText = attributeElement.select("td").get(0).text();
        return attributeText;
    }

    public ArrayList<String> getAttributeList(String attribute, Element content) {
        Element attributeElement = content.select("tr:contains(" + attribute + ")").get(0);
        String attributeText = attributeElement.select("td").get(0).text();
        String arr[] = attributeText.split(",");
        ArrayList<String> attList = new ArrayList<>();
        int i = 0;
        for (String att : arr) {
            attList.add(att);
        }
        return attList;
    }

    public int getId(String url) {
        String arr[] = url.split("=");
        return Integer.parseInt(arr[1]);
    }

    public void printMusicContent() {
        for (Music music : musicList) {
            System.out.println("ID: " + music.mu_id);
            System.out.println("Title: " + music.mu_title);
            System.out.println("Genre: " + music.mu_genre);
            System.out.println("Format: " + music.mu_format);
            System.out.println("Artist: " + music.mu_artist);
            System.out.println("Year: " + music.mu_year);
        }
    }
    public void printMovie() {
        for (Movies movie : movieList) {
            System.out.println("ID: " + movie.id);
            System.out.println("Title: " + movie.name);
            System.out.println("Genre: " + movie.genre);
            System.out.println("Format: " + movie.format);
            System.out.println("Artist: " + movie.stars);
            System.out.println("Year: " + movie.year);
        }
    }
}
