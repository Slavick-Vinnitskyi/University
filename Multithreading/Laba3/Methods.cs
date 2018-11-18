using System;
using System.Collections.Generic;
using System.Text;

namespace LabPP3
{
    class Methods
    {
        static object block = new object();
        private int sizeOfArrays;

        public Methods(int sizeOfArrays)
        {
            this.sizeOfArrays = sizeOfArrays;
        }

        public int[] FillingOfVector()
        {
            int[] vector = new int[sizeOfArrays];

            for (int i = 0; i < sizeOfArrays; i++)
            {
                vector[i] = 1;
            }

            return vector;
        }

        public int[,] FillingOfMatrix()
        {
            int[,] matrix = new int[sizeOfArrays, sizeOfArrays];

            for (int i = 0; i < sizeOfArrays; i++)
            {
                for (int j = 0; j < sizeOfArrays; j++)
                {
                    matrix[i, j] = 1;
                }
            }

            return matrix;
        }

        public void PutVector(int[] vector, String vectorName)
        {
            lock (block)
            {
                Console.WriteLine("Here is vector " + vectorName + " : ");
                for (int i = 0; i < sizeOfArrays; i++)
                {
                    Console.Write(vector[i] + " ");
                }

                Console.WriteLine();
            }
        }

        public void PutMatrix(int[,] matrix, String matrixName)
        {
            lock (block)
            {
                Console.WriteLine("Here is matrix " + matrixName + " : ");
                for (int i = 0; i < sizeOfArrays; i++)
                {
                    for (int j = 0; j < sizeOfArrays; j++)
                    {
                        Console.Write(matrix[i, j] + " ");
                    }
                    Console.WriteLine();
                }
            }
        }

        public int[] SumOfVector(int[] vector1, int[] vector2)
        {
            int[] resVector = new int[sizeOfArrays];

            for (int i = 0; i < sizeOfArrays; i++)
            {
                resVector[i] = vector1[i] + vector2[i];
            }

            return resVector;
        }
        
    }

        public int[] MultVectors(int[] vector1, int[] vector2){

            int value = 0;
            int[] resultVector = new int [vector1.Length];
            for(int i=0;i<vector1.Length;i++){
                for(int j=0;j<vector2.Length;i++){
                    value += vector1[i]*vector2[j];
                    resultVector[i] = value;
                }
                value = 0;
            }
            return resultVector;
        }

        public int[,] MultMatrixConst(int num, int[,] MyMatrix){


             for(int i=0;i<MyMatrix.Length;i++){
                for(int j=0;j<MyMatrix.Length;i++){
                    MyMatrix[i][j] = MyMatrix[i][j] * num;
                }
             }
             return MyMatrix;
        }

        public int MaxVector(int[] myVector){
            if(myVector.Length != 0){

                int maxElem = myVector[0];

                for(int i=1;i<myVector.Length;i++){

                    if(myVector[i] > maxElem){
                        maxElem = myVector[i];
                    }
                }
                return maxElem;
            }
            else{ return 0;}
        }


        public int[,] MultMatrix(int[,] matrix1, int[,] matrix2)
        {
            int[,] resultMatrix = new int[sizeOfArrays, sizeOfArrays];

            for (int i = 0; i < sizeOfArrays; i++)
            {
                for (int j = 0; j < sizeOfArrays; j++)
                {
                    for (int k = 0; k < sizeOfArrays; k++)
                    {
                        resultMatrix[i, j] += matrix1[i, k] * matrix2[k, j];
                    }
                }
            }

            return resultMatrix;
        }

    public int[] multipleMatrixVector(int[,] matrixToMultiple, int[] vectorToMultiple) {
        int[] result = new int[sizeOfArrays];
        for (int i = 0; i < sizeOfArrays; i++) {
            int sum = 0;
            for (int j = 0; j < sizeOfArrays; j++) {
                sum += matrixToMultiple[i, j] * vectorToMultiple[j];
            }
            result[i] = sum;
        }
        return result;
    }
    
}