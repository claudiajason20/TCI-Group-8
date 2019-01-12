import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scrapper {
    public void parseAll(String pageLink) throws IOException{
        Document page = Jsoup.connect(pageLink).get();
        Elements classElement = page.getElementsByClass("media-details");

        for (Element content : classElement) {
//            System.out.println();
            Element category = content.select("tr:contains(category)").get(0);
            String cat = category.select("td").get(0).text().toLowerCase();
            String title = content.select("h1").get(0).text();
        }
        System.out.println(pageLink + " :Parsing finished");
    }
}
