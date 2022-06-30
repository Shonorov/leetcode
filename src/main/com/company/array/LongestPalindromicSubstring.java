package com.company.array;

/**
 * Longest Palindromic Substring
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * Explanation:
 * Iterate on string and get palindrome lengths for both possible palindromes (for odd "aba" and even "abba").
 * Update max length between existing and two calculated previously.
 *
 * Time complexity : O(n^2).
 * Space complexity : O(1).
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring app = new LongestPalindromicSubstring();
        System.out.println(app.longestPalindrome("babad")); // bab/aba
        System.out.println(app.longestPalindrome("cbbd")); // bb
        System.out.println(app.longestPalindrome("")); // ""
        System.out.println(app.longestPalindrome("a")); // "a"
        System.out.println(app.longestPalindrome("abc")); // c/b
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome2(String s) {
        if (s.length() == 1) return s;
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String palindrome1 = getPalindrome(s, i, i);
            String palindrome2 = getPalindrome(s, i, i + 1);
            String longest = palindrome1.length() > palindrome2.length() ? palindrome1 : palindrome2;
            result = result.length() > longest.length() ? result : longest;
        }
        return result;
    }

    private String getPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

}
