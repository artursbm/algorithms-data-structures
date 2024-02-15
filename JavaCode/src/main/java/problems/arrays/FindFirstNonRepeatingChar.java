package problems.arrays;

//import java.util.Arrays;
//import java.util.HashMap;

public class FindFirstNonRepeatingChar {
  public static void main(String[] args) {
    System.out.println(solution("abacabacdd"));
  }

  static char solution(String s) {
    for(int i=0; i<s.length(); i++) {
      if(s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i))) {
        return s.charAt(i);
      }
    }

    return '_';
//    var charMap = new HashMap<Character, Integer>();
//
//    for(int i = 0; i<s.length(); i++) {
//      var currChar = s.charAt(i);
//      var nextCount = 1;
//      if(charMap.containsKey(currChar))
//        nextCount = charMap.get(currChar) + 1;
//
//      charMap.put(currChar, nextCount);
//    }
//
//    charMap.values().removeIf(elem -> elem > 1);
//    return charMap.keySet().stream().findFirst().orElse('_');
  }
}
