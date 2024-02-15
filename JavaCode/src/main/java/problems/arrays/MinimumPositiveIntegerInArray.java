package problems.arrays;

public class MinimumPositiveIntegerInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 1, 2};
        int min = 1;
        int max = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                if(arr[i] == min) {
                    min++;
                } else if(arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        System.out.println(min);
    }

}
