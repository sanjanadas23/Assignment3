package Strategy.poc.model;

public class PaymentContext {
private PaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void executePayment(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Payment method not selected.");
            return;
        }
        paymentStrategy.pay(amount);
    }

}
