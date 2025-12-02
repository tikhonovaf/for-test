package ru.tikhonovaf.samples.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

// --------- Visitor ----------
interface ItemVisitor {
    void visit(Book book);
    void visit(Magazine magazine);
}

// --------- Element ----------
interface Item {
    void accept(ItemVisitor visitor);
}

// --------- Concrete Elements ----------
class Book implements Item {
    private final String title;
    private final double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getTitle() { return title; }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

class Magazine implements Item {
    private final String name;
    private final double price;

    public Magazine(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

// --------- Concrete Visitor ----------
class PriceCalculator implements ItemVisitor {
    private double total = 0;

    @Override
    public void visit(Book book) {
        total += book.getPrice();
        System.out.println("Adding book " + book.getTitle() + " price: " + book.getPrice());
    }

    @Override
    public void visit(Magazine magazine) {
        total += magazine.getPrice();
        System.out.println("Adding magazine " + magazine.getName() + " price: " + magazine.getPrice());
    }

    public double getTotal() { return total; }
}

// --------- Main ----------
public class VisitorDemo {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Book("1984", 10));
        items.add(new Magazine("Time", 5));
        items.add(new Book("Brave New World", 12));
        items.add(new Magazine("Forbes", 8));

        PriceCalculator calculator = new PriceCalculator();

        for (Item item : items) {
            item.accept(calculator);
        }

        System.out.println("Total price: " + calculator.getTotal());
    }
}
