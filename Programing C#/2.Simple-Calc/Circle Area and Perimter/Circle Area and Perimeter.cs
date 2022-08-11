using System;

namespace Circle_Area_and_Perimter
{
    class Program
    {
        static void Main()
        {
            Console.Write("r = ");
            var r = double.Parse(Console.ReadLine());
            var area = Math.PI * r * r;
            var perimeter = 2 * Math.PI * r;
            Console.WriteLine("Circle Area = " + area);
            Console.WriteLine("Circle Perimeter = " + perimeter);
        }
    }
}
