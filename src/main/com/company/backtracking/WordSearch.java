package com.company.backtracking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Word Search
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 * Explanation:
 * Traverse board until first letter found, then recursively backtrack all directions and mark visited cells with '*'.
 * Set cell original value on backtrack return.
 *
 * Time complexity : O(n * m).
 * Space complexity : O(1).
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch app = new WordSearch();
        assertTrue(app.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        assertTrue(app.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        assertFalse(app.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 ||
                board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        board[i][j] = '*';
        boolean result = backtrack(board, word, i + 1, j, index + 1) ||
                backtrack(board, word, i - 1, j, index + 1) ||
                backtrack(board, word, i, j + 1, index + 1) ||
                backtrack(board, word, i, j - 1, index + 1);
        board[i][j] = word.charAt(index);
        return result;
    }
}
