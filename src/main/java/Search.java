import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class Search {
    int id;
    int time_elapsed;

    ArrayList<Music> musicList = new ArrayList<>();
    ArrayList<Movies> movieList = new ArrayList<>();
    ArrayList<Books> bookList = new ArrayList<>();

    public Search(int id,int time_elapsed) {
    }

    public Search() {

    }

    public ArrayList<Music> getMusicList() {
        return musicList;
    }


    public ArrayList<Movies> getMovieList() {
        return movieList;
    }


    public ArrayList<Books> getBookList() {
        return bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTime_elapsed() {
        return time_elapsed;
    }

    public void setTime_elapsed(int time_elapsed) {
        this.time_elapsed = time_elapsed;
    }

    public void addList(ArrayList<Music> musicList, ArrayList<Books> bookList, ArrayList<Movies> movieList) {
        this.musicList = musicList;
        this.bookList = bookList;
        this.movieList = movieList;
    }

    public String getJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);


    }
}

