using System;

namespace Grade
{
    class Program
    {
        static void Main()
        {
            Console.Write("Grade: ");
            var grade = double.Parse(Console.ReadLine());
            if (grade >= 5.50)
            {
                Console.WriteLine("Excellent !");
            }
            else
            {
                Console.WriteLine("Not Excellent ");
            }
        }
    }
}
