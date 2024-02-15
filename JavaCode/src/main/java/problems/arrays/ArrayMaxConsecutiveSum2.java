package problems.arrays;

import java.util.Arrays;

public class ArrayMaxConsecutiveSum2 {

  public int solutionForHigherPositiveConsecutiveSum(int[] inputArray) {
    int[] bitVec = createBitVector(inputArray);
    if (isAllNegative(bitVec)) {
      Arrays.sort(inputArray);
      return inputArray[inputArray.length - 1];
    } else if (isAllPositive(inputArray)) {
      return Arrays.stream(inputArray).sum();
    }

    int sum = 0;
    for (int i = 0; i < inputArray.length; ) {

      int lastSum = sum;
      sum = 0;
      int j = i;
      while (j < inputArray.length && bitVec[j] == 1) {
        sum += inputArray[j];
        j++;
      }
      i = ++j;

      if (lastSum > sum) {
        sum = lastSum;
      }

    }

    return sum;

  }

  public int fastSolution(int[] inputArray) {
    int maxSum = inputArray[0];
    int currSum = maxSum;

    for(int i=0; i<inputArray.length; i++) {
      currSum = Math.max(inputArray[i], inputArray[i] + currSum);
      maxSum = Math.max(currSum, maxSum);
    }

    return maxSum;
  }

  public int slowSolution(int[] inputArray) {

    // two base cases that can be checked straight away
    int[] bitVec = createBitVector(inputArray);
    if (isAllNegative(bitVec)) {
      Arrays.sort(inputArray);
      return inputArray[inputArray.length - 1];
    } else if (isAllPositive(inputArray)) {
      return Arrays.stream(inputArray).sum();
    }

    // general case where I need to traverse all kinds of intervals and sums
    int[] prefixSum = prefixSum(inputArray);
    int maxConsSum = 0;
    for (int i = 0; i < prefixSum.length - 1; i++) {

      for (int j = i + 1; j < prefixSum.length; j++) {
        int sum = prefixSum[j] - prefixSum[i];
        maxConsSum = Math.max(maxConsSum, sum);
      }
    }

    return maxConsSum;
  }

  private int[] prefixSum(int[] arr) {
    int[] prefixSum = new int[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {
      prefixSum[i + 1] = prefixSum[i] + arr[i];
    }

    return prefixSum;
  }

  private int[] createBitVector(int[] arr) {
    int[] bitVec = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        bitVec[i] = 1;
      }
    }

    return bitVec;
  }

  private boolean isAllNegative(int[] bitVec) {
    boolean isNegative = true;
    for (final int e : bitVec) {
      if (e > 0) {
        isNegative = false;
        break;
      }
    }
    return isNegative;
  }

  private boolean isAllPositive(int[] bitVec) {
    boolean isPositive = true;
    for (final int e : bitVec) {
      if (e <= 0) {
        isPositive = false;
        break;
      }
    }
    return isPositive;
  }

}
