package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList();
        int carryOne = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i] + carryOne;
            if (n == 10) {
                carryOne = 1;
                list.add(0, 0);
            } else {
                carryOne = 0;
                list.add(0, n);
            }
        }
        if (carryOne == 1) {
            list.add(0, 1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public int[] plusOneRecursive(int[] digits) {
        List<Integer> digArrayList = Arrays.stream(digits).boxed().collect(Collectors.toList());
        int lastIndex = digArrayList.size() - 1;
        sumRecursive(digArrayList, lastIndex);
        return digArrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void sumRecursive(List<Integer> array, int idx) {
        int num = array.get(idx);
        if (array.get(idx) + 1 < 10) {
            array.set(idx, num + 1);
        } else {
            array.set(idx, 0);
            if (idx == 0) {
                array.add(0, 1);
            } else {
                sumRecursive(array, idx - 1);
            }
        }
    }
}
