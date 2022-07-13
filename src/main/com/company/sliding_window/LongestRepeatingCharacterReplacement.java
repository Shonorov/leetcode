package com.company.sliding_window;

import static org.junit.Assert.assertEquals;

/**
 * Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 *
 * Explanation:
 * Create sliding window. Each step increment end pointer and increase letter count.
 * Get most used letter size inside the window.
 * If other letters count more than allowed, then narrow window from start.
 *
 * Time complexity : O(n).
 * Space complexity : O(m). m - letters count
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement app = new LongestRepeatingCharacterReplacement();
        assertEquals(4, app.characterReplacement("ABAB", 2));
        assertEquals(4, app.characterReplacement("AABABBA", 1));
        assertEquals(4, app.characterReplacement("ABBB", 1));
    }

    public int characterReplacement(String s, int k) {
        int start = 0;
        int longestReplacement = k;
        char[] chars = new char[128];
        int leadingCount = 0;
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            chars[current]++;
            leadingCount = Math.max(leadingCount, chars[current]);
            while ((end - start) + 1 - leadingCount > k) {
                chars[s.charAt(start)]--;
                start++;
            }
            longestReplacement = Math.max(longestReplacement, (end - start) + 1);
        }
        return longestReplacement;
    }
}
