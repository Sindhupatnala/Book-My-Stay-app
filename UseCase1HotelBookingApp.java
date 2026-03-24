
 UC1-ApplicationStart
        System.out.println("Application started successfully!");
        System.out.println("UC1 branch update");

        // Polymorphism
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;
        main

        System.out.println("\n--- Room Details ---\n");

        single.displayDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable + "\n");

        System.out.println("Application executed successfully!");
    }
}