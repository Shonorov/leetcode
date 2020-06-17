package com.company.challenge3;

import com.company.array.ArrayUtils;

/**
 * Surrounded Regions
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * Algorithm:
 * Mark each border 'O's and all connected 'O's as visited '#'.
 * Traverse matrix and mark visited '#' back to 'O' and other 'O's as 'X'.
 *
 * Time complexity : O(n * m).
 * Space complexity : O(1).
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions app = new SurroundedRegions();
        char[][] test = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        app.solve(test);
        ArrayUtils.printTwoDimCharArray(test);
    }

    private void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) return;
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }
        for (int i = 1; i < board.length - 1; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == '#' ? 'O' : 'X';
            }
        }
    }

    //mark all Os connected with border with #
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') return;
        board[i][j] = '#';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}
