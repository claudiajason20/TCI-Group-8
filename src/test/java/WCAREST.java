public class WCAREST {
    public String receive() {
        return null;
    }

    public String receive(int i, String baseaddress, String s, WCAController wcaController) {
        return wcaController.getAll(baseaddress);
    }
}
