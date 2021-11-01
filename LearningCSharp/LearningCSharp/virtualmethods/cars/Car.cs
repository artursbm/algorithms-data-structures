using System;
namespace LearningCSharp.virtualmethods.cars

{
    public abstract class Car
    {
        public string Name { get; set; }
        
        public int Weight { get; set; }
        
        public void ShowCarName()
        {
            Console.WriteLine("This is a standard car");
        }

        // abstract method demands override on derived class
        public abstract string GetPlateNumber();

        // this method can be overriden by derived classes, and thus any object
        // that instantiate a derived class will call the derived method.
        public virtual void DescribeCar()
        {
            Console.WriteLine("This car contains 4 wheels and 5 seats");                 
        }
        
    }


}
