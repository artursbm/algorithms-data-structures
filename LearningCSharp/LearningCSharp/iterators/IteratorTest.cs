using System.Collections.Generic;

namespace LearningCSharp.iterators
{
    public static class IteratorTest
    {
        // iterators returns an iterator method or property, which means that it can return
        // either an IEnumerable, generic or not, or an IEnumerator. The code executes in a way
        // that each time the method below is called, the next yield return statement is executed.
        // The method "stops" the execution in the current yield statement, and so on.
        // This can be used to manipulate and create sequences of values;
        public static IEnumerable<int> TestingYield()
        {
            yield return 12;
            for (int i = 0; i < 5; i++)
            {
                yield return i;
            }

            yield return 13;
        }
        
        // this will create a sequence of the power of a number, from 0 to the exponent;
        public static IEnumerable<int> PowerOf(int number, int exponent)
        {
            int result = 1;

            for (int i = 0; i < exponent; i++)
            {
                if (i == 0)
                {
                    yield return 1;
                }
                result *= number;
                yield return result;
            }
        }
    }
}