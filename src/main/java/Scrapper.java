import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

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

    public Boolean checkDoc(Document doc) {
        String title = doc.title();
        if (title.isEmpty()){
            return false;
        }
        else
            return true;
    }
}
