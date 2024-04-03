package problems;

public class ReverseInParenthesis {

  // guarantees: regular bracket sequence
  // inputString = "(bar)" | outputString = "rab"
  public String solution(String inputString) {

    // in case no parenthesis exists
    if (!inputString.contains("(")) {
      return inputString;
    }

    StringBuilder outputStr = new StringBuilder(inputString);

    while (outputStr.indexOf("(") != -1) {
      final int start = outputStr.lastIndexOf("(");
      final int end = outputStr.indexOf(")", start) + 1;
      var substr = outputStr.substring(start, end);
      outputStr.replace(start, end, reverseInnerString(substr));
    }

    return outputStr.toString();

  }

  private String reverseInnerString(String str) {
    return new StringBuilder(str.replace("(", "").replace(")", ""))
        .reverse().toString();
  }
}
