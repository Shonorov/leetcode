package com.company.strings;

/**
 * Implement strStr()
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 *
 * Explanation:
 * Traverse haystack, when first element of needle found increment needle index.
 * Return value at the end of needle.
 * If match sequence ended, start from i - j + 1;
 *
 * Time complexity : O(n + m).
 * Space complexity : O(1).
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        ImplementStrStr app = new ImplementStrStr();
        System.out.println(app.strStr("hello", "ll")); // 2
        System.out.println(app.strStr("aaaaa", "bba")); // -1
        System.out.println(app.strStr("aaaaa", "")); // 0
        System.out.println(app.strStr("mississippi", "issip")); // 4
        System.out.println(app.strStr("ll", "ll")); // 0
        System.out.println(app.strStr("dl", "l")); // 1
        System.out.println(app.strStr("dlidla", "dla")); // 3
        System.out.println(app.strStr("mississippi", "pi")); // 9
        System.out.println(app.strStr("mississippi", "sipp")); // 6
    }

    private int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                j++;
            } else if (j > 0) {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}
