package problems.arrays;

public class sumInRange {

  public int solution(int[] nums, int[][] queries) {
    if(nums.length == 0 || queries.length == 0) return 0;
    int modulo = 1000000007;
    long sum = 0;

    // prefix sum where prefixSum[0] = 0;
    int[] prefixSum = prefixSum(nums);

    for (final int[] query : queries) {
      sum += prefixSum[query[1] + 1] - prefixSum[query[0]];
    }

    return (int) (sum + modulo) % modulo;

  }

  private int[] prefixSum(int[] arr) {
    int[] prefixSum = new int[arr.length + 1];

    for(int i=0; i<arr.length; i++) {
      prefixSum[i+1] = prefixSum[i] + arr[i];
    }

    return prefixSum;
  }
}
