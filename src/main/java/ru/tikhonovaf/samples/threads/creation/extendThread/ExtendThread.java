package ru.tikhonovaf.samples.threads.creation.extendThread;

public class ExtendThread extends Thread {
        @Override
        public void run() {
            System.out.println("Поток через наследование запущен!");
        }
    }
