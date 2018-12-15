import java.util.ArrayList;

class Books {
    private int id;
    private String format;
    private ArrayList<String> authors;
    private String isbn;
    private String publisher;
    private String year;
    private String genre;
    private String title;

    public Books() {
    }

    /**
     * @param id
     * @param format
     * @param authors
     * @param isbn
     * @param publisher
     * @param year
     * @param genre
     */
    public Books(int id, String format, ArrayList<String> authors, String isbn, String publisher, String year, String genre, String title) {
        this.id = id;
        this.format = format;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.genre = genre;
        this.title = title;
    }

    public int numberOfData() {
//        int num = 0;
        return 0;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * @return authors
     */
    public ArrayList<String> getAuthors() {
       return authors;
    }

    /**
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param s
     */
    public void setYear(String s) {
        year = s;
    }

    public void setTitle(String s) {
        title = s;
    }
}
