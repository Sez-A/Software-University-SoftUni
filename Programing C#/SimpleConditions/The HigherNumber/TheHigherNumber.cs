using System;

namespace The_HigherNumber
{
    class Program
    {
        static void Main()
        {
            Console.Write("Number 1 = ");
            var num1 = int.Parse(Console.ReadLine());
            Console.Write("Number 2 = ");
            var num2 = int.Parse(Console.ReadLine());
            if (num1 > num2)
            {
                Console.WriteLine("The Greater Number is: " + num1);
            }
            else
            {
                Console.WriteLine("The Greater Number is: " + num2);
            }
        }
    }
}
