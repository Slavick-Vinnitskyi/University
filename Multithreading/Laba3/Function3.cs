using System;
using System.Collections.Generic;
using System.Text;

namespace LabPP3
{
    class Function3
    {
        private int sizeOfArrays;
    

        public void StartOfFunction(object arg)
        {
            this.sizeOfArrays = (int)arg;
            Methods methods = new Methods(sizeOfArrays);

            Console.WriteLine("Start Function3");
            int [] E = methods.FillingOfVector();
            int [] F = methods.FillingOfVector();
            int [] N = methods.FillingOfVector();

            int [,] MB = methods.FillingOfMatrix();
            int [,] MC = methods.FillingOfMatrix();
            
            int [] D = methods.multipleMatrixVector(methods.MultMatrix(MB,MC), methods.MultVectors(N,methods.SumOfVector(E,F)));

            methods.PutVector(D, "D");

            Console.WriteLine("End Function 3");
      
        }
    }
}