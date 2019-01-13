import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Crawler {
    public boolean verifyUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean verifyWebsiteOnly(String url) {
        if (url.contains("localhost")) return true;
        else return false;
    }
    public void crawl(String url) throws IOException {
        List<String> pagesToVisit = new LinkedList<String>();
        if (verifyUrl(url) && verifyWebsiteOnly(url)) {
            pagesToVisit.add(url);
        }else throw new RuntimeException("BASE URL IS NOT VALID");
    }
    public Elements getLinks(String url) throws IOException {
        Document html = Jsoup.connect(url).get();
        return html.select("a[href]");
    }
}
