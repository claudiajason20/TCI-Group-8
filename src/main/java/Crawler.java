import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Crawler {
    private Set<String> visitedPages= new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();

    public static void main(String args[]){

    }

    public boolean verifyUrl(String url){
        try {
            new URL(url).toURI();
            return true;
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
