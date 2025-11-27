package ru.tikhonovaf.samples.patterns.creational.singleton;

public class Main {

    public static void main(String[] args) {
        SingletonTest s1 = SingletonTest.getInstance();
        SingletonTest s2 = SingletonTest.getInstance();

        s1.showMessage();

        System.out.println(s1 == s2); // true, оба объекта одинаковые
    }
}

