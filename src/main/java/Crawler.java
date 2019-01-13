import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Crawler {
    private Set<String> visitedPages = new HashSet<String>();

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
        } else throw new RuntimeException("BASE URL IS NOT VALID");
        int i = 0;
        while (pagesToVisit.size() > 0) {
            String nextUrl = ((LinkedList<String>) pagesToVisit).pop();
            visitedPages.add(nextUrl);
//            Document html = Jsoup.connect(nextUrl).get();
            Elements links = getLinks(nextUrl);
            for (Element link : links) {
                String pageLink = link.attr("abs:href").toLowerCase();
                if (!visitedPages.contains(pageLink) && verifyWebsiteOnly(pageLink)) {
                    System.out.println("Pages to be review : " + pageLink);
                    System.out.println("Success");
                    pagesToVisit.add(pageLink);
                }
            }
        }
    }

    public void recursiveCrawl(String url) throws IOException {
        visitedPages.add(url);
        Elements links = getLinks(url);
        for (Element link : links) {
            String pageLink = link.attr("abs:href").toLowerCase();
            if (!visitedPages.contains(pageLink) && verifyWebsiteOnly(pageLink)) {
                recursiveCrawl(pageLink);
            }
        }
    }

    public Elements getLinks(String url) throws IOException {
        Document html = Jsoup.connect(url).get();
        return html.select("a[href]");
    }

    public Set<String> getVisitedPages() {
        return visitedPages;
    }
}
