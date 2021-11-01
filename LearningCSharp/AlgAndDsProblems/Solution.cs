using AlgAndDsProblems.problems;
using System;
using System.Linq;

namespace AlgAndDsProblems
{
    class Solution
    {
        static void Main(String[] args)
        {
            var n = Convert.ToInt32(Console.ReadLine().Trim());

            var ar = Console.ReadLine().TrimEnd().Split(' ').ToList().Select(arTemp => Convert.ToInt32(arTemp)).ToList();

            var result = SalesByMatch.SockMerchant(n, ar);

            Console.WriteLine(result);
        }
    }
}