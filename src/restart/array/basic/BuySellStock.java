package restart.array.basic;

public class BuySellStock {

    public static void main(String[] args) {
        int [] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }
    static int maxProfit (int [] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // first calculate the price on which to buy a stock

            if (price < minPrice) {
                minPrice = price;
            } else {
                // here we will calculate the profit from above prices
                int profit = price - minPrice;

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

}
