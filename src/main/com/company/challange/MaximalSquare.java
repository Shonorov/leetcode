package com.company.challange;

/**
 * Maximal Square
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3312/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 * Explanation:
 * Use Dynamic Programming.
 * Build DP matrix [length + 1][height + 1]
 * Traverse original matrix once.
 * If '1' met, then DP[i][j] = Min of top, left and up-left elements + 1;
 * Maximum of DP element will be the max square side.
 *
 * Time complexity : O(mn).
 * Space complexity : O(mn).
 */
public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare app = new MaximalSquare();
        char[][] test = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(app.maximalSquare(test)); // 4

    }

    private int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    // Use array for DP. Store previous value in variable.
    // Time complexity : O(mn).
    // Space complexity : O(n).
    public int maximalSquareSpaceOptimised(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
