package problems;

import java.util.HashMap;

public class PalindromeRearranging {

  boolean solution(String inputString) {

    // to be a palindrome, a string with even lengths should have all chars in even number of times
    // for an odd length string, all chars should appear in even number of times but one char

    var mappedChars = new HashMap<Character, Integer>();

    for (int i = 0; i < inputString.length(); i++) {
      if (!mappedChars.containsKey(inputString.charAt(i))) {
        mappedChars.put(inputString.charAt(i), 0);
      }

      mappedChars.put(inputString.charAt(i), mappedChars.get(inputString.charAt(i))+1);
    }

    if (inputString.length() % 2 == 0) {
      return mappedChars.values().stream().allMatch(n -> n % 2 == 0);
    }
    else {
      return mappedChars.values().stream().filter(n -> n % 2 != 0).count() == 1;
    }

  }

}
