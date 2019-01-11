public class WCAREST {
WCAController wcaController;

    public WCAREST(WCAController wcaController) {
        this.wcaController =wcaController;
    }

    public String receive(int i, String baseaddress, String parameter) {
        if(i==1)
        {
            String base=wcaController.combine(baseaddress,parameter);
            return wcaController.getAll(base);
        }
        else if(i==2) {
            String base=wcaController.combine(baseaddress,parameter);
            return wcaController.getSpecific(base);
        }
        else if(i==3) {
            String base=wcaController.combine(baseaddress,parameter);
            return wcaController.getCrawlData(base);
        }
    return null;
    }
}
