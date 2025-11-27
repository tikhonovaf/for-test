package ru.tikhonovaf.samples.threads.creation.usingcallable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "Результат из потока";
        };

        Future<String> future = executor.submit(task);

        // Пример с лямбда
        Future<String> futureLambda = executor.submit(() -> {
            Thread.sleep(1000);
            return "Результат из потока c lambda";
        });

        System.out.println("Ожидаем результат...");
        System.out.println("Получено: " + futureLambda.get());
        System.out.println("Получено: " + future.get());

        executor.shutdown();
    }
}
