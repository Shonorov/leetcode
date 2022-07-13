package com.company.sliding_window;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * Explanation:
 * Loop on string. Add to Map or array (faster) indexes of letters. Add pointer to substring start.
 * If array contains index for s.charAt(i), then move start further.
 * Add char index to the array on each iteration.
 *
 * Time complexity : O(n).
 * Space complexity : O(m). m - the size of the charset
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters app = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(app.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(app.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(app.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(app.lengthOfLongestSubstring(" ")); // 1
        System.out.println(app.lengthOfLongestSubstring("dvdf")); // 3
        System.out.println(app.lengthOfLongestSubstring("abcdbf")); // 4
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        Integer[] map = new Integer[128];
        for (int i = 0; i < n; i++) {
            if (map[s.charAt(i)] != null) {
                start = Math.max((map[s.charAt(i)] + 1), start);
            }
            maxLength = Math.max(maxLength, i - start + 1);
            map[s.charAt(i)] = i;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        Set<Character> subsequence = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (subsequence.contains(current)) {
                i = s.indexOf(current, i - subsequence.size()) + 1;
                subsequence = new HashSet<>(List.of(s.charAt(i)));
            } else {
                subsequence.add(current);
            }
            maxLength = Math.max(maxLength, subsequence.size());
        }
        return maxLength;
    }


}
