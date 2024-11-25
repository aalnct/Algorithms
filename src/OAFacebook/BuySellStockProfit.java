package OAFacebook;

public class BuySellStockProfit {

    public static void main(String[] args) {
        int [] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(buySellStock(prices));
    }

    static int buySellStock(int [] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            minPrice = Math.min(price,minPrice);

            // calculate the potential profit
            int potentialProfit = price - minPrice;
            profit = Math.max(profit,potentialProfit);
        }
        return profit;
    }
}
