package problems.arrays;

public class ArrayChange {

  int solution(int[] inputArray) {
    // I can start by taking the minNextValue:
    int minNextValue = inputArray[0] + 1;
    int moves = 0;
    for (int i = 1; i < inputArray.length; i++) {
      if(inputArray[i] < minNextValue) {
        moves+=minNextValue-inputArray[i];
        inputArray[i] = minNextValue;
      }
      minNextValue = inputArray[i] + 1;
    }

    return moves;
  }

}
