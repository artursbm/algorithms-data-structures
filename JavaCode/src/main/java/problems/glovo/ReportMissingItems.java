package problems.glovo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReportMissingItems {

    public int[] solution(int[] requested, int[] delivered) {
        var requestedMap = new HashMap<Integer, Integer>();
        var deliveredMap = new HashMap<Integer, Integer>();
        List<Integer> missingItems = new ArrayList<>();
        Arrays.stream(requested).forEach(item -> {
            requestedMap.putIfAbsent(item, 0);
            requestedMap.computeIfPresent(item, (k, v) -> ++v);
        });

        Arrays.stream(delivered).forEach(item -> {
            deliveredMap.putIfAbsent(item, 0);
            deliveredMap.computeIfPresent(item, (k, v) -> ++v);
        });

        requestedMap.forEach((k, v) -> {
            if (!deliveredMap.containsKey(k)) {
                missingItems.add(k);
            } else {
                if (!deliveredMap.containsValue(requestedMap.get(k))) {
                    missingItems.add(k);
                }
            }
        });

        return missingItems.stream().mapToInt(Integer::intValue).toArray();
    }
}
