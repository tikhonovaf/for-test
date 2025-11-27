package ru.tikhonovaf.samples.patterns.structural.decorator;

interface Notifier {
    void send();
}

class SimpleNotifier implements Notifier {
    public void send() { System.out.println("Sending base notification"); }
}

class EmailDecorator implements Notifier {
    private final Notifier wrappee;

    public EmailDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    public void send() {
        wrappee.send();
        System.out.println("Sending Email");
    }
}

class SMSDecorator implements Notifier {
    private final Notifier wrappee;

    public SMSDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    public void send() {
        wrappee.send();
        System.out.println("Sending SMS");
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Notifier notifier =
                new SMSDecorator(
                        new EmailDecorator(
                                new SimpleNotifier()));

        notifier.send();
    }
}
