package collectors;

import java.util.*;
import java.util.stream.*;

class LibraryBookS{
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Java", "Tech", 500),
                new Book("Python", "Tech", 400),
                new Book("Story", "Fiction", 300)
        );

        Map<String, IntSummaryStatistics> stats =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        System.out.println(stats);
    }
}

class Book {
    private String title;
    private String genre;
    private int pages;

    Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    String getGenre() { return genre; }
    int getPages() { return pages; }
}
