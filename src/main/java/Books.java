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
            return 0;
        }

        public String getTitle() {
            return this.title;
        }

        public int getId() {
            return this.id;
        }

        public String getFormat() {
            return this.format;
        }

        public String getYear() {
            return this.year;
        }

        public ArrayList<String> getAuthors() {
            return this.authors;
        }

        public String getPublisher() {
            return this.publisher;
        }

        public String getGenre() {
            return this.genre;
        }

        public String getIsbn() {
            return this.isbn;
        }

        public void setYear(String s) {
            this.year = s;
        }

        public void setTitle(String s) {
            this.title = s;
        }
}
