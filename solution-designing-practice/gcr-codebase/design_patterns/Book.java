package design_patterns;

class Book {
    private final String title;     
    private final String author;  
    private final String genre;     
    private final String edition;   

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.genre = builder.genre;
        this.edition = builder.edition;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author + (genre != null ? ", Genre: " + genre : "");
    }

    public static class BookBuilder {
        private final String title;
        private final String author;
        private String genre;
        private String edition;

        public BookBuilder(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public BookBuilder setGenre(String genre) { this.genre = genre; return this; }
        public BookBuilder setEdition(String edition) { this.edition = edition; return this; }
        public Book build() { return new Book(this); }
    }
}