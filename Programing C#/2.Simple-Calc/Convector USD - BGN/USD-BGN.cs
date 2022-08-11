using System;

namespace Convector_USD___BGN
{
    class Program
    {
        static void Main()
        {
            Console.Write("USD = ");
            var USD = double.Parse(Console.ReadLine());
            var BGN =  USD *  1.79549;
            Console.WriteLine(" {0} BGN", Math.Round(BGN,2));
        }
    }
}
