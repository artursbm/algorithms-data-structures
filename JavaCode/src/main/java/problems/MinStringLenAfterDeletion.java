package problems;

public class MinStringLenAfterDeletion {

    public int minimumLength(String s) {
        StringBuilder output = new StringBuilder(s);
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); ) {
            if (i >= j) {
                return output.length();
            }
            if (s.charAt(i) == s.charAt(j)) {
                char del = s.charAt(i);
                while (i < s.length() && s.charAt(i) == del) {
                    output.deleteCharAt(0);
                    i++;
                }
                if (i >= j) {
                    return output.length();
                }
                while (j >= 0 && s.charAt(j) == del) {
                    output.deleteCharAt(output.length() - 1);
                    j--;
                }
            } else {
                return output.length();
            }
        }
        return 0;
    }
}
