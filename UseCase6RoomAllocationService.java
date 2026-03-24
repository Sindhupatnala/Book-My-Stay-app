// UC6: Reservation Confirmation & Room Allocation
// Version: 6.0

import java.util.*;

// Reservation Class
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Inventory Service
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void reduceAvailability(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }

    public void displayInventory() {
        System.out.println("\n--- Updated Inventory ---");
        for (String key : inventory.keySet()) {
            System.out.println(key + " : " + inventory.get(key));
        }
    }
}

// Booking Queue
class BookingQueue {
    Queue<Reservation> queue = new LinkedList<>();

    public void add(Reservation r) {
        queue.add(r);
    }

    public Reservation getNext() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Booking Service
class BookingService {

    private Set<String> allocatedRooms = new HashSet<>();
    private HashMap<String, Set<String>> roomMap = new HashMap<>();

    public void processBookings(BookingQueue queue, RoomInventory inventory) {

        System.out.println("\n--- Processing Bookings ---\n");

        while (!queue.isEmpty()) {

            Reservation r = queue.getNext();

            int available = inventory.getAvailability(r.roomType);

            if (available > 0) {

                String roomId = r.roomType.substring(0, 2).toUpperCase() + "_" + (allocatedRooms.size() + 1);

                // Ensure uniqueness
                while (allocatedRooms.contains(roomId)) {
                    roomId = r.roomType.substring(0, 2).toUpperCase() + "_" + (allocatedRooms.size() + 1);
                }

                allocatedRooms.add(roomId);

                roomMap.putIfAbsent(r.roomType, new HashSet<>());
                roomMap.get(r.roomType).add(roomId);

                inventory.reduceAvailability(r.roomType);

                System.out.println("Booking Confirmed → " + r.guestName +
                        " | " + r.roomType +
                        " | Room ID: " + roomId);

            } else {
                System.out.println("Booking Failed (No Availability) → " + r.guestName +
                        " | " + r.roomType);
            }
        }
    }
}

// Main Class
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" BOOK MY STAY APP - UC6 ");
        System.out.println("=================================");

        RoomInventory inventory = new RoomInventory();
        BookingQueue queue = new BookingQueue();
        BookingService service = new BookingService();

        // Add booking requests
        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Single Room"));
        queue.add(new Reservation("Charlie", "Single Room")); // will fail
        queue.add(new Reservation("David", "Suite Room"));

        // Process bookings
        service.processBookings(queue, inventory);

        // Show updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication executed successfully!");
    }
}