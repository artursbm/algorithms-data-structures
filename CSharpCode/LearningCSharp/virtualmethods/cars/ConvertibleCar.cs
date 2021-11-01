using System;

namespace LearningCSharp.virtualmethods.cars
{
    public class ConvertibleCar : Car
    {
        public ConvertibleCar()
        {
            Console.WriteLine("Creating a convertible car");
        }

        // any object that instantiates the base class will call the base method
        // if an object is of type ConvertibleCar, it will then call this method.
        // Car c = new ConvertibleCar() will still calls base ShowCarName() method
        // because the referenced class method will only be called if the object
        // is of type ConvertibleCar.
        public new void ShowCarName()
        {
            Console.WriteLine("Convertible car");
        }

        public override string GetPlateNumber()
        {
            return "CNV1994CAR";
        }

        // if I want to override a method from base class, either it should be
        // an abstract or virtual class, or the base method should have a virtual modifier.
        // Any object that instantiates this class or initializes it, will call this
        // method, doesn't matter if it is created as a Car or ConvertibleCar.
        public override void DescribeCar()
        {
            Console.WriteLine("This car has no roof and costs more");
        }

    }
}
