using System;

namespace Street_Shop
{
    class Program
    {
        static void Main()
        {
            Console.Write("Product: ");
            var product = Console.ReadLine().ToLower();
            Console.Write("Town: ");
            var town = Console.ReadLine().ToLower();
            Console.Write("Quantity: ");
            var quantity = int.Parse(Console.ReadLine());
            if(town == "sofia")
            {
                if (product == "coffee") Console.WriteLine(quantity * 0.50);
                else if (product == "water") Console.WriteLine(quantity * 0.80);
                else if (product == "beer") Console.WriteLine(quantity * 1.20);
                else if (product == "sweets") Console.WriteLine(quantity * 1.45);
                else if (product == "peaunts") Console.WriteLine(quantity * 1.60);
            }
            else if (town == "plovdiv")
            {
                if (product == "coffee") Console.WriteLine(quantity * 0.40);
                else if (product == "water") Console.WriteLine(quantity * 0.70);
                else if (product == "beer") Console.WriteLine(quantity * 1.15);
                else if (product == "sweets") Console.WriteLine(quantity * 1.30);
                else if (product == "peaunts") Console.WriteLine(quantity * 1.50);
            }
            else if (town == "varna")
            {
                if (product == "coffee") Console.WriteLine(quantity * 0.45);
                else if (product == "water") Console.WriteLine(quantity * 0.70);
                else if (product == "beer") Console.WriteLine(quantity * 1.10);
                else if (product == "sweets") Console.WriteLine(quantity * 1.35);
                else if (product == "peaunts") Console.WriteLine(quantity * 1.55);
            }
            else
            {
                Console.WriteLine("Invalid");
            }
        }
    }
}
