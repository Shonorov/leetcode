package com.company.array;

/**
 * Best Time to Buy and Sell Stock II
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Time complextiy : O(n).
 * Space complexity : O(1).
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        int[] test1 = {7, 1, 5, 3, 6, 4};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {7, 6, 4, 3, 1};
        int[] test4 = {7, 1, 5, 3, 6, 4};
        int[] test5 = {1, 7, 2, 3, 6, 7, 6, 7};
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(test1)); //7
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(test2)); //4
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(test3)); //0
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(test4)); //7
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(test5)); //12
    }

    /**
     * Сложить разницы всех подъемов.
     */
    private int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
