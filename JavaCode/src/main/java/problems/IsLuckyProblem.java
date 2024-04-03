package problems;

// easy solution would be to transform 'n' into a string, and being it an array of chars, iterate to sum each half of
// the array.
public class IsLuckyProblem {
  public static void main(String[] args) {
    System.out.println(solution(1221));
  }

  private static boolean solution(int n) {
    // finding how many digits a number have recursively
    int digits = findNOrder(n, 0);

    // if N has odd number of digits, it's not lucky
    if (digits % 2 == 0) {
      return false;
    }

    int lim = 0;
    int firstHalf = 0;
    int secHalf = 0;
    while (lim <= digits) {
      if(lim <= digits/2) {
        firstHalf += n / ((int) Math.pow(10, (digits-lim)));
      }
      else {
        secHalf += n / ((int) Math.pow(10, (digits-lim)));
      }
      n %= ((int) Math.pow(10, (digits-lim)));
      lim++;
    }

    return firstHalf == secHalf;

  }

  private static int findNOrder(int n, int dec) {
    if (n / 10 == 0) {
      return 1;
    } else {
      return dec + findNOrder(n / 10, 1);
    }
  }

}



