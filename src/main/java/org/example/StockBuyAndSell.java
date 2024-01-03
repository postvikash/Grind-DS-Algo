package org.example;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

/**
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class StockBuyAndSell {

    public static void main( String[] args )
    {

        int [] nums = {1,2,3,4,5,5,6,7,8,5,5,5,5};
        int answer = maxProfit(nums);
        System.out.println(answer);
    }

    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max_profit)
                    max_profit = prices[j] - prices[i];
            }
        }
        return max_profit;
    }

}
