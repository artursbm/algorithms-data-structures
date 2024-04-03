package problems.glovo;

import java.util.HashMap;
import java.util.HashSet;

public class PairOfSocks {

    // we can solve this problem by grouping the socks by colors,
    // whilst counting the number of socks in each group
    // we can achieve that using a map

    // solution O(n) with hashmap,
    // where lookup is O(1) due to hashing function, but writing is O(n)
    public int solution(int[] socks) {
        var map = new HashMap<Integer, Integer>();

        for (int sock : socks) {
            map.putIfAbsent(sock, 0);
            map.computeIfPresent(sock, (k, v) -> ++v);
        }

        return map.values().stream().filter(v -> v >= 2).mapToInt(v -> v/2).sum();
    }

    // solution O(n) with set, where lookup is O(n)
    public int solutionWithSet(int[] socks) {
        var set = new HashSet<Integer>();
        var pairCount = 0;
        for(var sock : socks) {
            if(!set.add(sock)) {
                pairCount++;
                set.remove(sock);
            }
        }
        return pairCount;
    }

}
