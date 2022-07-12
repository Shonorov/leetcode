package com.company.dynamic;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Coin Change
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/809/
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * Explanation:
 * Create DP array m + 1 length. minCount[0] = 0.
 * Start from 1 to amount calc min coin count.
 * minCount[n] = Math.min(minCount[n], minCount[n - coin[0]] ... minCount[n - coin[m]]).
 * See: CoinChange.png
 *
 * Time complexity : O(n * m). n - amount, m - coins length
 * Space complexity : O(n).
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange app = new CoinChange();
        assertEquals(3, app.coinChange(new int[]{1,2,5}, 11));
        assertEquals(-1, app.coinChange(new int[]{2}, 3));
        assertEquals(0, app.coinChange(new int[]{1}, 0));
    }

    public int coinChange(int[] coins, int amount) {
        int[] minCount = new int[amount + 1];
        Arrays.fill(minCount, amount + 1);
        minCount[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    minCount[i] = Math.min(minCount[i], minCount[i - coin] + 1);
                }
            }
        }
        return minCount[amount] <= amount ? minCount[amount] : -1;
    }
}
