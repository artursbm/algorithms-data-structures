package problems;

import java.util.*;

public class Solution {

    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes) {


        class F implements Comparable<F> {
            F(String k, int f) {
                this.key = k;
                this.freq = f;
            }

            private String key;
            private int freq;

            public String getKey() {
                return this.key;
            }

            public int getFreq() {
                return this.freq;
            }

            @Override
            public int compareTo(F o) {
                return (int) (this.freq - o.getFreq());
            }
        }
        // this map counts frequency in which each toy in toys appears in quotes.
        // will populate with all toys in list, and set frequency to 0
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String toy : toys) {
            frequency.put(toy, 0);
        }
        for (String quote : quotes) {
            // trying to count every repeated word in quotes, and then will filter from the toysList
            HashSet<String> wordsInQuote = new HashSet<>(Arrays.asList(quote.replaceAll("[^a-zA-Z]", " ")
                    .toLowerCase().split(" ")));
            // after this, frequency will have all toys present in quote, with its calculated frequency
            wordsInQuote.forEach(word -> {
                if (frequency.containsKey(word)) {
                    frequency.put(word, frequency.getOrDefault(word,0) + 1);
                }
            });
        }

        // need to sort the frequency map in order to get the most frequent toy first
        // then I can add the n most frequent toys to mostPopularToys
        HashMap<String, F> sortingMap = new HashMap<>();
        for (String key : frequency.keySet()) {
            sortingMap.put(key, new F(key, frequency.get(key)));
        }
        List<F> listToSort = new ArrayList<>(sortingMap.values());
        Collections.sort(listToSort);

        // this will store the result, with topToys size OR numToys if numToys < topToys
        ArrayList<String> mostPopularToys = new ArrayList<>(frequency.keySet());

        int n = numToys < topToys ? numToys : topToys;
        for (int i = 0; i < n; i++) {
            mostPopularToys.add(listToSort.get(i).getKey());
        }

        return mostPopularToys;
    }

}
