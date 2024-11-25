package leetcode.top_150;

import java.sql.SQLOutput;

public class BuySellStock {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(" Max Profit : " + maxProfitShare(prices));
    }

    private static int maxProfitShare(int [] prices) {
        if (prices == null || prices.length <=1) {
            return 0; // no profit in this case
        }

        int minPrices = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            // update min prices if current price is lower than min price
            minPrices = Math.min(minPrices, price);

            // update profit if current profit is more that existing profit (current price - minPrice)
            maxProfit = Math.max(maxProfit, price - minPrices);
        }

        return maxProfit;
    }
}
