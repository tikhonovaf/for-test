package ru.tikhonovaf.samples.threads.creation.extendThread;

public class Main {
    public static void main(String[] args) {
        ExtendThread t = new ExtendThread();
        t.start(); // запускаем поток
    }
}
