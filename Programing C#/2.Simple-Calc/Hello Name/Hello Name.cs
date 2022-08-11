using System;

namespace Hello_Name
{
    class Program
    {
        static void Main()
        {
            Console.Write("Enter your name: ");
            var name = Console.ReadLine();
            Console.WriteLine("Hello, " + name);
        }
    }
}
