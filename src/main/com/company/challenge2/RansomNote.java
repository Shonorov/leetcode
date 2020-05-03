package com.company.challenge2;

import java.util.*;

/**
 * Ransom Note
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * Explanation:
 * Create int[] letters array with character set size filled with 0. Travers note characters.
 * If magazine contains letter (index != -1) starting from letters[Character.getNumericValue(c)] - replace array starting index with current + 1;
 *
 * Time complexity : O(n).
 * Space complexity : O(m). m - character set size.
 */
public class RansomNote {

    public static void main(String[] args) {
        RansomNote app = new RansomNote();
        System.out.println(app.canConstruct("a", "b")); // false
        System.out.println(app.canConstruct("aa", "ab")); // false
        System.out.println(app.canConstruct("aa", "aab")); // true
    }

    private boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[64];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, letters[Character.getNumericValue(c)]);
            if (index == -1) {
                return false;
            }
            letters[Character.getNumericValue(c)] = index + 1;
        }
        return true;
    }

    private boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> magMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (magMap.containsKey(c)) {
                magMap.replace(c, magMap.get(c) + 1);
            } else {
                magMap.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (magMap.containsKey(c)) {
                if (magMap.get(c) == 1) {
                    magMap.remove(c);
                } else {
                    magMap.replace(c, magMap.get(c) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
