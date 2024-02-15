package problems.arrays;

public class IsCryptSolution {

  public boolean solution(String[] crypt, char[][] solution) {

    //solution without using extra memory
    long sumLeft = 0;
    for (int w = 0; w < crypt.length; w++) {

      var word = crypt[w];
      for (final char[] chars : solution) {
        word = word.replaceAll(String.valueOf(chars[0]), String.valueOf(chars[1]));
      }
      crypt[w] = word;
      if (!crypt[w].equals("0") && crypt[w].startsWith("0")) {
        return false;
      } else if (w != 2) {
        sumLeft += Long.parseLong(crypt[w]);
      }
    }
    return sumLeft == Long.parseLong(crypt[2]);
  }
}