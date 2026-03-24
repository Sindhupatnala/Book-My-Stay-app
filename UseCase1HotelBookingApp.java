/**
 * Hotel Booking Management System
 * Use Case 2: Basic Room Types & Static Availability
 *
 * @author Phani
 * @version 2.0
 */

// Abstract class
abstract class Room {
    protected String type;
    protected int beds;
    protected double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public void display() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price: " + price);
    }
}

// Single Room
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1000);
    }
}

// Double Room
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 1800);
    }
}

// Suite Room
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 3000);
    }
}

// Main class (same name as file)
public class UseCase1HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App (v2.0) =====");

        // Polymorphism
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\n--- Room Details ---\n");

        r1.display();
        System.out.println("Available: " + singleAvailable + "\n");

        r2.display();
        System.out.println("Available: " + doubleAvailable + "\n");

        r3.display();
        System.out.println("Available: " + suiteAvailable + "\n");

        System.out.println("Application executed successfully!");
    }
}