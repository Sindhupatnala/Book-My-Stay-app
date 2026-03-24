// UC7: Add-On Service Selection
// Version: 7.0

import java.util.*;

// Service Class
class AddOnService {
    String name;
    int price;

    public AddOnService(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

// Service Manager
class AddOnServiceManager {

    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added Service: " + service.name + " to " + reservationId);
    }

    // Display services
    public void displayServices(String reservationId) {

        System.out.println("\nServices for " + reservationId + ":");

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        int total = 0;

        for (AddOnService s : services) {
            System.out.println(s.name + " - " + s.price);
            total += s.price;
        }

        System.out.println("Total Add-On Cost: " + total);
    }
}

// Main Class
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" BOOK MY STAY APP - UC7 ");
        System.out.println("=================================");

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "RES_101";

        // Add services
        manager.addService(reservationId, new AddOnService("Breakfast", 200));
        manager.addService(reservationId, new AddOnService("Airport Pickup", 500));
        manager.addService(reservationId, new AddOnService("Extra Bed", 300));

        // Display services
        manager.displayServices(reservationId);

        System.out.println("\nApplication executed successfully!");
    }
}