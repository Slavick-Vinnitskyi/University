import java.util.concurrent.locks.ReentrantLock;

public class Task3 implements Runnable {
    private ReentrantLock lock;

    Task3(ReentrantLock lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println("Starting Task 3...");
        int[][] matrixP = Data.generateMatrix();
        int[][] matrixR = Data.generateMatrix();
        int[] vectorT = Data.generateVector();
        int[] vectorO = Data.multipleMatrixVector(Data.matrixTransposition(Data.multipleMatrix(matrixP, matrixR)), vectorT);


        Data.outputVector(lock, vectorO, "O");
        System.out.println("Task 3 finished.");

    }
}
