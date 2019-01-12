import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

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

}
