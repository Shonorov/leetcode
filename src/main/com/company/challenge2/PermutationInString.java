package com.company.challenge2;

/**
 * Permutation in String
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 *
 * Hints:
 * Obviously, brute force will result in TLE. Think of something else.
 * How will you check whether one string is a permutation of another string?
 * One way is to sort the string and then compare. But, Is there a better way?
 * If one string is a permutation of another string then they must one common metric. What is that?
 * Both strings must have same character frequencies, if one is permutation of another. Which data structure should be used to store frequencies?
 * What about hash table? An array of size 26?
 *
 * Algorithm:
 * Create char frequency array for pattern.
 * Move sliding window end (swEnd) to the pattern size and decrement count (pattern size at start) and swEnd index char count.
 * Char count not from pattern will be negative.
 * When count == 0 and swEnd - i == pattern length add sliding window start (swStart) to result.
 * I char at swStart >= 0 (is pattern symbol) increment count.
 * Increment char at swStart at every step.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString app = new PermutationInString();
        System.out.println(app.checkInclusion("ab", "eidbaooo")); // True
        System.out.println(app.checkInclusion("ab", "eidboaoo")); // False
    }

    private boolean checkInclusion(String s1, String s2) {
        int[] anagram = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            anagram[s1.charAt(i) - 'a']++;
        }
        int swEnd = 0, count = s1.length();
        for (int swStart = 0; swStart < s2.length() ; swStart++) {
            while (swEnd < s2.length() && swEnd - swStart < s1.length()) {
                if (anagram[s2.charAt(swEnd++) - 'a']-- > 0) {
                    count--;
                }
            }
            if (count == 0 && swEnd - swStart == s1.length() ) {
                return true;
            }
            if (anagram[s2.charAt(swStart) - 'a']++ >= 0) count++;
        }
        return false;
    }
}
