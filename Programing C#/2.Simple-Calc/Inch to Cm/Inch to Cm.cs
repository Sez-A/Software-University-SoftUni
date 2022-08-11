using System;

namespace Inch_to_Cm
{
    class Program
    {
        static void Main()
        {
            Console.Write("Inches = ");
            var inches = double.Parse(Console.ReadLine());
            var centimeters = inches * 2.54;
            Console.WriteLine("Centimeters = "+centimeters);
        }
    }
}
