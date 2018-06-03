using System;

namespace C_Sharp_Laba2
{
    class Point
    {
        protected int Xpos;
        protected int Ypos;
        public Point(int x, int y)
        {
            Xpos = x;
            Ypos = y;
        }
        public virtual void Draw()
        {
            Console.WriteLine("Poin in: ({0},{1})", Xpos, Ypos);
        }
    }
    class ColorPoint : Point
    {
        string clr;
        public ColorPoint(int x, int y, string color)
            : base(x, y)
        {
            clr = color;
        }
        public override void Draw()
        {
            Console.WriteLine("Point in: ({0},{1}) color: {2}", Xpos, Ypos, clr);
        }
    }
    class Line : Point
    {
        protected int Xo;
        protected int Yo;
        public Line(int x, int y, int a, int u)
            : base(x, y)
        {
            Xo = a;
            Yo = u;
        }
        public override void Draw()
        {
            Console.WriteLine("Line in: Начальная точка : ({0},{1}); конечная точка :({2},{3}); длина : ({4}) ", Xpos, Ypos, Xo, Yo, Math.Sqrt(Math.Abs(Math.Pow(Xpos, 2) - Math.Pow(Xo, 2) + Math.Pow(Ypos, 2) - Math.Pow(Yo, 2))));
        } 
    }
    class ColoredLine : Line
    {
        string clr;

        public ColoredLine(int x, int y, int a, int u, string color)
            : base(x, y, a, u)
        {
            Xo = a;
            Yo = u;
            clr = color;
        }
        public override void Draw()
        {
            Console.WriteLine("Line in: Начальная точка : ({0},{1}); конечная точка : ({2},{3}); цвет: {4}; длина : ({5}) ", Xpos, Ypos, Xo, Yo, clr, Math.Sqrt(Math.Abs(Math.Pow(Xpos, 2) - Math.Pow(Xo, 2) + Math.Pow(Ypos, 2) - Math.Pow(Yo, 2))));
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Родительский класс point");
            Console.WriteLine("point введите координату X ");
            int k = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("point введите координату Y ");
            int l = Convert.ToInt16(Console.ReadLine());
            Point onepoint = new Point(k, l);
            onepoint.Draw();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Дочерний класс ColorPoint");
            Console.WriteLine("ColorPoint введите координату X ");
            k = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("ColorPoint введите координату Y ");
            l = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("ColorPoint введите цвет");
            string s = Console.ReadLine();
            Point pt = new ColorPoint(k, l, s);
            pt.Draw();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Класс Line, образован от класса Point   ");
            Console.WriteLine("Line введите координату X  ");
            k = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("Line введите координату Y ");
            l = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("Координаты конца линии   ");
            Console.WriteLine("Line введите координату X  ");
            int m = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("Line введите координату Y ");
            int z = Convert.ToInt16(Console.ReadLine());
            Point lin = new Line(k, l, m, z);
            lin.Draw();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Класс ColoredLine, образован от класса Line   ");
            Console.WriteLine("ColoredLine введите координату X  ");
            try
            {

                k = Convert.ToInt16(Console.ReadLine());
            }
            catch(MyInvalidCastException e)
            {
                Console.WriteLine(e.Message);
            }
            Console.WriteLine("ColoredLine введите координату Y ");
            try
            {

                l = Convert.ToInt16(Console.ReadLine());
            }
            catch (MyInvalidCastException e)
            {
                Console.WriteLine(e.Message);
            }
            Console.WriteLine("Координаты конца линии   ");
            Console.WriteLine("ColoredLine введите координату X  ");
            try
            {

                m = Convert.ToInt16(Console.ReadLine());
            }
            catch (MyInvalidCastException e)
            {
                Console.WriteLine(e.Message);
            }            
            Console.WriteLine("ColoredLine введите координату Y ");

            try
            {
                z = Convert.ToInt16(Console.ReadLine());
            }
            catch (MyInvalidCastException e)
            {
                Console.WriteLine(e.Message);
            }            
            Console.WriteLine("ColorLine введите цвет");
            s = Console.ReadLine();
            Point cln = new ColoredLine(k, l, m, z, s);
            cln.Draw();
            Console.WriteLine();
            Console.WriteLine();
            Console.ReadLine();
        }
    }

    class MyInvalidCastException : InvalidCastException
    {

        public MyInvalidCastException()

            : base() { }



        public MyInvalidCastException(string message)

            : base(message) { }



        public MyInvalidCastException(string format, params object[] args)

            : base(string.Format(format, args)) { }



        public MyInvalidCastException(string message, Exception innerException)

            : base(message, innerException) { }



        public MyInvalidCastException(string format, Exception innerException, params object[] args)

            : base(string.Format(format, args), innerException) { }
    }

    public class Picture<T>

        where T : class, IComparable<T>

    {
        private static void Show_Message(string message)
        {
            Console.WriteLine(message);
        }

        public delegate void AddedNewValue(string message);

        public event AddedNewValue Added;

        private T[] array;

        public Picture(int size)
        {
            this.Added += Show_Message;
            array = new T[size];
        }

        public int Length
        {
            get { return array.Length; }
        }

        public void OrderBy(bool desc = false)
        {
            if (desc == true)
                Sort((x, y) => x.CompareTo(y) < 0);

            else
                Sort((x, y) => x.CompareTo(y) > 0);

        }

        protected void Sort(Func<T, T, bool> func)
        {
            if (Length == 0)

                throw new IndexOutOfRangeException();

            for (var i = 0; i < Length - 1; i++)

                for (var j = i + 1; j < Length; j++)

                    if (func(array[i], array[j]))
                    {
                        var temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }

        }
        
        public T this[int index]
        {
            get
            {
                if (index >= Length)   throw new IndexOutOfRangeException();

                return array[index];
            }

            set
            {
                if (Added != null)
                {
                    if (index >= Length)

                        throw new IndexOutOfRangeException();

                    Added($"Added value {value} with index {index}");

                }

                array[index] = value;
            }

        }

        public override string ToString()
        {
            string res = "";

            for (var i = 0; i < Length; i++)

                res = string.Concat(res, string.Concat(array[i] + "\n"));

            return res;

        }
    }
}
