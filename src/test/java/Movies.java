public class Movies {
    private final int id;
    private final String name;
    private final String genre;
    private final String format;
    private final String year;
    private final String director;
    private final String writer;
    private final String star;

    public Movies(int id, String name, String genre, String format, String year, String director, String writer, String star) {
    this.id=id;
    this.name=name;
    this.genre=genre;
    this.format=format;
    this.year=year;
    this.director=director;
    this.writer=writer;
    this.star=star;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getgenre() {
        return genre;
    }

    public String getformat() {
        return format;
    }

    public String getyear() {
        return year;
    }

    public String getdirector() {
        return director;
    }

    public String getwriter() {
        return writer;
    }

    public String getstar() {
        return star;
    }
}
