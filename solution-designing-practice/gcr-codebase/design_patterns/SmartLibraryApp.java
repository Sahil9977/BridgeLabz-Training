package design_patterns;

public class SmartLibraryApp {
    public static void main(String[] args) {
       
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User s1 = UserFactory.createUser("STUDENT", "Alice");
        User f1 = UserFactory.createUser("FACULTY", "Dr. Smith");

        catalog.subscribe(s1);
        catalog.subscribe(f1);

        Book newBook = new Book.BookBuilder("Data Structures", "Cormen")
                            .setGenre("Computer Science")
                            .setEdition("3rd Edition")
                            .build();

        System.out.println("Adding to catalog: " + newBook);
        catalog.addBook(newBook.toString());
    }
}