package problems;

public class StockPrice {
    public int profit(int[] prices) {
        int profit = 0;
        int b = prices[0];
        int s = prices[prices.length - 1];
        int i = 0;
        int j = prices.length - 1;
        for (i = 0, j = prices.length - 1; i <= j; i++, j--) {
            if (prices[i + 1] < b) {
                b = prices[++i];
            }
            if (prices[j - 1] > s) {
                s = prices[--j];
            }
        }
        profit = s - b;
        return profit;
    }
}
