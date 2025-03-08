package creational.building.model;

public class Computer {
	private final String CPU;
    private final int RAM;
    private final int storage;
    private final String GPU;
    private final String OS;

    // Private Constructor
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
    }

    // Display method
    public void showSpecifications() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM + "GB");
        System.out.println("Storage: " + storage + "GB");
        System.out.println("GPU: " + GPU);
        System.out.println("OS: " + OS);
    }

    // Nested Builder Class
    public static class ComputerBuilder {
        private String CPU;
        private int RAM;
        private int storage;
        private String GPU;
        private String OS;

        // Setter methods with return type as builder (Fluent API)
        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public ComputerBuilder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public ComputerBuilder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        // Build method to create Computer object
        public Computer build() {
            return new Computer(this);
        }
    }

}
