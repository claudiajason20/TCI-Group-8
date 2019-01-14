import java.io.IOException;

/**
 * WCA REST class
 * To become a gate for input from user and controller to receive the result
 */
public class WCAREST {
WCAController wcaController;
    Crawler crawler;
    Scrapper scrapper;
    Search search;




    /**
     * constructor for WCA REST
     * @param wcaController
     * @param crawler
     * @param scrapper
     * @param search
     */
    public WCAREST(WCAController wcaController, Crawler crawler, Scrapper scrapper, Search search) {
this.wcaController=wcaController;
this.scrapper=scrapper;
this.crawler=crawler;
this.search=search;
    }

    /**
     * Receive the request from user and based on the parameter and request, send the request to the right function
     * Can oonly accpet number 1 to 3 as the choice option
     * @param choice
     * @param baseaddress
     * @param parameter
     * @return String
     */
    public String receive(int choice, String baseaddress, String parameter) {
        if(choice==1)
        {
            CombinedLink base=wcaController.combine(baseaddress,parameter);
            try {
                return wcaController.getAll(crawler,scrapper,base.getBase(),1,search);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (musicParameterException e) {
                e.printStackTrace();
            } catch (musicYearException e) {
                e.printStackTrace();
            }
        }
        else if(choice==2) {
            CombinedLink base=wcaController.combine(baseaddress,parameter);
            try {
                return wcaController.getSpecific(crawler,scrapper,base.getBase(),base.getParam(),1,search);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(choice==3) {
            CombinedLink base=wcaController.combine(baseaddress,parameter);
            try {
                return wcaController.crawlDepth(crawler,scrapper,base.getBase(),Integer.parseInt(base.getParam()),search);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    else throw new IllegalArgumentException();
    return null;
    }
}
