import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Class with matrix and methods to calculate
 */
class Data {

    private static final int N = 500;

    static int getN() {
        return N;
    }

    static int[][] generateMatrix() {

        int[][] matrix = new int[N][N];
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = random.nextInt(2);
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    static int[] generateVector() {
        int[] vector = new int[N];
        Random random = new Random();
        for (int i = 0; i < vector.length; i++) {
//            vector[i] = random.nextInt(2);
            vector[i] = 1;
        }
        return vector;
    }

    static int[][] matrixTransposition(int[][] m) {
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    static int[][] matrixDiff(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[N][N];
        for (int i = 0; i < firstMatrix.length; i++)
            for (int j = 0; j < firstMatrix[0].length; j++)
                result[j][i] = firstMatrix[i][j] - secondMatrix[i][j];
        return result;
    }

    static int[][] multipleMatrix(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("A:Rows: " + firstMatrix[0].length + " did not match B:Columns " + secondMatrix.length + ".");
        }

        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];


        for (int i = 0; i < firstMatrix.length; i++) { // aRow
            for (int j = 0; j < secondMatrix[0].length; j++) { // bColumn
                for (int k = 0; k < firstMatrix[0].length; k++) { // aColumn
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return result;
    }

    static int[] multipleMatrixVector(int[][] matrixToMultiple, int[] vectorToMultiple) {
        int[] result = new int[matrixToMultiple.length];
        for (int i = 0; i < result.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrixToMultiple[0].length; j++) {
                sum += matrixToMultiple[i][j] * vectorToMultiple[j];
            }
            result[i] = sum;
        }
        return result;
    }

    static int[] sumVectors(int[] firstVector, int[] secondVector) {
        if (firstVector.length != secondVector.length) {
            throw new IllegalArgumentException("Vectors has different lengths!");
        }
        int[] result = new int[firstVector.length];
        for (int i = 0; i < firstVector.length; i++) {
            result[i] = firstVector[i] + secondVector[i];
        }

        return result;
    }


    static void outputMatrix(ReentrantLock lock, int[][] matrixToOutput, String matrixName) {
        lock.lock();
        try {
            System.out.println("Here is result matrix " + matrixName + " : ");
            for (int[] rowMatrix : matrixToOutput) {
                for (int matrixElement : rowMatrix) {
                    System.out.print(matrixElement + " ");
                }
                System.out.println();
            }
        } finally {
            lock.unlock();
        }
    }

   static void outputVector(ReentrantLock lock, int[] vectorToOutput, String vectorName) {
       lock.lock();
       try {
           System.out.println("Here is result vector " + vectorName + " : ");
           for (int vectorElement : vectorToOutput) {
               System.out.print(vectorElement + " ");
           }
           System.out.println();
       }finally {
           lock.unlock();
       }
   }
}