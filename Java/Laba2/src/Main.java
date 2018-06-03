public class Main {
    public static void main(String[] args) {

        long [][] A = new long [][] {//матрица А
                {1, 2, 3, 14, 2},
                {11, 22, 13, 15, 6},
                {1, 2, 4, 8, 9},
                {34, 2, 43, 10, 6 },
                {1, 2, 7, 14, 0}
        };
        long [][] B = new long [][]{//матрица В
                {5, 4, 7, 15, 9},
                {34, 22, 13, 15, 6},
                {4, 12, 7, 6, 4},
                {36, 12, 7, 10, 10},
                {7, 6, 3, 4, 5}
        };
        long [][] C = new long [A.length][A.length];//результирующая матрица
        System.out.println("Матрица A :");

        if(A.length == B.length) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + "\t");
                }
            System.out.println();
        }
            System.out.println("Матрица B :");
                for (int i = 0; i < B.length; i++) {
                    for (int j = 0; j < B[i].length; j++) {
                        System.out.print(B[i][j] + "\t");
                    }
                    System.out.println();
                }

            System.out.println("Матрица C :");
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[i].length; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                    System.out.print(C[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Матрицы не совпадают по размерам");
        }

        long[] min = new long [5];// массив минимальных елементов
        //определение минимальных елементов
        for(int j = 0; j < C.length; j++) {
           min[j] = C[0][j];
           for(int i = 0; i < C[j].length; i++) {
                if(min[j] > C[i][j]) {
                    min[j] = C[i][j];
                }
            }
        }
        System.out.println("Минимальные елементы : ");
        long sum = 0;//сумма минимальных елементов каждого столбца
        for(int i = 0; i < C.length; i++) {
            System.out.print(min[i] + "\t");
            sum += min[i];
       }
        System.out.println("\nСумма минимальных елементов каждого столбца  = " + sum + "\t");
    }
}
