using System.Collections.Generic;

namespace AlgAndDsProblems.problems
{
    public class BubbleSort
    {
        public static List<int> BSort(List<int> arr, int length, out int swapsMade)
        {
            swapsMade = 0;
            for (var i = 0; i < length; i++)
            {
                for (var j = 0; j < length - 1; j++)
                {
                    if (arr[j] >= arr[j + 1])
                    {
                        Swap(arr, j, j + 1);
                        swapsMade++;
                    }
                }
            }

            return arr;
        }

        private static void Swap(List<int> arr, int a, int b)
        {
            (arr[a], arr[b]) = (arr[b], arr[a]);
        }

    }
}