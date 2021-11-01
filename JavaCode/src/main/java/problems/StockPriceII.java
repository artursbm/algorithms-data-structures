package problems;

public class StockPriceII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int b;
        int s;
        int i = 0;
        while (i < prices.length - 1) {
            if (prices[i] < prices[i + 1]) {
                b = prices[i];
                int j = i + 1;
                while (j+1 < prices.length && prices[j] < prices[j + 1]) {
                    j++;
                }
                s = prices[j];
                profit += s - b;
                i=j+1;
            } else {
                i++;
            }
        }
        return profit;
    }

}
