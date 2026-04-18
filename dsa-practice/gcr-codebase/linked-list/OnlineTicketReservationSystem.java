// Q9_OnlineTicketReservationSystem.java
// Circular Linked List: Online Ticket Reservation System
package linked_list;

import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class OnlineTicketReservationSystem {
    private Ticket head = null;

    public void addAtEnd(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeByTicketId(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }
        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == head) {
                    Ticket temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        System.out.println("TicketID\tCustomer\tMovie\tSeat\tBookingTime");
        do {
            System.out.println(temp.ticketId + "\t" + temp.customerName + "\t" + temp.movieName + "\t" + temp.seatNumber + "\t" + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println(temp.ticketId + ", " + temp.customerName + ", " + temp.movieName + ", " + temp.seatNumber + ", " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No ticket found for customer: " + customerName);
    }

    public void searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println(temp.ticketId + ", " + temp.customerName + ", " + temp.movieName + ", " + temp.seatNumber + ", " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No ticket found for movie: " + movieName);
    }

    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        OnlineTicketReservationSystem sys = new OnlineTicketReservationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Ticket\n2. Remove by Ticket ID\n3. Display All\n4. Search by Customer Name\n5. Search by Movie Name\n6. Count Tickets\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int tid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String btime = sc.nextLine();
                    sys.addAtEnd(tid, cname, mname, seat, btime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int rid = sc.nextInt();
                    sys.removeByTicketId(rid);
                    break;
                case 3:
                    sys.displayAll();
                    break;
                case 4:
                    System.out.print("Enter Customer Name to search: ");
                    String scname = sc.nextLine();
                    sys.searchByCustomerName(scname);
                    break;
                case 5:
                    System.out.print("Enter Movie Name to search: ");
                    String smname = sc.nextLine();
                    sys.searchByMovieName(smname);
                    break;
                case 6:
                    System.out.println("Total tickets: " + sys.countTickets());
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
