package creational.building.test;

import java.util.Scanner;

import creational.building.model.Burger;

public class BurgerMain {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a bun type:");
        String bun = scanner.nextLine().trim();

        Burger.BurgerBuilder burgerBuilder = new Burger.BurgerBuilder(bun);

        System.out.println("Do you want cheese? (yes/no):");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            burgerBuilder.addCheese();
        }

        System.out.println("Do you want lettuce? (yes/no):");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            burgerBuilder.addLettuce();
        }

        System.out.println("Do you want tomato? (yes/no):");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            burgerBuilder.addTomato();
        }

        System.out.println("Do you want sauce? (yes/no):");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            burgerBuilder.addSauce();
        }

        Burger myBurger = burgerBuilder.build();
        System.out.println("Your customized burger: " + myBurger);

        scanner.close();
    }
}
