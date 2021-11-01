using System.Collections.Generic;
using System.Linq;

namespace AlgAndDsProblems.problems
{
    public class SalesByMatch
    {
        
        /*
         * Complete the 'sockMerchant' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY ar
         */
        public static int SockMerchant(int n, List<int> ar)
        {
            var pairsOfSocks = new Dictionary<int, int>();
            
            foreach (var sock in ar)
            {
                if (!pairsOfSocks.ContainsKey(sock))
                {
                    pairsOfSocks.Add(sock, 1);
                }
                else
                {
                    pairsOfSocks[sock]++;
                }
            }

            var pairCount = pairsOfSocks.Values.Sum(val => val/2);
            return pairCount;
        }

    }
}