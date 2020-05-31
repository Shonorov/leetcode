package com.company.challenge2;

/**
 * Edit Distance
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * Algorithm:
 * Create dynamic programming matrix plus one word length sizes.
 * Fill first row and column with words char indexes [0,1..word.length + 1]
 * Traverse matrix.
 * If chars at both indexes the same - no modification required: dpMatrix[i][j] = dpMatrix[i - 1][j - 1].
 * Else - number of modifications so far is min of previous count values plus one.
 * Return matrix last cell value.
 *
 * Time complexity : O(m * n).
 * Space complexity : O(m * n).
 */
public class EditDistance {

    public static void main(String[] args) {
        EditDistance app = new EditDistance();
        System.out.println(app.minDistance("horse","ros")); // 3
        System.out.println(app.minDistance("intention","execution")); // 5
    }

    private int minDistance(String word1, String word2) {
        int width = word2.length(), height = word1.length();
        int[][] dpMatrix = new int[height + 1][width + 1];
        for (int i = 0; i <= height; i++) {
            dpMatrix[i][0] = i;
        }
        for (int j = 0; j <= width; j++) {
            dpMatrix[0][j] = j;
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j - 1];
                } else {
                    dpMatrix[i][j] = Math.min(dpMatrix[i - 1][j - 1], Math.min(dpMatrix[i - 1][j], dpMatrix[i][j - 1])) + 1;
                }
            }
        }
        return dpMatrix[height][width];
    }
}
