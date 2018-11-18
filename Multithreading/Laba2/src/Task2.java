
import java.util.concurrent.locks.ReentrantLock;

public class Task2 implements Runnable {
    private ReentrantLock lock;

    Task2(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Starting Task 2..");

        int[][] matrixK = Data.generateMatrix();
        int[][] matrixL = Data.generateMatrix();
        int[][] matrixG = Data.generateMatrix();

        int[][] matrixF = Data.matrixDiff(Data.multipleMatrix(matrixG, Data.multipleMatrix(matrixK, matrixL)), matrixK);

        Data.outputMatrix(lock, matrixF, "F");
        System.out.println("Task 2 finished.");
    }
}
