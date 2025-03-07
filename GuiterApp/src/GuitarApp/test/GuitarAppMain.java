package GuitarApp.test;

import java.util.List;
import java.util.Scanner;

import GuitarApp.model.Builder;
import GuitarApp.model.Guitar;
import GuitarApp.model.Inventory;
import GuitarApp.model.Type;
import GuitarApp.model.Wood;

public class GuitarAppMain {
	private Inventory inventory;
    private Scanner scanner;

    public GuitarAppMain() {
        this.inventory = new Inventory();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the Guitar Inventory System ");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("[1] Add a New Guitar");
            System.out.println("[2] Search for a Guitar");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");

            int choice = getValidInteger(1, 3);

            switch (choice) {
                case 1:
                    addGuitar();
                    break;
                case 2:
                    searchGuitar();
                    break;
                case 3:
                    System.out.println("Exiting... ");
                    scanner.close();
                    return;
            }
        }
    }

    public static void main(String[] args) {
        GuitarAppMain app = new GuitarAppMain();
        app.run();
    }

    private void addGuitar() {
        System.out.println("\nAdding a New Guitar...");

        String serialNumber;
        while (true) {
            System.out.print("Enter Serial Number (Unique & Non-Negative): ");
            serialNumber = scanner.nextLine().trim();
            if (serialNumber.isEmpty() || !serialNumber.matches("\\d+")) {
                System.out.println("Invalid serial number! Must be a positive integer.");
                continue;
            }
            if (inventory.getGuitar(serialNumber) != null) {
                System.out.println("Serial number already exists! Try again.");
                continue;
            }
            break;
        }

        double price;
        while (true) {
            System.out.print("Enter Price (Greater than 0): ");
            try {
                price = Double.parseDouble(scanner.nextLine().trim());
                if (price > 0) break;
                else System.out.println("Price must be greater than zero!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid price! Enter a numeric value.");
            }
        }

        Builder builder = getValidBuilder();
        System.out.print("Enter Model Name: ");
        String model = scanner.nextLine().trim();
        Type type = getValidType();
        Wood backWood = getValidWood("Back Wood");
        Wood topWood = getValidWood("Top Wood");

        inventory.addGuitar(serialNumber, price, builder, model, type, backWood, topWood);
        System.out.println("Guitar added successfully!");
    }

    private void searchGuitar() {
        System.out.println("\nSearching for a Guitar...");

        Builder builder = getValidBuilder();
        System.out.print("Enter Model Name (or press Enter to skip): ");
        String model = scanner.nextLine().trim();
        Type type = getValidType();
        Wood backWood = getValidWood("Back Wood");
        Wood topWood = getValidWood("Top Wood");

        Guitar searchGuitar = new Guitar("", 0, builder, model, type, backWood, topWood);
        List<Guitar> results = inventory.search(searchGuitar);

        if (!results.isEmpty()) {
            System.out.println("\nMatching Guitars Found:");
            for (Guitar guitar : results) {
                System.out.println(" " + guitar.getBuilder() + " " + guitar.getModel() + " ($" + guitar.getPrice() + ")");
            }
        } else {
            System.out.println("\nNo matching guitars found.");
        }
    }

    private Builder getValidBuilder() {
        while (true) {
            System.out.println("\nSelect Builder: [1] Fender, [2] Gibson, [3] Martin, [4] Yamaha, [5] Ibanez, [6] Any");
            int choice = getValidInteger(1, 6);
            return Builder.values()[choice - 1];
        }
    }

    private Type getValidType() {
        while (true) {
            System.out.println("\nSelect Type: [1] Acoustic, [2] Electric, [3] Classical, [4] Any");
            int choice = getValidInteger(1, 4);
            return Type.values()[choice - 1];
        }
    }

    private Wood getValidWood(String woodType) {
        while (true) {
            System.out.println("\nSelect " + woodType + ": [1] Mahogany, [2] Maple, [3] Alder, [4] Spruce, [5] Rosewood, [6] Any");
            int choice = getValidInteger(1, 6);
            return Wood.values()[choice - 1];
        }
    }

    private int getValidInteger(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) return value;
                else System.out.println("Invalid choice! Enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

}
