package problems;

public class AlternatingSums {
  int[] solution(int[] a) {
    int teamOneWeight = 0;
    int teamTwoWeight = 0;

    for (int i = 0; i < a.length; i += 2) {
      int j = i + 1;
      teamOneWeight += a[i];
      if (j >= a.length) {
        break;
      }
      teamTwoWeight += a[j];
    }

    return new int[] {teamOneWeight, teamTwoWeight};
  }
}
