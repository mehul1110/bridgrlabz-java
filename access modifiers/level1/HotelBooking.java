/*
 * Program for Hotel Booking System
 * Manages guest bookings with multiple constructor types
 */
public class HotelBooking {
    
    // Instance variables
    private String guestName;
    private String roomType;
    private int nights;

    /*
     * Default Constructor
     * Initializes booking with default values
     */
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    /*
     * Parameterized Constructor
     * Initializes booking with user specified details
     */
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    /*
     * Copy Constructor
     * Creates a duplicate booking from an existing one
     */
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking info
    public void displayBooking() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Default booking
        HotelBooking b1 = new HotelBooking();
        b1.displayBooking();

        // Specific booking
        HotelBooking b2 = new HotelBooking("John Doe", "Deluxe", 3);
        b2.displayBooking();

        // Copy booking
        HotelBooking b3 = new HotelBooking(b2);
        b3.displayBooking();
    }
}
