package ru.tikhonovaf.samples.patterns.creational.singleton;

public class SingletonTest {
    private static SingletonTest instance;

    private SingletonTest() {}

    public static synchronized SingletonTest getInstance() {
        if (instance == null) {
            instance = new SingletonTest();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

}
