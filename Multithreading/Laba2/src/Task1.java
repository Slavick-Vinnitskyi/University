import java.util.concurrent.locks.ReentrantLock;

public class Task1 extends Thread {
    private ReentrantLock lock;

    Task1(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Starting Task 1...");
        int[][] matrixO = Data.generateMatrix();
        int[][] matrixE = Data.generateMatrix();
        int[] vectorA = Data.generateVector();
        int[] vectorB = Data.generateVector();
        int[] finalRes = Data.sumVectors(vectorA, Data.multipleMatrixVector(Data.multipleMatrix(matrixE, matrixO), vectorB));

        Data.outputVector(lock, finalRes, "C");
        System.out.println("Task 1 finished.");

    }
}
