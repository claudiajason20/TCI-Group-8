import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Movies class
 */
public class Movies {
    public int id;
    public final String name;
    public String genre;
    public String format;
    public final String year;
    public final String director;
    public ArrayList<String>writers = new ArrayList<String>();
    public ArrayList<String>stars = new ArrayList<String>();


    /**
     * Movies constructor
     * @param id not Zero
     * @param name not NULL
     * @param genre
     * @param format
     * @param year not older than 1901
     * @param director
     * @param writers
     * @param stars
     */
    public Movies(int id, String name, String genre, String format, String year, String director, ArrayList<String> writer, ArrayList<String> star) {
    if(name==null || id==0 || Integer.parseInt(year)<=1900)
    {
    throw new IllegalArgumentException();
    }
    this.id=id;
    this.name=name;
    this.genre=genre;
    this.format=format;
    this.year=year;
    this.director=director;
    this.writers=writer;
    this.stars=star;
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
     * @return list of writers
     */
    public ArrayList<String> getwriter() {
        return writers;
    }

    /**
     * @return list of stars
     */
    public ArrayList<String> getstar() {
        return stars;
    }

    public void setid(int i) {
        this.id=id;
    }

    public void setformat(String cd) {
        this.format=cd;
    }

    public void setgenre(String action) {
        this.genre=action;
    }
}
