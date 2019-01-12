import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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

    public Boolean hasVisited(Node node, Node node2) {
        return node.hasSameValue(node2);
    }

    /*
     * to check the document that was sent is not empty.
     */
    public Boolean checkElement(Element doc) {
        return doc.hasText();
    }

    /*
     * Will return String of the data based on the Id
     */
    public String getDataById(int i) {
        return "music";
    }


    public Object getSpecific(int i) {
        return "music";
    }
}
