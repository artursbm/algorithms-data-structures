package problems;

import java.util.ArrayList;
import java.util.List;

public class RemovableIndices {

    public List<Integer> getRemovableIndices(String str1, String str2) {
        // THIS SOLUTION HAS PROBLEMS WITH OPTMIZATION!!!! IT FAILS SOME CASES
        ArrayList<Integer> output = new ArrayList<>(str2.length());

        int i = 0;
        while (i < str2.length()) {
            String aux = str1.substring(0, i) + str1.substring(i+1);
            if(aux.equals(str2)) {
                output.add(i);
            }
            i++;
        }
        if(str1.substring(0, i).equals(str2)) output.add(i);

        return output.isEmpty() ? List.of(-1) : output;
    }
}
