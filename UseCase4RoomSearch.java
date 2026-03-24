// UC4: Room Search & Availability Check
// Version: 4.0

import java.util.HashMap;

// Room Abstract Class
abstract class Room {
    protected String type;
    protected double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public void display() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: " + price);
    }
}

// Room Types
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1000);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 1800);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3000);
    }
}

// Inventory Class (Read-only usage here)
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0); // unavailable
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

// Search Service
class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory) {

        System.out.println("\n--- Available Rooms ---\n");

        Room[] rooms = {
            new SingleRoom(),
            new DoubleRoom(),
            new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.type);

            if (available > 0) {
                room.display();
                System.out.println("Available: " + available + "\n");
            }
        }
    }
}

// Main Class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" BOOK MY STAY APP - UC4 ");
        System.out.println("=================================");

        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();

        // Perform search (read-only)
        searchService.searchAvailableRooms(inventory);

        System.out.println("\nApplication executed successfully!");
    }
}