package creational.building.model;

public class Burger {
	private String bun;
    private boolean cheese;
    private boolean lettuce;
    private boolean tomato;
    private boolean sauce;

    // Private constructor to enforce the use of the builder
    private Burger(BurgerBuilder builder) {
        this.bun = builder.bun;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.sauce = builder.sauce;
    }

    @Override
    public String toString() {
        return "Burger [bun=" + bun + ", cheese=" + cheese + ", lettuce=" + lettuce +
               ", tomato=" + tomato + ", sauce=" + sauce + "]";
    }

    // Static Inner Builder Class
    public static class BurgerBuilder {
        private String bun;
        private boolean cheese;
        private boolean lettuce;
        private boolean tomato;
        private boolean sauce;

        public BurgerBuilder(String bun) { 
            this.bun = bun;
        }

        public BurgerBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public BurgerBuilder addLettuce() {
            this.lettuce = true;
            return this;
        }

        public BurgerBuilder addTomato() {
            this.tomato = true;
            return this;
        }

        public BurgerBuilder addSauce() {
            this.sauce = true;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }

}
