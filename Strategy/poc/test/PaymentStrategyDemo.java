package Strategy.poc.test;

import java.util.Scanner;

import Strategy.poc.model.CashPayment;
import Strategy.poc.model.CreditCardPayment;
import Strategy.poc.model.PayPalPayment;
import Strategy.poc.model.PaymentContext;
import Strategy.poc.model.PaymentStrategy;

public class PaymentStrategyDemo {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        while (true) {
            System.out.println("Choose a payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Cash");
            System.out.println("4. Exit");
            
            String choice = scanner.nextLine().trim();
            PaymentStrategy strategy = null;

            switch (choice) {
                case "1":
                case "Credit Card":
                    System.out.println("Enter Credit Card Number:");
                    String cardNumber = scanner.nextLine().trim();
                    if (cardNumber.isEmpty() || !cardNumber.matches("\\d+") || Long.parseLong(cardNumber) < 0) {
                        System.out.println("Error: Invalid credit card number.");
                        continue;
                    }
                    strategy = new CreditCardPayment(cardNumber);
                    break;
                case "2":
                case "PayPal":
                    System.out.println("Enter PayPal Email:");
                    String email = scanner.nextLine().trim();
                    if (email.isEmpty()) {
                        System.out.println("Error: Email cannot be empty.");
                        continue;
                    }
                    strategy = new PayPalPayment(email);
                    break;
                case "3":
                case "Cash":
                    strategy = new CashPayment();
                    break;
                case "4":
                case "Exit":
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Error: Invalid choice. Please select a valid option.");
                    continue;
            }

            System.out.println("Enter amount to pay:");
            int amount;
            try {
                amount = Integer.parseInt(scanner.nextLine().trim());
                if (amount <= 0) {
                    System.out.println("Error: Amount must be greater than zero.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount entered.");
                continue;
            }
            
            paymentContext.setPaymentStrategy(strategy);
            paymentContext.executePayment(amount);
            
            System.out.println("Do you want to make another payment? (yes/no):");
            if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                System.out.println("Exiting program...");
                break;
            }
        }

        
    }

}
