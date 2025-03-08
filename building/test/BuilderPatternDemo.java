package creational.building.test;

import java.util.Scanner;

import creational.building.model.Computer;

public class BuilderPatternDemo {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter CPU model:");
        String CPU = scanner.nextLine().trim();

        System.out.println("Enter RAM size (GB):");
        int RAM = scanner.nextInt();

        System.out.println("Enter storage size (GB):");
        int storage = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter GPU model:");
        String GPU = scanner.nextLine().trim();

        System.out.println("Enter Operating System:");
        String OS = scanner.nextLine().trim();

        // Building the computer with user input
        Computer userPC = new Computer.ComputerBuilder()
                .setCPU(CPU)
                .setRAM(RAM)
                .setStorage(storage)
                .setGPU(GPU)
                .setOS(OS)
                .build();

        // Display specifications
        System.out.println("\nYour customized computer configuration:");
        userPC.showSpecifications();

        scanner.close();
    }

}
