import java.time.LocalDate;

public class Music {
    int mu_id;
    String mu_title;
    String mu_category;
    String mu_genre;
    String mu_format;
    String mu_artist;

    int mu_year;
    int historyDate=1877;
    public Music(int id,String title, String category, String genre, String format, int year, String artist) throws musicYearException, musicParameterException {
        mu_id=id;
        if(title!=null &&category!=null&&genre!=null&&format!=null&&artist!=null) {
            mu_title = title;
            mu_category = category;
            mu_genre = genre;
            mu_format = format;
            LocalDate localDate = LocalDate.now();
            if (year <= localDate.getYear() && year >= historyDate) {
                mu_year = year;
            } else throw new musicYearException("Music Year is not valid!");
            mu_artist = artist;
        } else throw new musicParameterException("Parameters should not be null!");
    }

}
