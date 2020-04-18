package com.company.challange;

/**
 * Minimum Path Sum
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3303/
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Explanation:
 * Generate matrix of the same size with minimum costs of path to the corresponding cell.
 *
 * Time complexity : O(m * n).
 * Space complexity : O(m * n).
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum app = new MinimumPathSum();
        int[][] test = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] test2 = {{1, 2, 5}, {3, 2, 1}};
        System.out.println(app.minPathSum(test)); // 7
        System.out.println(app.minPathSum(test2)); // 6

    }

    private int minPathSum(int[][] grid) {
        int i, j;
        int targetX = grid.length - 1;
        int targetY = grid[0].length - 1;
        int[][] tc = new int[grid.length][grid[0].length];

        tc[0][0] = grid[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= targetX; i++)
            tc[i][0] = tc[i - 1][0] + grid[i][0];

        /* Initialize first row of tc array */
        for (j = 1; j <= targetY; j++)
            tc[0][j] = tc[0][j - 1] + grid[0][j];


        /* Construct rest of the tc array */
        for (i = 1; i <= targetX; i++)
            for (j = 1; j <= targetY; j++)
                tc[i][j] = Math.min(tc[i - 1][j], tc[i][j - 1]) + grid[i][j];
        print(tc);

        return tc[targetX][targetY];
    }

    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
