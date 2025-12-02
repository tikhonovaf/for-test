package ru.tikhonovaf.samples.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

// --------- Iterator ----------
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// --------- Aggregate ----------
interface BookCollection {
    Iterator<Book> createIterator();
}

// --------- Concrete Aggregate ----------
class Library implements BookCollection {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }
}

// --------- Concrete Iterator ----------
class BookIterator implements Iterator<Book> {
    private final List<Book> books;
    private int index = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Book next() {
        return books.get(index++);
    }
}

// --------- Item ----------
class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// --------- Main ----------
public class IteratorDemo {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984"));
        library.addBook(new Book("Brave New World"));
        library.addBook(new Book("Fahrenheit 451"));

        Iterator<Book> iterator = library.createIterator();

        System.out.println("Books in library:");
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("- " + book.getTitle());
        }
    }
}
