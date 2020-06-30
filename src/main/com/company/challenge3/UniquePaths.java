package com.company.challenge3;

/**
 * Unique Paths
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3375/
 *
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Constraints:
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 *
 * Algorithm:
 * Create dynamic programming matrix with top and left edge = 1.
 * Traverse matrix. Current element value is sum of top and left previous elements.
 *
 * Time complexity : O(m * n).
 * Space complexity : O(m * n).
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths app = new UniquePaths();
        System.out.println(app.uniquePaths(3, 2)); // 3
        System.out.println(app.uniquePaths(7, 3)); // 28
    }

    private int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                matrix[i][j] = (i == 0 || j == 0) ? 1 : matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
