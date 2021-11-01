using System;

namespace AlgAndDsProblems.problems {

    public static class SolutionRepeatedStrings {
        public static long repeatedString(string s, long n)
        {
            long len = s.Length;
            long div = n / len;
            long mod = n % len;
            long aInS = 0;
            long totalAs = 0;
            
            foreach(var c in s) {
                if(c == 'a') aInS++;
            }
            totalAs += aInS * div;
            
            for(int i = 0; i < mod; i++) {
                if(s[i] == 'a') totalAs++;
            }
            
            return totalAs;
        }
    }

}