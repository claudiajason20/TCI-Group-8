import java.util.ArrayList;

class Books {
    private int id;
    private String format;
    private ArrayList<String> authors;
    private String isbn;
    private String publisher;
    private String year;
    private String genre;

    public Books() {
    }

    public Books(int id, String format, ArrayList<String> authors, String isbn, String publisher, String year, String genre) {
        this.id = id;
        this.format = format;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.genre = genre;
    }

    public int numberOfData() {
//        int num = 0;
        return 0;
    }

    public String getTitle() {
        String cat = "meow";
        return cat;
    }

    public int getId() {
        return id;
    }

    public String getFormat() {
        return format;
    }

    public String getYear() {
        return year;
    }

    public ArrayList<String> getAuthors() {
       return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }
}
