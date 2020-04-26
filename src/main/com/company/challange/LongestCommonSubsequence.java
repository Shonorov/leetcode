package com.company.challange;

/**
 * Longest Common Subsequence
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3311/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 * Constraints:
 *     1 <= text1.length <= 1000
 *     1 <= text2.length <= 1000
 *     The input strings consist of lowercase English characters only.
 *
 * Explanation:
 * Try dynamic programming.
 * Create matrix DP[text1.length() + 1][text2.length() + 1]
 * DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
 * If text1[i] == text2[j] then DP[i][j] = DP[i - 1][j - 1] + 1 , Else DP[i][j] = max(DP[i - 1][j], DP[i][j - 1])
 *
 * Time complexity : O(m * n).
 * Space complexity : O(m * n).
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence app = new LongestCommonSubsequence();
        String test = "abcde", text = "ace";
        String test2 = "abc", text2 = "abc";
        String test3 = "abc", text3 = "def";
        String test4 = "ezupkr", text4 = "ubmrapg";
        System.out.println(app.longestCommonSubsequence(test, text)); // 3
        System.out.println(app.longestCommonSubsequence(test2, text2)); // 3
        System.out.println(app.longestCommonSubsequence(test3, text3)); // 0
        System.out.println(app.longestCommonSubsequence(test4, text4)); // 2
    }

    private int longestCommonSubsequenceSpaceOptimized(String text1, String text2) {
        // Find lengths of two strings
        int m = text1.length(), n = text2.length();
        int[][] L = new int[2][n+1];
        // Binary index, used to index
        // current row and previous row.
        int bi = 0;
        for (int i = 0; i <= m; i++)
        {
            // Compute current binary index
            bi = i & 1;
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0) {
                    L[bi][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    L[bi][j] = L[1 - bi][j - 1] + 1;
                } else {
                    L[bi][j] = Math.max(L[1 - bi][j], L[bi][j - 1]);
                }
            }
        }
        print(L, text1, text2);
        // Last filled entry contains length of
        // LCS for X[0..n-1] and Y[0..m-1]
        return L[bi][n];
    }

    // Create matrix only for this and previous steps instead of all options
    // Time complexity : O(m * n).
    // Space complexity : O(n).
    private int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] L = new int[m + 1][n + 1];

         /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        print(L, text1, text2);
        // Last filled entry contains length of
        // LCS for X[0..n-1] and Y[0..m-1]
        return L[m][n];
    }

    private void print(int[][] L, String text1, String text2) {
        for (int i = 0; i < L.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < L[0].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == 0) {
                    System.out.print(text2.charAt(j - 1) + " ");
                } else if (j == 0) {
                    System.out.print(text1.charAt(i - 1) + " ");
                } else {
                    System.out.print(L[i][j] + " ");
                }
            }
            System.out.println("]");
        }
    }
}
