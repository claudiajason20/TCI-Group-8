public class SearchWithDepth extends Search {
    int pages_explored;
    int depth;

    public SearchWithDepth(int id, int time_elapsed, int pages_explored, int depth) {
        super(id, time_elapsed);
        this.pages_explored = pages_explored;
        this.depth = depth;
    }

    public int getPages_explored() {
        return pages_explored;
    }

    public void setPages_explored(int pages_explored) {
        this.pages_explored = pages_explored;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
