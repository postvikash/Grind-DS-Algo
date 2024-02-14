package org.example;

public class BuyAndSellStocks2 {
    public static void main(String[] args) {
        int [] prices1 = {7,1,5,3,6,4};
        int [] prices2 = {1,2,3,4,5};
        int [] prices3 = {7,6,4,3,1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }
    public static int maxProfit(int[] prices) {
        int local_maxima = prices[0];
        int local_minima = prices[0];
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < local_minima) {
                local_minima = prices[i];
                // Set local maxima value same as local minima since stocks cannot be sold in past
                local_maxima = prices[i];
            }
            if (prices[i] > local_maxima) {
                local_maxima = prices[i];
            }
            if (local_maxima - local_minima > 0)
                max_profit = max_profit + local_maxima - local_minima;
            // Set local minima value same as local maxima to avoid recompuation of same minima
            local_minima = local_maxima;
        }
        return max_profit;
    }
}
