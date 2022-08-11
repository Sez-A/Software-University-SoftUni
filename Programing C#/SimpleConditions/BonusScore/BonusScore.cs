using System;

namespace BonusScore
{
    class Program
    {
        static void Main()
        {
            Console.Write("Your Score: ");
            var score = int.Parse(Console.ReadLine());
            var bonus = 0.0;
            if (score <= 100)
            {
                bonus = 5;
            }
            else if (score > 100 && score <= 1000)
            {
                bonus = score * 20 / 100;
            }
            else if (score > 1000)
            {
                bonus = score * 0.10;
            }
            if (score % 2 == 0)
            {
                bonus = bonus + 1;
            }
            if (score % 10 == 5)
            {
                bonus = bonus + 2;
            }
            Console.WriteLine("Bonus Score: " + bonus);
            Console.WriteLine("Total Score: " + (bonus + score));
        }
    }
}
