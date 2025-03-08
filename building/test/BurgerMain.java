package creational.building.test;

import creational.building.model.Burger;

public class BurgerMain {
	public static void main(String[] args) {
        Burger myBurger = new Burger.BurgerBuilder("Sesame Bun")
                .addCheese()
                .addTomato()
                .addSauce()
                .build();

        System.out.println(myBurger);
    }

}
