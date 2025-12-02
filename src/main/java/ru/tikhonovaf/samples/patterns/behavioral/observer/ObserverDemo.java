package ru.tikhonovaf.samples.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// ---------- Observer ----------
interface Observer {
    void update(String eventData);
}

// ---------- Subject ----------
class EventPublisher {
    private final List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void publishEvent(String eventData) {
        System.out.println("Publisher: event occurred → " + eventData);
        for (Observer o : observers) {
            o.update(eventData);
        }
    }
}

// ---------- Observers ----------
class EmailNotification implements Observer {
    @Override
    public void update(String eventData) {
        System.out.println("EmailNotification: sending email → " + eventData);
    }
}

class LogListener implements Observer {
    @Override
    public void update(String eventData) {
        System.out.println("LogListener: writing log → " + eventData);
    }
}

class SmsNotification implements Observer {
    @Override
    public void update(String eventData) {
        System.out.println("SmsNotification: sending SMS → " + eventData);
    }
}

// ---------- Main ----------
public class ObserverDemo {
    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();

        Observer email = new EmailNotification();
        Observer log = new LogListener();
        Observer sms = new SmsNotification();

        // Подписчики подключаются динамически
        publisher.subscribe(email);
        publisher.subscribe(log);
        publisher.subscribe(sms);

        System.out.println("---- Event 1 ----");
        publisher.publishEvent("User registered");

        System.out.println("\n---- Event 2 (SMS removed) ----");
        publisher.unsubscribe(sms);
        publisher.publishEvent("Payment received");
    }
}


