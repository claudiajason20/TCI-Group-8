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
        else if(i==2)
            return wcaController.getSpecific(baseaddress,parameter);
        else if(i==3)
            return wcaController.getCrawlData(baseaddress,parameter);
    return null;
    }
}
