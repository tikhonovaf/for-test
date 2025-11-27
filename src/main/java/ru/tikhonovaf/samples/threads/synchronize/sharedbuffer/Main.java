package ru.tikhonovaf.samples.threads.synchronize.sharedbuffer;

public class Main {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Поток-производитель
        Thread producer = new Thread(() -> {
            int i = 0;
            try {
                while (true) {
                    buffer.produce(i++);
                    Thread.sleep(500); // имитация работы
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Поток-потребитель
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(1000); // имитация обработки
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }

}
