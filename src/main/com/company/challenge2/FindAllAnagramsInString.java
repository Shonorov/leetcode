package com.company.challenge2;

import java.util.*;

/**
 * Find All Anagrams in a String
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
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
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        FindAllAnagramsInString app = new FindAllAnagramsInString();
        System.out.println(app.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(app.findAnagrams("abab", "ab")); // [0, 1, 2]
        System.out.println(app.findAnagrams("abaacbabc", "abc")); // [3, 4, 6]
        System.out.println(app.findAnagrams("aaaacbaaa", "aaac")); // [1]
    }

    private List<Integer> findAnagrams(String s, String p) {
        int[] anagram = new int[26];
        for (int i = 0; i < p.length(); i++) {
            anagram[p.charAt(i) - 'a']++;
        }
        int swEnd = 0;
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        for (int swStart = 0; swStart < s.length(); swStart++) {
            while (swEnd < s.length() && swEnd - swStart < p.length()) {
                if (anagram[s.charAt(swEnd++) - 'a']-- > 0) {
                    count--;
                }
            }
            if (count == 0 && swEnd - swStart == p.length()) result.add(swStart);
            if (anagram[s.charAt(swStart) - 'a']++ >= 0) count++;
        }
        return result;
    }

    private List<Integer> findAnagrams2(String s, String p) {
        int[] anagram = new int[26];
        for (char c : p.toCharArray()) {
            anagram[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (anagram[s.charAt(i) - 'a'] > 0 && containsAnagram(s, i, anagram, p.length())) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean containsAnagram(String str, int index, int[] map, int anagramSize) {
        int[] anagram = Arrays.copyOf(map, map.length);
        if (str.length() - index < anagramSize) return false;
        for (int i = index; i < index + anagramSize; i++) {
            if (anagram[str.charAt(i) - 'a'] > 0) {
                anagram[str.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
