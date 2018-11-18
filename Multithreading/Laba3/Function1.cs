using System;
using System.Collections.Generic;
using System.Text;

namespace LabPP3
{
    class Function1
    {
        private int sizeOfArrays;

        public void StartOfFunction(object arg)
        {
            this.sizeOfArrays = (int)arg;
            Methods methods = new Methods(sizeOfArrays);
     
            Console.WriteLine("Strat Function1");
            int [,] MA = methods.FillingOfMatrix();
            int [,] MD = methods.FillingOfMatrix();
            int [] B = methods.FillingOfVector();
           
            

            int [,] ME = methods.MultMatrixConst(methods.MaxVector(B), methods.MultMatrix(MA,MD));
            
            
            methods.PutMatrix(ME,"E");
            Console.WriteLine("End Function 1");
    
        }
    }
}