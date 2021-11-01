using System;
using System.Text;

namespace AlgAndDsProblems.problems
{
    public class StringDay6
    {
        public void Solution()
        {
            var T = Console.ReadLine();
            int nTests = int.Parse(T!);
            for (int n = 0; n < nTests; n++)
            {
                var S = Console.ReadLine();
                var sb = new StringBuilder();
                for (int i = 0; i < S!.Length; i += 2)
                {
                    sb.Append(S[i]);
                }

                sb.Append(" ");
                for (int i = 1; i < S!.Length; i += 2)
                {
                    sb.Append(S[i]);
                }

                Console.WriteLine(sb.ToString());
            }
        }
    }
}