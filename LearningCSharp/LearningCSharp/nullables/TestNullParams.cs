using System;

namespace LearningCSharp.nullables
{
    public class TestNullParams
    {
        public TestNullParams()
        {
        }

        public void PrintNames(string title, params string[] names)
        {
            
            Console.WriteLine(title + " " + names.Length);
            
            foreach (var name in names)
            {
                Console.WriteLine(name + ",");
            }
        }
    }
}