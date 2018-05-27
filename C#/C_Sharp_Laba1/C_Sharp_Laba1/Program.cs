using System;
using System.Collections.Generic;
using System.Linq;

namespace C_Sharp_Laba1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Имеется n городов, которые нужно объединить в единую телефонную сеть (для каждой пары городов известно расстояние между ними). ");
            Console.WriteLine("Для этого достаточно проложить (n-1) телефонных линий между городами. ");
            Console.WriteLine("Как соединить города так, чтобы суммарная стоимость соединений (телефонного кабеля) была минимальна ?");

            //Вводим кол-во вершин
            Console.WriteLine("Введите количество городов (вершин) : ");
            int vertex = Convert.ToInt16(Console.ReadLine());

            //Вводим тип подсчета
            Console.WriteLine("Введите 1 для подсчета с помощью матрицы смежности, 2 - с помощью списка : ");
            int method = Convert.ToInt16(Console.ReadLine());
            
            if(method == 1)
            {
                Console.WriteLine("Введите 1 для ручного ввода матрицы , 2 - для генерации : ");
                int IoC = Convert.ToInt16(Console.ReadLine());// Input or Create

                Matrix MyMatr = new Matrix();
                Algorithm Solve = new Algorithm();
                if(IoC == 1)
                {
                    int[,] matrix1 = MyMatr.InputMatrix(vertex);
                    MyMatr.OutputMatrix(vertex, matrix1);
                    Solve.ByMatrix(vertex, matrix1);
                }
                if (IoC == 2)
                {
                    int[,] matrix1 = MyMatr.BuildMatrix(vertex);
                    MyMatr.OutputMatrix(vertex, matrix1);
                    Solve.ByMatrix(vertex, matrix1);
                }

            }
            else if (method == 2)
            {
                Console.WriteLine("Введите 1 для ручного ввода списка, 2 - для генерации : ");
                int IoC = Convert.ToInt16(Console.ReadLine());// input or create

                Adjacency_list MyList = new Adjacency_list();

                if (IoC == 1)
                {
                    List<int>[] s = MyList.InputAdj(vertex);
                    MyList.Output_Adj(s, vertex);
                }
                else if (IoC == 2)
                {
                    Matrix MatrForList = new Matrix();
                    int[,] MatrixForList = MatrForList.BuildMatrix(vertex);
                    List<int>[] s = MyList.Agj(MatrixForList, vertex);
                    MyList.Output_Adj(s, vertex);
                }

            }
            else
            {
                Console.WriteLine("Вы ввели неправильно!");
            }

            Console.Read(); // чтобы консоль не закрывалась
        }        
                
    }

    class Matrix // реализация матрицы смежности
    {
        Random ran = new Random();
        public int[,] BuildMatrix(int N)
        {
            int[,] matrix = new int[N, N];
            for (int i = 0; i < N; i++)
            {                
                for (int j = i + 1; j < N; j++)
                {
                    matrix[i, j] = ran.Next(1, 12);
                    matrix[j, i] = matrix[i, j]; // обратный порядок индексов
                }
            }
            return matrix;
        }

        public int[,] InputMatrix(int N)
        {
            int[,] matrix = new int[N, N];
            for (int i = 0; i < N; i++)
            {               
                for (int j = i + 1; j < N; j++)
                {   
                    Console.WriteLine("Введите елемент [" + i + "," + j +"] : ");
                    matrix[i,j] = Convert.ToInt16(Console.ReadLine());                    
                    matrix[j, i] = matrix[i, j];
                }
            }
            return matrix;
        }

        public void OutputMatrix(int N, int[,] matrix1)
        {
            Console.WriteLine("Матрица сбежности : ");
            
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    System.Console.Write("{0,-4}", matrix1[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }

    class Adjacency_list // реализация списка смежности 
    {
        // генерация списка (из матрицы) - связь записывается если в между точками есть значение расстояния (ненулевое)
        public List <int>[] Agj(int[,] agj_matrix ,int N)
        {
            List<int> [] adj_array = new List<int>[N];           

            for (int i = 0;  i < N; i++)
            {
                adj_array[i] = new List<int>();

                for (int j = 0; j < N; j++)
                {
                    if (agj_matrix[i, j] != 0)
                    {
                        adj_array[i].Add(j); // добавляем в список вершины с которыми текущая вершина инцидентна
                    }
                }                
            }
            return adj_array;
        }

        public List<int>[] InputAdj(int N)
        {
            Console.WriteLine("Введите значения для  списка сбежности : ");

            List<int>[] adj_array = new List<int>[N];

            for (int i = 0; i < adj_array.Length; i++)
            {
                adj_array[i] = new List<int>();
            }
            for (int i = 0; i < adj_array.Length; i++)
            {
                Console.WriteLine("Введите вершины с которыми вершина № " + i + " будет инцидентна : ");

                string line = Console.ReadLine();

                string[] vertexes = line.Split(' ', ',', ':', '-', ';');

                foreach (string value in vertexes)
                {                   
                    adj_array[i].Add(Convert.ToInt16(value));
                }
            }
            return adj_array;
        }

        public void Output_Adj(List<int>[] arr_list, int N)
        {            
            Console.Write("Список смежности : ");
            int key = 0;
            foreach (List<int> list in arr_list)
            {
                Console.Write("Для вершины №" + key + " : ");
                foreach (int value in list)
                    Console.Write(value + " ");                
                key++;
            }
            Console.WriteLine();
        }
    }

  
    class Algorithm
    {
        public void ByMatrix(int N, int[,] agj_matrix)
        {
            Random ran = new Random();
            int next_vert = ran.Next(0, N);//случайным образом стартуем с любой вершины      

            var vertex_lengths = new List<(int lenght, int vertex)>[N];
            
            for (int i = 0; i < N; i++)
            {
                vertex_lengths[i] = new List<(int, int)>();
                for (int j = 0; j < N; j++)
                {
                    if (agj_matrix[i, j] != 0)
                    {
                        vertex_lengths[i].Add((agj_matrix[i, j], j));
                    }
                }
            }
         
            List<int> way = new List<int> (N);
            way.Add(next_vert);
            int minimalTreeLength = 0;


            while (way.Count < N)// Достаточно проложить N-1 телефонных линий между городами
            {
                next_vert = FindShortestVertex(way, vertex_lengths,minimalTreeLength);
                way.Add(next_vert);                
            }
            
            foreach(int value in way)
            {
                
                if(value == way[way.Capacity-1]) //если печатаем последний элемент
                    Console.WriteLine(value + 1);
                else
                    Console.Write(value + 1 + " -> ");
            }
        }

        public int FindShortestVertex(List<int> way, List<(int lenght, int vertex)>[] adjecency_list, int len)
        {
            int min = int.MaxValue;
            int nextVertex = 0;

            foreach(var v in way)
            {
                var (lenght, vertex) = adjecency_list[v].OrderBy(x => x.lenght).First(x => (x.lenght > 0) && way.All(y => y != x.vertex ));
                nextVertex = vertex;
                min = lenght;
                
            }
            return nextVertex;             
        }
    }
}