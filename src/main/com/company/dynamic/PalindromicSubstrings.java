package com.company.dynamic;

import static org.junit.Assert.assertEquals;

/**
 * Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 * Explanation:
 * Iterate each letter and expand around (i,i) and (i,i+1) while letters are the same.
 * Each expansion is plus to palindrome count.
 *
 * Time complexity : O(n ^ 2).
 * Space complexity : O(n).
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings app = new PalindromicSubstrings();
        assertEquals(3, app.countSubstrings("abc"));
        assertEquals(6, app.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            result += expandAndCount(chars, i, i);
            result += expandAndCount(chars, i, i + 1);
        }
        return result;
    }

    private int expandAndCount(char[] chars, int left, int right) {
        int result = 0;
        while (left >= 0 && right <= chars.length - 1 && chars[left] == chars[right]) {
            left--;
            right++;
            result++;
        }
        return result;
    }
}
