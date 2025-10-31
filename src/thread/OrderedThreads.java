package thread;

import java.util.Iterator;

public class OrderedThreads {
    private static int turn = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> runTask(1, "T1"));
        Thread t2 = new Thread(() -> runTask(2, "T2"));
        Thread t3 = new Thread(() -> runTask(3, "T3"));

        t1.start();
        t1.join(); // ждём окончания T1

        t2.start();
        t2.join(); // ждём окончания T2

        t3.start();
        t3.join(); // ждём окончания T3

        runTask(1, "T1");
        runTask(2, "T2");
        runTask(3, "T3");

        Iterator iterator = Thread.getAllStackTraces().keySet().iterator();
    }



    private static void runTask(int threadNumber, String name) {
            System.out.println(name);
    }
}
