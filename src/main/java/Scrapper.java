import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class Scrapper {
    private static Document docu;

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
}
