using System;
using System.Collections.Generic;

namespace AlgAndDsProblems.problems
{
    public class DictionaryDay8
    {
        public void Solution()
        {
            var n = int.Parse(Console.ReadLine());
            var phoneBook = new Dictionary<string, int>();
            for (int i = 0; i < n; i++)
            {
                var line = Console.ReadLine();
                var name = line.Split(' ')[0];
                var phoneNumber = int.Parse(line.Split(' ')[1]);
                phoneBook.Add(name, phoneNumber);
            }

            var flag = true;
            while (flag)
            {
                var input = Console.ReadLine();
                if (input == null)
                {
                    flag = false;
                }
                else
                {
                    Console.WriteLine(phoneBook.ContainsKey(input) ? $"{input}={phoneBook[input]}" : "Not found");
                }
            }
        }
    }
}