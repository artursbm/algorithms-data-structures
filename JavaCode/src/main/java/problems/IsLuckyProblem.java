package problems;

public class IsLuckyProblem {
  public static void main(String[] args) {
    System.out.println(solution(123321));
  }

  private static boolean solution(int n) {
    // finding how many digits a number have recursively
    int digits = findNOrder(n, 0);

    // if N has odd number of digits, it's not lucky
    if (digits % 2 == 0) {
      return false;
    }

    return true;

  }

  private static int findNOrder(int n, int dec) {
    if (n / 10 == 0) {
      return 1;
    } else {
      return dec + findNOrder(n / 10, 1);
    }
  }

}



