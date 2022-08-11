using System;

namespace SumatorSeconds
{
    class Program
    {
        static void Main()
        {
            var first = int.Parse(Console.ReadLine());
            var second = int.Parse(Console.ReadLine());
            var third = int.Parse(Console.ReadLine());
            var SecondSum = first + second + third;
            var minutes = SecondSum / 60;
            var seconds = SecondSum % 60;
            Console.WriteLine("{0:0}:{1:00}",minutes,seconds);
        }
    }
}
                            