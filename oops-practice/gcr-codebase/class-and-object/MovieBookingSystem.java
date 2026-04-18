package class_and_object;

import java.util.Scanner;

// MovieTicket class
class MovieTicket {
    // Attributes
    String movieName;
    String seatNumber;
    double price;

    // Method to book a ticket 
    void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    // Method to display ticket details
    void displayTicket() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }
}

// Main class
public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create MovieTicket object
        MovieTicket ticket = new MovieTicket();

        // Take input for booking
        System.out.print("Enter Movie Name: ");
        String movieName = sc.nextLine();

        System.out.print("Enter Seat Number (e.g., A10): ");
        String seatNumber = sc.nextLine();

        System.out.print("Enter Ticket Price: ");
        double price = sc.nextDouble();

        // Book the ticket
        ticket.bookTicket(movieName, seatNumber, price);

        // Display the booked ticket
        ticket.displayTicket();

        sc.close();
    }
}
