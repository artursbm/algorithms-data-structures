using System;
using System.Net.Http;
using System.Text;
using AutoFixture;

namespace LearningCSharp
{
    class Program
    {
        static void Main(string[] args)
        {
            /*--------------------------------------**-----------------------------------------**/

            //Car car1 = new Car();
            //Car car2 = new ConvertibleCar();
            //ConvertibleCar car3 = new ConvertibleCar();

            //Console.WriteLine("\nCar 1: a standard car");
            //car1.ShowCarName();
            //car1.DescribeCar();

            //Console.WriteLine("\nCar 2: a car that is convertible");
            //car2.ShowCarName();
            //car2.DescribeCar();

            //Console.WriteLine("\nCar 3: a convertible car");
            //car3.ShowCarName();
            //car3.DescribeCar();

            //// testing nullable value types.
            //int? myAge = default;
            //Console.WriteLine($"the value of number is {myAge.GetValueOrDefault(26)}");
            //// the method GetValueOrDefault() is the same as the null-coalescing operator ??
            //int myRealAge = myAge ?? 26;
            //Console.WriteLine($"the value of number is {myRealAge}");

            /*--------------------------------------**-----------------------------------------**/

            //// all nullable reference type warnings will happen at design and compile time
            //// (static analysis), and if it is not "fixed" or no attention is payed,
            //// it is possible to happen runtime erros like null pointer exceptions

            //Citizen citizenKane = new Citizen("John", "Kane", null, "male");
            //// the ! operator is the null-forgiving operator, to indicate
            //// that this property certainly is not null in this context
            //if (citizenKane!.Gender != "female")
            //{
            //    Console.WriteLine("Citizen Kane is a man");
            //}

            //Citizen citizenSmith = new Citizen("Jane", "Smith", 30, "female");
            //// this will raise a warning for null checking of Gender property
            ////if (citizenSmith.Gender = "male")

            //string smithGender = citizenSmith.Gender ?? "male";
            //if (smithGender == "female")
            //{
            //    Console.WriteLine($"{citizenSmith.FirstName} {citizenSmith.LastName} is a woman.");
            //}

            // get uneven numbers in sequence
            // var result = new[] { 1, 2, 3, 4, 5, 6, 7 }.Batch(2);
            // foreach (var r in result)
            // {
            //     Console.WriteLine(r.ElementAt(0));
            // }

            // ## ITERATOR ##
            // var item1 = IteratorTest.TestingYield().GetEnumerator();
            // item1.MoveNext();
            // item1.MoveNext();
            // item1.MoveNext();
            // // this will print 1
            // Console.WriteLine(item1.Current);
            // item1.Dispose();

            // var powersOfTwo = IteratorTest.PowerOf(2, 10);
            // foreach (var num in powersOfTwo)
            // {
            //     Console.WriteLine(num);
            // }

            // var testNullParams = new TestNullParams();
            // testNullParams.PrintNames("hello, ");
        }
    }
}