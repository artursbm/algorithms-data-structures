package problems.backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {

        Map<String, List<String>> keyboard = Map.of(
          "2", List.of("a", "b", "c"),
          "3", List.of("d", "e", "f"),
          "4", List.of("g", "h", "i"),
          "5", List.of("j", "k", "l"),
          "6", List.of("m", "n", "o"),
          "7", List.of("p", "q", "r", "s"),
          "8", List.of("t", "u", "v"),
          "9", List.of("w", "x", "y", "z")
        );

        return List.of();



    }
}
