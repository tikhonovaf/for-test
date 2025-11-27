package ru.tikhonovaf.samples.threads.creation.usingrunnable.usingclass;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
