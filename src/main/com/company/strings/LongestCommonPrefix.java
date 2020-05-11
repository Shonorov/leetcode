package com.company.strings;

/**
 * Longest Common Prefix
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 *
 * Explanation:
 * Get min length element. Perform binary search for that length:
 * - Check if all strings contain half of than range.
 * - Increase/decrease this range by half depending on check result.
 * Found middle index will be common prefix length.
 *
 * Time complexity : O(S * log(n)), where S is the sum of all characters in all strings.
 * Space complexity : O(1).
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix app = new LongestCommonPrefix();
        String[] test = {"flower","flow","flight"};
        String[] test2 = {"dog","racecar","car"};
        String[] test3 = {};
        String[] test4 = {"a"};
        String[] test5 = {""};
        String[] test6 = {"c", "c"};
        System.out.println(app.longestCommonPrefix(test)); // fl
        System.out.println(app.longestCommonPrefix(test2)); // ""
        System.out.println(app.longestCommonPrefix(test3)); // ""
        System.out.println(app.longestCommonPrefix(test4)); // "a"
        System.out.println(app.longestCommonPrefix(test5)); // ""
        System.out.println(app.longestCommonPrefix(test6)); // "c"
    }

    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int start = 1, end = minLength;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isCommon(strs, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return strs[0].substring(0, (start + end) / 2);
    }

    private boolean isCommon(String[] strs, int length) {
        String prefix = strs[0].substring(0, length);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) return false;
        }
        return true;
    }

    private String longestCommonPrefix2(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        if (minLength == 0 || minLength == Integer.MAX_VALUE) return "";
        String result = "";
        for (int i = 0; i < minLength; i++) {
            char current = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != current) {
                    return result;
                }
            }
            result += current;
        }
        return result;
    }
}
