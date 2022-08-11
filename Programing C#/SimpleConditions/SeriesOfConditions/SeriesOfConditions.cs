using System;

namespace SeriesOfConditions
{
    class Program
    {
        static void Main()
        {
            var num = int.Parse(Console.ReadLine());
            if(num == 1)
            {
                Console.WriteLine("One");
            }
            else if (num == 2)
            {
                Console.WriteLine("Two");
            }
            else if (num == 3)
            {
                Console.WriteLine("Three");
            }
            else if (num == 4)
            {
                Console.WriteLine("Four");
            }
            else if (num == 5)
            {
                Console.WriteLine("Five");
            }
            else if (num == 6)
            {
                Console.WriteLine("Six");
            }
            else if (num == 7)
            {
                Console.WriteLine("Seven");
            }
            else if (num == 8)
            {
                Console.WriteLine("Eight");
            }
            else if (num == 9)
            {
                Console.WriteLine("Nine");
            }
            else if (num == 10)
            {
                Console.WriteLine("Ten");
            }
            else
            {
                Console.WriteLine("Number too Big");
            }
        }
    }
}
