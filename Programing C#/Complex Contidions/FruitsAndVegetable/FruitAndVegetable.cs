using System;

namespace FruitsAndVegetable
{
    class Program
    {
        static void Main()
        {
            var s = Console.ReadLine();
            if (s == "banana" || s == "apple" || s == "kiwi" || s == "grapes" || s == "lemon")
            {
                Console.WriteLine("fruit");
            }
            else if (s == "carrot" || s == "tomato" || s == "cucumber" || s == "papper" || s == "onions")
            {
                Console.WriteLine("vegetable");
            }
            else
            {
                Console.WriteLine("unknown");
            }
        }
     }
  }
