// UC5: Booking Request Queue (FIFO)
// Version: 5.0

import java.util.LinkedList;
import java.util.Queue;

// Reservation Class
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Room: " + roomType);
    }
}

// Booking Queue Class
class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Booking request added.");
    }

    // View queue
    public void displayQueue() {
        System.out.println("\n--- Booking Request Queue ---\n");

        if (queue.isEmpty()) {
            System.out.println("No booking requests.");
            return;
        }

        for (Reservation r : queue) {
            r.display();
        }
    }
}

// Main Class
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" BOOK MY STAY APP - UC5 ");
        System.out.println("=================================");

        BookingQueue bookingQueue = new BookingQueue();

        // Adding requests (FIFO order)
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));

        // Display queue
        bookingQueue.displayQueue();

        System.out.println("\nApplication executed successfully!");
    }
}