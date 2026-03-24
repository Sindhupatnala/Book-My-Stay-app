// UC9: Error Handling & Validation
// Version: 9.0

import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Reservation Class
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Inventory
class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 1);
    }

    public void validateRoom(String roomType) throws InvalidBookingException {
        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }
    }

    public void checkAvailability(String roomType) throws InvalidBookingException {
        if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException("No availability for: " + roomType);
        }
    }

    public void bookRoom(String roomType) throws InvalidBookingException {
        validateRoom(roomType);
        checkAvailability(roomType);

        inventory.put(roomType, inventory.get(roomType) - 1);

        System.out.println("Booking successful for " + roomType);
    }
}

// Main Class
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" BOOK MY STAY APP - UC9 ");
        System.out.println("=================================");

        RoomInventory inventory = new RoomInventory();

        try {
            // Valid booking
            inventory.bookRoom("Single Room");

            // Invalid room type
            inventory.bookRoom("Luxury Room");

            // No availability
            inventory.bookRoom("Single Room");

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nApplication executed safely!");
    }
}