package problems;

public class IsIpV4Address {

  boolean solution(String inputString) {
    String regex = "\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\b\\.\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\b\\.\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\b\\.\\b(1?[0-9]{1}|2[0-4][0-9]|25[0-5])\\b";
    return inputString.matches(regex);
  }
}
