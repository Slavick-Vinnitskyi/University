import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread task1 = new Thread(new Task1(lock));
        Thread task2 = new Thread(new Task2(lock));
        Thread task3 = new Thread(new Task3(lock));

        long start = System.nanoTime();
        System.out.printf("Dimension = %d\n", Data.getN());
        task1.start();
        task2.start();
        task3.start();
        try {
            task1.join();
            task2.join();
            task3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        double time = (double) (end - start) / 1000000000;
        System.out.printf("\n\ntime = %.4f seconds\n", time);
    }
}
