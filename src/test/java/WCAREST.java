/**
 * WCA REST class
 * To become a gate for input from user and controller to receive the result
 */
public class WCAREST {
WCAController wcaController;

    /**
     * Construcotr for WCA REST
     * @param wcaController
     */
    public WCAREST(WCAController wcaController) {
        this.wcaController =wcaController;
    }

    /**
     * Empty constructor for WCA REST
     */
    public WCAREST() {

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
            String base=wcaController.combine(baseaddress,parameter);
            return wcaController.getAll(base);
        }
        else if(choice==2) {
            String base=wcaController.combine(baseaddress,parameter);
            return wcaController.getSpecific(base);
        }
        else if(choice==3) {
            String base=wcaController.combine(baseaddress,parameter);
            return wcaController.getCrawlData(base);
        }
    else throw new IllegalArgumentException();
    }
}
