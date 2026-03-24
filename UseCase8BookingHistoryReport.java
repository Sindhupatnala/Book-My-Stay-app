// UC8: Booking History & Reporting
// Version: 8.0

import java.util.*;

// Reservation Class
class Reservation {
    String guestName;
    String roomType;
    String roomId;

    public Reservation(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    public void display() {
        System.out.println("Guest: " + guestName +
                " | Room: " + roomType +
                " | Room ID: " + roomId);
    }
}

// Booking History
class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getHistory() {
        return history;
    }
}

// Report Service
class BookingReportService {

    public void generateReport(List<Reservation> history) {

        System.out.println("\n--- Booking History Report ---\n");

        if (history.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : history) {
            r.display();
        }

        System.out.println("\nTotal Bookings: " + history.size());
    }
}

// Main Class
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" BOOK MY STAY APP - UC8 ");
        System.out.println("=================================");

        BookingHistory history = new BookingHistory();
        BookingReportService report = new BookingReportService();

        // Simulate confirmed bookings
        history.addReservation(new Reservation("Alice", "Single Room", "SI_1"));
        history.addReservation(new Reservation("Bob", "Double Room", "DO_2"));
        history.addReservation(new Reservation("Charlie", "Suite Room", "SU_3"));

        // Generate report
        report.generateReport(history.getHistory());

        System.out.println("\nApplication executed successfully!");
    }
}