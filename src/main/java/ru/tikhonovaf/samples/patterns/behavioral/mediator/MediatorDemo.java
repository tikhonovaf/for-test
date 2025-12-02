package ru.tikhonovaf.samples.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

// --------- Mediator ----------
interface ChatMediator {
    void sendMessage(String message, User sender);
    void addUser(User user);
}

// --------- Concrete Mediator ----------
class ChatRoom implements ChatMediator {
    private final List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

// --------- Colleague ----------
abstract class User {
    protected String name;
    protected ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// --------- Concrete Colleague ----------
class ChatUser extends User {

    public ChatUser(String name, ChatMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}

// --------- Main ----------
public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User alice = new ChatUser("Alice", chatRoom);
        User bob = new ChatUser("Bob", chatRoom);
        User charlie = new ChatUser("Charlie", chatRoom);

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        alice.send("Hello everyone!");
        bob.send("Hi Alice!");
        charlie.send("Hey folks!");
    }
}


