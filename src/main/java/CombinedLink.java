public class CombinedLink {
    private  String base;
    private  String param;

    public CombinedLink(String baseaddress, String parameter) {
        this.base=baseaddress;
        this.param=parameter;
    }

    public CombinedLink() {

    }

    public String getBase() {
        return base;
    }

    public String getParam() {
        return param;
    }
}
