public class WCAREST {
    public String receive() {
        return null;
    }

    public String receive(int i, String baseaddress, String s, WCAController wcaController) {
        if(i==1)
        return wcaController.getAll(baseaddress);
        else if(i==2)
            return wcaController.getSpecific(baseaddress,s);
    return null;
    }
}
