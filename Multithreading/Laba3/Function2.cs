using System;
using System.Collections.Generic;
using System.Text;

namespace LabPP3
{
    class Function2
    {
        private int sizeOfArrays;

     
        public void StartOfFunction(object arg)
        {
            this.sizeOfArrays = (int)arg;
            Methods methods = new Methods(sizeOfArrays);

         
            Console.WriteLine("Start Function2");
            int [,] MF = methods.FillingOfMatrix();
            int [,] MQ = methods.FillingOfMatrix();
           int [] B = methods.FillingOfVector();
           int [] C = methods.FillingOfVector();
           int [] D = methods.FillingOfVector();

            int[] A = methods.SumOfVector(B,methods.SumOfVector(methods.multipleMatrixVector(methods.MultMatrix(MF,MQ),D),C));

           methods.PutVector(A, "A");
            Console.WriteLine("End Function 2");
            
        }
    }
}