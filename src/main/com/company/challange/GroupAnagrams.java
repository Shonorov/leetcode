package com.company.challange;

import java.util.*;

/**
 * Group Anagrams
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3288/
 *
 * Given an array of strings, group anagrams together.
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Explanation:
 * We assume only 26 alphabet characters used.
 * String keys in Map<String, List<String>> ans represent number of character occurrences.
 * #1#2#3..#0
 *
 * Time complexity : O(n*k). Where k = max word length.
 * Space complexity : O(n*k). Where k = max word length.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> group : groupAnagrams.groupAnagrams(test)) {
            for (String s : group) {
                System.out.print(s + " ");
            }
            System.out.println("");
        }
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

}
