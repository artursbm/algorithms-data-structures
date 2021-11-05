using System;
using System.Collections.Generic;
using System.Linq;
using AlgAndDsProblems.problems;

namespace AlgAndDsProblems
{
    class Solution
    {
        static void Main(String[] args)
        {
            List<List<int>> arr = new()
            {
                new() {1, 1, 1, 0, 0, 0},
                new() {0, 1, 0, 0, 0, 0},
                new() {1, 1, 1, 0, 0, 0},
                new() {0, 0, 2, 4, 4, 0},
                new() {0, 0, 0, 2, 0, 0},
                new() {0, 0, 1, 2, 4, 0}
            };
            
            var result = Hourglass.hourglassSum(arr);

            Console.WriteLine(result);
        }
    }
}