using System;

namespace Text_with_Numbers
{
    class Program
    {
        static void Main()
        {
            var firstName = Console.ReadLine();
            var secondName = Console.ReadLine();
            var age = int.Parse(Console.ReadLine());
            var town = Console.ReadLine();
            Console.WriteLine("You are {0} {1} ,a {2} years old person from {3} ", firstName, secondName, age, town);
        }
    }
}
