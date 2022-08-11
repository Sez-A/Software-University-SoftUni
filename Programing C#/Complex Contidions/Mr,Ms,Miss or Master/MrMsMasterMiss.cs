using System;

namespace Mr_Ms_Miss_or_Master
{
    class Program
    {
        static void Main()
        {
            Console.Write("Age: ");
            var age = int.Parse(Console.ReadLine());
            Console.Write("Gender: ");
            var gender = Console.ReadLine();
            if (age >= 16)
            {
                if (gender == "f")
                    Console.WriteLine("Ms");
                else if (gender == "m")
                    Console.WriteLine("Mr");
            }
            else if (age < 16)
            {
                if (gender == "f")
                    Console.WriteLine("Miss");
                else if (gender == "m")
                    Console.WriteLine("Master");
            }
        }
      }
    }
