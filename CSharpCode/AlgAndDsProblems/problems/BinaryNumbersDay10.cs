using System;
using System.Text;

namespace AlgAndDsProblems.problems
{
    public class BinaryNumbersDay10
    {

        private string ConvertToBinary(int n)
        {
            var binaryNum = new StringBuilder();
            if (n == 2)
            {
                return binaryNum.Append(1).Append(0).ToString();
            }
            else
            {
                return binaryNum.Append(n % 2).Append(ConvertToBinary(n / 2)).ToString();
                
            }
        }
        
        public void Solution()
        {
            var n = Convert.ToInt32(Console.ReadLine());
        }
    }
}