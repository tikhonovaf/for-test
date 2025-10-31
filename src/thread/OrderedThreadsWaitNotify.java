package thread;
public class OrderedThreadsWaitNotify {
    private static final Object lock = new Object();
    private static int turn = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> runTask(1, "T1"));
        Thread t2 = new Thread(() -> runTask(2, "T2"));
        Thread t3 = new Thread(() -> runTask(3, "T3"));

        t1.start();
        t2.start();
        t3.start();
    }

    private static void runTask(int threadNumber, String name) {
        synchronized (lock) {
            while (turn != threadNumber) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println(name);
            turn++;
            lock.notifyAll(); // разбудить остальных
        }
    }
}
