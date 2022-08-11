using System;

namespace Number_100_200
{
    class Program
    {
        static void Main()
        {
            var num = int.Parse(Console.ReadLine());
            if (num >= 100 && num <= 200)
            {
                Console.WriteLine("Valid");
            }
            else if (num == 0)
            {
                Console.WriteLine("Valid");
            }
            else
            {
                Console.WriteLine("Invalid");
            }
        }
    }
}
