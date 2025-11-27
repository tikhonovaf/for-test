package ru.tikhonovaf.samples.threads.creation.usingrunnable.usingclass;

public class MyRunnable  implements Runnable {
        @Override
        public void run() {
            System.out.println("Поток через Runnable запущен!");
        }
    }
