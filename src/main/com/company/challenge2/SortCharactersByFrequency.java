package com.company.challenge2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Sort Characters By Frequency
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * Algorithm:
 * Create char frequency map.
 * Add char values to PriorityQueue descending map character count.
 * Remove characters from Queue, decrease count in the map and append char to StringBuilder.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        SortCharactersByFrequency app = new SortCharactersByFrequency();
        System.out.println(app.frequencySort("tree")); // eert
        System.out.println(app.frequencySort("cccaaa")); // cccaaa
        System.out.println(app.frequencySort("Aabb")); // bbAa
    }

    private String frequencySort(String s) {
        int[] characters = new int[256];
        for (int i = 0; i < s.length(); i++) {
            characters[s.charAt(i)]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> characters[j] - characters[i]);
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == 0) {
                continue;
            }
            queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            while (characters[i]-- > 0) sb.append((char)i);
        }
        return sb.toString();
    }

    private String frequencySort2(String s) {
        Map<Character, Integer> characters = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!characters.containsKey(s.charAt(i))) {
                characters.put(s.charAt(i), 1);
            } else {
                characters.replace(s.charAt(i), characters.get(s.charAt(i)) + 1);
            }
        }
        characters = characters.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));
        StringBuffer result = new StringBuffer();
        characters.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                result.append(key);
            }
        });
        return result.toString();
    }
}
