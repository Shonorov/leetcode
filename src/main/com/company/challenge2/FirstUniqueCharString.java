package com.company.challenge2;

/**
 * First Unique Character in a String
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 * Explanation:
 * Crete map for each character containing index in string and number or occurrences.
 * Traverse map and find min index, where is one occurrence.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class FirstUniqueCharString {

    public static void main(String[] args) {
        FirstUniqueCharString app = new FirstUniqueCharString();
        System.out.println(app.firstUniqChar("leetcode")); // 0
        System.out.println(app.firstUniqChar("loveleetcode")); // 2
        System.out.println(app.firstUniqChar("aabbcc")); // -1
        System.out.println(app.firstUniqChar("aabbc")); // 4
    }

    private int firstUniqChar(String s) {
        int[][] map = new int[128][2];
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i);
            map[temp][0] = i;
            if (map[temp][1] >= 1) {
                map[temp][1]++;
            } else {
                map[temp][1] = 1;
            }
        }
        int first = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (map[i][1] == 1) {
                first = Math.min(first, map[i][0]);
            }
        }
        return first < Integer.MAX_VALUE ? first : -1;
    }

    private int firstUniqChar2(String s) {
        int[] notUnique = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i);
            if (s.indexOf(charIndex, i + 1) == -1 && notUnique[charIndex] == 0) {
                return i;
            } else {
                notUnique[charIndex]++;
            }
        }
        return -1;
    }
}
