package com.company.challenge3;

/**
 * Coin Change 2
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * You can assume that
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 *
 * Algorithm:
 * Create dynamic matrix with last index == amount.
 * In cycle for every coin from its value to the amount add matrix[i - coin] element.
 * matrix[amount] is the result.
 * Matrix for the example 1:
 * [ 1 1 1 1 1 1 ] 1-coin
 * [ 1 1 2 2 3 3 ] 2-coin
 * [ 1 1 2 2 3 4 ] 5-coin
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class CoinChange2 {

    public static void main(String[] args) {
        CoinChange2 app = new CoinChange2();
        int[] test = {1,2,5};
        int[] test2 = {2};
        int[] test3 = {10};
        System.out.println(app.change(5, test)); // 4
        System.out.println(app.change(3, test2)); // 0
        System.out.println(app.change(10, test3)); // 1

    }

    private int change(int amount, int[] coins) {
        int[] matrix = new int[amount + 1];
        matrix[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                matrix[i] += matrix[i - coin];
            }
        }
        return matrix[amount];
    }
}
