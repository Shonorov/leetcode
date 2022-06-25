package com.company.dynamic;

/**
 * Best Time to Buy and Sell Stock
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * Explanation:
 * Every step calculate minimum value and max profit depending on current value and minimum value difference.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock app = new BestTimeToBuyAndSellStock();
        System.out.println(app.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(app.maxProfit(new int[]{7,6,4,3,1})); // 0
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public int maxProfitDP(int[] prices) {
        int maxProfit = 0;
        int[][] dp = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (i == 0) {
                    dp[i][j] = prices[j] - prices[i];
                } else {
                    dp[i][j] = dp[i - 1][j] - dp[i - 1][i];
                }
                maxProfit = Math.max(dp[i][j], maxProfit);
            }
        }
        return maxProfit;
    }

    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int dif = prices[j] - prices[i];
                maxProfit = Math.max(dif, maxProfit);
            }
        }
        return maxProfit;
    }
}
