
package linked_list;

import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;
    Book prev, next;

    public Book(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        this.prev = null;
        this.next = null;
    }
}

public class LibraryManagementSystem {
    private Book head, tail;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean available) {
        Book newBook = new Book(title, author, genre, bookId, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean available) {
        Book newBook = new Book(title, author, genre, bookId, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean available) {
        if (pos <= 1) {
            addAtBeginning(title, author, genre, bookId, available);
            return;
        }
        Book temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, available);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, available);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    public void removeByBookId(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.title + ", " + temp.author + ", " + temp.genre + ", " + temp.bookId + ", " + (temp.available ? "Available" : "Not Available"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.title + ", " + temp.author + ", " + temp.genre + ", " + temp.bookId + ", " + (temp.available ? "Available" : "Not Available"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with author: " + author);
    }

    public void updateAvailability(int bookId, boolean available) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.available = available;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void displayForward() {
        Book temp = head;
        if (temp == null) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Title\tAuthor\tGenre\tBookID\tStatus");
        while (temp != null) {
            System.out.println(temp.title + "\t" + temp.author + "\t" + temp.genre + "\t" + temp.bookId + "\t" + (temp.available ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        if (temp == null) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Title\tAuthor\tGenre\tBookID\tStatus");
        while (temp != null) {
            System.out.println(temp.title + "\t" + temp.author + "\t" + temp.genre + "\t" + temp.bookId + "\t" + (temp.available ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Book ID\n5. Search by Title\n6. Search by Author\n7. Update Availability\n8. Display Forward\n9. Display Reverse\n10. Count Books\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String t1 = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String a1 = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String g1 = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean av1 = sc.nextBoolean();
                    lib.addAtBeginning(t1, a1, g1, id1, av1);
                    break;
                case 2:
                    System.out.print("Enter Title: ");
                    String t2 = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String a2 = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String g2 = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int id2 = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean av2 = sc.nextBoolean();
                    lib.addAtEnd(t2, a2, g2, id2, av2);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String t3 = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String a3 = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String g3 = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int id3 = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean av3 = sc.nextBoolean();
                    lib.addAtPosition(pos, t3, a3, g3, id3, av3);
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int rid = sc.nextInt();
                    lib.removeByBookId(rid);
                    break;
                case 5:
                    System.out.print("Enter Title to search: ");
                    String st = sc.nextLine();
                    lib.searchByTitle(st);
                    break;
                case 6:
                    System.out.print("Enter Author to search: ");
                    String sa = sc.nextLine();
                    lib.searchByAuthor(sa);
                    break;
                case 7:
                    System.out.print("Enter Book ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean uav = sc.nextBoolean();
                    lib.updateAvailability(uid, uav);
                    break;
                case 8:
                    lib.displayForward();
                    break;
                case 9:
                    lib.displayReverse();
                    break;
                case 10:
                    System.out.println("Total books: " + lib.countBooks());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
