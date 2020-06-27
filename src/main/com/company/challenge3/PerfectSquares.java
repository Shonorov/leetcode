package com.company.challenge3;

import java.util.Arrays;

/**
 * Perfect Squares
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * Algorithm:
 * Generate dynamic programming array for every number including n.
 * Minimum perfect squares for number is minimum of DP array[n - all squares lower than n] + 1 (1 is the current subtracted square here);
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares app = new PerfectSquares();
        System.out.println(app.numSquares(12)); // 3
        System.out.println(app.numSquares(13)); // 2
        System.out.println(app.numSquares(16)); // 1
        System.out.println(app.numSquares(10)); // 2
    }

    private int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
