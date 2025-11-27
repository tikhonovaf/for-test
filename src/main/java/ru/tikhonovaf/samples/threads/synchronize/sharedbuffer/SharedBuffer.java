package ru.tikhonovaf.samples.threads.synchronize.sharedbuffer;


import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    // Метод для добавления элемента (Producer)
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            // Если очередь полна — ждём
            wait();
        }
        queue.add(value);
        System.out.println("Произведено: " + value);
        // Уведомляем потребителя
        notifyAll();
    }

    // Метод для извлечения элемента (Consumer)
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            // Если очередь пуста — ждём
            wait();
        }
        int value = queue.poll();
        System.out.println("Потреблено: " + value);
        // Уведомляем производителя
        notifyAll();
        return value;
    }
}

