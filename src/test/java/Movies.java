/**
 * Movies class
 */
public class Movies {
    private final int id;
    private final String name;
    private final String genre;
    private final String format;
    private final String year;
    private final String director;
    private final String writer;
    private final String star;

    /**
     * Movies constructor
     * @param id
     * @param name
     * @param genre
     * @param format
     * @param year
     * @param director
     * @param writer
     * @param star
     */
    public Movies(int id, String name, String genre, String format, String year, String director, String writer, String star) {
    if(name==null)
    {
    throw new NullPointerException();
    }
    this.id=id;
    this.name=name;
    this.genre=genre;
    this.format=format;
    this.year=year;
    this.director=director;
    this.writer=writer;
    this.star=star;
    }

    /**
     * @return id
     */
    public int getid() {
        return id;
    }

    /**
     * @return name
     */
    public String getname() {
        return name;
    }

    /**
     * @return genre
     */
    public String getgenre() {
        return genre;
    }

    /**
     * @return format
     */
    public String getformat() {
        return format;
    }


    /**
     * @return year
     */
    public String getyear() {
        return year;
    }

    /**
     * @return director
     */
    public String getdirector() {
        return director;
    }

    /**
     * @return writer
     */
    public String getwriter() {
        return writer;
    }

    /**
     * @return star
     */
    public String getstar() {
        return star;
    }
}
