import problems.StockPriceII;

public class Main {

    public static void main(String[] args) {
        StockPriceII stockPrice = new StockPriceII();
        int[] prices = new int[] {7,6,4,3,1};
        System.out.println(stockPrice.maxProfit(prices));
    }
}
