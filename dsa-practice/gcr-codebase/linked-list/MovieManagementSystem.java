
package linked_list;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    Movie prev, next;

    public Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

public class MovieManagementSystem {
    private Movie head, tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + ", " + temp.director + ", " + temp.yearOfRelease + ", " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }

    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + ", " + temp.director + ", " + temp.yearOfRelease + ", " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    public void displayForward() {
        Movie temp = head;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Title\tDirector\tYear\tRating");
        while (temp != null) {
            System.out.println(temp.title + "\t" + temp.director + "\t" + temp.yearOfRelease + "\t" + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Title\tDirector\tYear\tRating");
        while (temp != null) {
            System.out.println(temp.title + "\t" + temp.director + "\t" + temp.yearOfRelease + "\t" + temp.rating);
            temp = temp.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public static void main(String[] args) {
        MovieManagementSystem list = new MovieManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Title\n5. Search by Director\n6. Search by Rating\n7. Display Forward\n8. Display Reverse\n9. Update Rating\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String t1 = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String d1 = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int y1 = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double r1 = sc.nextDouble();
                    list.addAtBeginning(t1, d1, y1, r1);
                    break;
                case 2:
                    System.out.print("Enter Title: ");
                    String t2 = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String d2 = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int y2 = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double r2 = sc.nextDouble();
                    list.addAtEnd(t2, d2, y2, r2);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String t3 = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String d3 = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int y3 = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double r3 = sc.nextDouble();
                    list.addAtPosition(pos, t3, d3, y3, r3);
                    break;
                case 4:
                    System.out.print("Enter Title to remove: ");
                    String rt = sc.nextLine();
                    list.removeByTitle(rt);
                    break;
                case 5:
                    System.out.print("Enter Director to search: ");
                    String sd = sc.nextLine();
                    list.searchByDirector(sd);
                    break;
                case 6:
                    System.out.print("Enter Rating to search: ");
                    double sr = sc.nextDouble();
                    list.searchByRating(sr);
                    break;
                case 7:
                    list.displayForward();
                    break;
                case 8:
                    list.displayReverse();
                    break;
                case 9:
                    System.out.print("Enter Title: ");
                    String ut = sc.nextLine();
                    System.out.print("Enter new Rating: ");
                    double ur = sc.nextDouble();
                    list.updateRating(ut, ur);
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
