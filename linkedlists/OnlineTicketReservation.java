package linkedlists;

/**
 * OnlineTicketReservation - Manages ticket reservations using a Circular Linked
 * List.
 * Attributes: Ticket ID, Customer Name, Movie Name, Seat Number, Booking Time.
 */
public class OnlineTicketReservation {

    private static class Node {
        int ticketId;
        String custName, movieName, seatNum, bookingTime;
        Node next;

        Node(int id, String cust, String movie, String seat, String time) {
            this.ticketId = id;
            this.custName = cust;
            this.movieName = movie;
            this.seatNum = seat;
            this.bookingTime = time;
        }
    }

    private Node head;
    private int ticketCount = 0;

    // Add new ticket reservation at the end of circular list
    public void addTicket(int id, String cust, String movie, String seat, String time) {
        Node newNode = new Node(id, cust, movie, seat, time);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node last = head;
            // Find the current tail
            while (last.next != head)
                last = last.next;
            last.next = newNode;
            newNode.next = head;
        }
        ticketCount++;
    }

    // Remove a ticket by Ticket ID and update circular pointers
    public void removeById(int id) {
        if (head == null)
            return;

        Node current = head, prev = null;
        do {
            if (current.ticketId == id) {
                if (current == head && current.next == head) {
                    head = null;
                } else {
                    if (current == head) {
                        Node last = head;
                        while (last.next != head)
                            last = last.next;
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = current.next;
                    }
                }
                ticketCount--;
                System.out.println("Removed Ticket ID: " + id);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket ID " + id + " not found.");
    }

    // Displays all booked tickets in the circular list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No reservations made.");
            return;
        }
        System.out.println("\n--- All Reserved Tickets ---");
        Node current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + " | Customer: " + current.custName + " | Movie: "
                    + current.movieName + " | Seat: " + current.seatNum);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void search(String cust, String movie) {
        if (head == null)
            return;
        Node current = head;
        boolean found = false;
        do {
            if ((cust != null && current.custName.equalsIgnoreCase(cust)) ||
                    (movie != null && current.movieName.equalsIgnoreCase(movie))) {
                System.out.println(
                        "Match: Ticket ID " + current.ticketId + " | " + current.custName + " | " + current.movieName);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found)
            System.out.println("No reservations matching criteria found.");
    }

    // Return the total number of booked tickets
    public int getTicketCount() {
        return ticketCount;
    }

    public static void main(String[] args) {
        OnlineTicketReservation otr = new OnlineTicketReservation();
        otr.addTicket(1001, "Alice", "Inception", "A1", "10:00 AM");
        otr.addTicket(1002, "Bob", "Avatar", "B1", "11:00 AM");
        otr.addTicket(1003, "Alice", "Tenet", "C1", "12:00 PM");
        otr.displayTickets();
        otr.search("Alice", null);
        System.out.println("Total Booked: " + otr.getTicketCount());
        otr.removeById(1002);
        otr.displayTickets();
    }
}
