package com.company.graph;

/**
 * Number of Islands
 * https://leetcode.com/explore/featured/card/3'0'-day-leetcoding-challenge/53'0'/week-3/33'0'2/
 *
 *  Given a 2d grid map of '1'`s (land) and '0'`s (water), count the number of islands.
 *  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *  You may assume all four edges of the grid are all surrounded by water.
 *
 * Input:
 * '1''1''1''1''0'
 * '1''1''0''1''0'
 * '1''1''0''0''0'
 * '0''0''0''0''0'
 *
 * Output: '1'
 *
 * Input:
 * '1''1''0''0''0'
 * '1''1''0''0''0'
 * '0''0''1''0''0'
 * '0''0''0''1''1'
 *
 * Output: 3
 *
 * Explanation:
 * Traverse the matrix.
 * If cell is '1' increment count and mark as visited 'x' recursively all adjacent cells.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class NumberIslands {

    public static void main(String[] args) {
        NumberIslands app = new NumberIslands();
        char[][] test = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] test2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] test3 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(app.numIslands(test)); // 1
        System.out.println(app.numIslands(test2)); // 3
        System.out.println(app.numIslands(test3)); // 1

    }

    private int numIslands(char[][] grid) {
        if (grid==null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visitIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void visitIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'x';

        visitIsland(grid, i - 1, j);
        visitIsland(grid, i, j - 1);
        visitIsland(grid, i + 1, j);
        visitIsland(grid, i, j + 1);
    }
}
