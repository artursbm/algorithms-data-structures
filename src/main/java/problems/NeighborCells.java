package problems;

import java.util.ArrayList;
import java.util.List;

public class NeighborCells {
    public List<Integer> cellCompete(int[] states, int days) {
        // taking the previousState (on first day, previousState = states)
        List<Integer> previousState = new ArrayList<>();
        for (int s : states) {
            previousState.add(s);
        }
        List<Integer> newState = new ArrayList<>();
        for (int d = 0; d < days; d++) {
            for (int i = 0; i < previousState.size(); i++) {
                if (i == 0) {
                    newState.add(i, previousState.get(i + 1));
                } else if (i == previousState.size() - 1) {
                    newState.add(i, previousState.get(i - 1));
                } else {
                    newState.add(i, previousState.get(i - 1) ^ previousState.get(i + 1));
                }
            }
            for (int k = 0; k < newState.size(); k++) {
                previousState.set(k, newState.get(k));
            }
            newState.clear();
        }
        return previousState;
    }
    // METHOD SIGNATURE ENDS
}
