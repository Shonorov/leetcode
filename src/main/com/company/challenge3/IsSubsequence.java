package com.company.challenge3;

/**
 * Is Subsequence
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see
 * if T has its subsequence. In this scenario, how would you change your code?
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * Both strings consists only of lowercase characters.
 *
 * Algorithm:
 * For each symbol in s find its index in t starting from previous symbol index + 1.
 * If index < 0, s is not subsequence of t.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence app = new IsSubsequence();
        System.out.println(app.isSubsequence("abc","ahbgdc")); // true
        System.out.println(app.isSubsequence("axc","ahbgdc")); // false
        System.out.println(app.isSubsequence("abc","abc")); // true
    }

    private boolean isSubsequence(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index < 0) return false;
        }
        return true;
    }
}
