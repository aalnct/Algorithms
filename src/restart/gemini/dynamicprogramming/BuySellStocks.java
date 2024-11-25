package restart.gemini.dynamicprogramming;

public class BuySellStocks {
    public static void main(String[] args) {
        int [] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(buySellStocks(prices));
    }

    static int buySellStocks (int [] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
        }

        return maxProfit;
    }
}
