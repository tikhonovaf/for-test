package ru.tikhonovaf.samples.threads.creation.usingexecutorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> System.out.println("Задача 1 запущена"));
        executor.execute(() -> System.out.println("Задача 2 запущена"));


        executor.submit(() -> System.out.println("Задача 1 выполнена"));
        executor.submit(() -> System.out.println("Задача 2 выполнена"));

        executor.shutdown(); // корректное завершение
    }
}
