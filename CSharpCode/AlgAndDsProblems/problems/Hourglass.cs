using System.Collections.Generic;

namespace AlgAndDsProblems.problems
{
    /// <summary>
    /// Part of array interview preparation kit from hackerRank
    /// </summary>
    public class Hourglass
    {
        public static int hourglassSum(List<List<int>> arr)
        {
            var window = new List<List<int>>
            {
                new() {1, 1, 1},
                new() {0, 1, 0},
                new() {1, 1, 1}
            };
            var rowBoundary = arr[0].Count - window[0].Count;
            var colBoundary = arr[0].Count - window[0].Count;

            var hgSum = int.MinValue;

            for (int j = 0; j <= rowBoundary; j++)
            {
                for (int i = 0; i <= colBoundary; i++)
                {
                    int currentHgSum = 0;
                    var l = j;
                    // need to dissociate window from arr in iteration for sum.
                    for (int n = 0; n < window[0].Count; n++)
                    {
                        var k = i;
                        for (int m = 0; m < window.Count; m++)
                        {
                            currentHgSum += window[n][m] * arr[l][k];
                            k++;
                        }

                        l++;
                    }

                    if (currentHgSum >= hgSum)
                    {
                        hgSum = currentHgSum;
                    }
                }
            }

            return hgSum;
        }
    }
}