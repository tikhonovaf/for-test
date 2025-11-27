package ru.tikhonovaf.samples.threads.creation.usingrunnable.usinglambda;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Поток через лямбду запущен!");
        });
        t.start();
    }
}
