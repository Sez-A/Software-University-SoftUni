using System;

namespace Even_or_Odd
{
    class Program
    {
        static void Main()
        {
            Console.Write("Number: ");
            var num = int.Parse(Console.ReadLine());
            if (num % 2 == 0)
            {
                Console.WriteLine("Eve");
            }
            else
            {
                Console.WriteLine("Odd");
            }
        }
    }
}
