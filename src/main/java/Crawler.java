import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.jsoup.Jsoup.connect;

public class Crawler {
    private Set<String> visitedPages = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();

    public static void main(String args[]) {

    }

    public boolean verifyUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addPageToVisit(String url) {
        if (verifyUrl(url)) {
            pagesToVisit.add(url);
        } else System.out.println("URL is not valid");
    }

    public String getLink(int index) throws IOException {

    }

    public void parseLinks(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        for (int i = 0; i < links.size(); i++) {
            String link = links.get(i).attr("href").toString();
            addPageToVisit(link);
        }
    }

    public int getPagesToVisitSize() {
        return pagesToVisit.size();
    }


}
