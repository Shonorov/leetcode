package com.company.sliding_window;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 * Explanation:
 * Create dictionary of t and empty one for current string characters.
 * Iterate with sliding window.
 * While current count contains required, calculate min size and move left pointer.
 *
 * Time complexity : O(n + m).
 * Space complexity : O(n + m).
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring app = new MinimumWindowSubstring();
        assertEquals("BANC", app.minWindow("ADOBECODEBANC","ABC"));
        assertEquals("a", app.minWindow("a","a"));
        assertEquals("", app.minWindow("a","aa"));
        assertEquals("", app.minWindow("a","b"));
        assertEquals("abbbbbcdd", app.minWindow("aaaaaaaaaaaabbbbbcdd","abcdd")); // 0..19
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        prepareMaps(required, count, t);

        int start = 0;
        int resultStart = 0;
        int resultEnd = s.length();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (required.containsKey(current)) {
                count.put(current, count.get(current) + 1);
            }
            while (containsAll(required, count) && start <= i) {
                if ((i - start) < (resultEnd - resultStart)) {
                    resultStart = start;
                    resultEnd = i;
                }
                char first = s.charAt(start);
                if (count.containsKey(first)) {
                    count.put(first, count.get(first) - 1);
                }
                start++;
            }
        }
        return resultEnd < s.length() ? s.substring(resultStart, resultEnd + 1) : "";
    }

    private void prepareMaps(Map<Character, Integer> required, Map<Character, Integer> count, String t) {
        for (char character : t.toCharArray()) {
            if (required.containsKey(character)) {
                required.put(character, required.get(character) + 1);
            } else {
                required.put(character, 1);
                count.put(character, 0);
            }
        }
    }

    private boolean containsAll(Map<Character, Integer> required, Map<Character, Integer> count) {
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
           if (!required.containsKey(entry.getKey()) || entry.getValue() < required.get(entry.getKey())) {
               return false;
           }
        }
        return true;
    }
}
