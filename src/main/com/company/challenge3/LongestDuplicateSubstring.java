package com.company.challenge3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Longest Duplicate Substring
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3365/
 *
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
 * (The occurrences may overlap.)
 * Return any duplicated substring that has the longest possible length.
 * (If S does not have a duplicated substring, the answer is "".)
 *
 * Example 1:
 * Input: "banana"
 * Output: "ana"
 *
 * Example 2:
 * Input: "abcd"
 * Output: ""
 *
 * Note:
 * 2 <= S.length <= 10^5
 * S consists of lowercase English letters.
 *
 * Hint:
 * Binary search for the length of the answer. (If there's an answer of length 10, then there are answers of length 9, 8, 7, ...)
 * To check whether an answer of length K exists, we can use Rabin-Karp's algorithm.
 *
 * Algorithm:
 * Perform binary search of the string parts for duplicate index.
 * If part is duplicated check larger part.
 * Check is performed by computing pattern hash and adding it to the Map with staring index.
 * Generate hash for all substrings same length by removing first symbol hash and adding next symbol hash to previous hash value.
 * If same hash exists in the Map, compare substrings from given indexes.
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(1).
 */
public class LongestDuplicateSubstring {

    public static void main(String[] args) {
        LongestDuplicateSubstring app = new LongestDuplicateSubstring();
        System.out.println(app.longestDupSubstring("banana")); // ana
        System.out.println(app.longestDupSubstring("abcd")); //
    }

    private int mod = 1 << 30;

    private String longestDupSubstring(String S) {
        int start = 1;
        int end = S.length() - 1;
        int hashKey = 26 % mod; // 26 is alphabet size
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int startIndex = search(S, mid, hashKey);
            if (startIndex == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int startIndex = search(S, end, hashKey);
        return startIndex == -1 ? "" : S.substring(startIndex, startIndex + end);
    }

    public int search(String S, int index, int hashKey) {
        long hash = 0;
        long leadSymbolMultiplier = 1;
        for (int i = 0; i < index; i++) {
            hash = (hash * hashKey + S.charAt(i)) % mod;
            leadSymbolMultiplier = leadSymbolMultiplier * hashKey;
        }
        Map<Long, List<Integer>> visited = new HashMap<>();
        visited.put(hash, new ArrayList<>());
        visited.get(hash).add(0);
        for (int i = 1; i < S.length() - index + 1; i++) {
            hash = ((hash * hashKey                                              // from previous hash
                    - S.charAt(i - 1) * leadSymbolMultiplier % mod + mod) % mod  // remove first letter hash
                    + S.charAt(i + index - 1)) % mod;                            // add next letter hash
            if (visited.containsKey(hash)) {                                     // check if new cache exists
                for (int start : visited.get(hash)) {                            // accept its the same string
                    if (S.substring(start, start + index).equals(S.substring(i, i + index))) return i;
                }
            } else {
                visited.put(hash, new ArrayList<>());
            }
            visited.get(hash).add(i);
        }
        return -1;
    }
}
