package ru.tikhonovaf.samples.patterns.behavioral.strategy;

interface PaymentStrategy {
    void pay(int amount);
}

// ------ Strategies ------
class CardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class CryptoPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Crypto");
    }
}

// ------ Context ------
class PaymentService {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy is not set");
        }
        strategy.pay(amount);
    }
}

// ------ Main ------
public class StrategyDemo {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.setStrategy(new CardPayment());
        service.checkout(100);

        service.setStrategy(new PaypalPayment());
        service.checkout(200);

        service.setStrategy(new CryptoPayment());
        service.checkout(300);
    }
}
