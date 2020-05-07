package com.company.challenge2;

import java.util.HashSet;
import java.util.Set;

/**
 * Jewels and Stones
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
 *
 * You're given com.company.strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * Note:
 *     S and J will consist of letters and have length at most 50.
 *     The characters in J are distinct.
 *
 * Algorithm:
 * Add jewel types to set. Iterate stones and count jewels.
 *
 * Time complexity : O(n + m). m - jewels size.
 * Space complexity : O(m). m - jewels size.
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones app = new JewelsAndStones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println(app.numJewelsInStones(jewels, stones)); // 3
        System.out.println(app.numJewelsInStones(jewels2, stones2)); // 0
    }

    private int numJewelsInStones(String J, String S) {
        int result = 0;
        Set<Character> jewels = new HashSet<>();
        for (int j = 0; j < J.toCharArray().length; j++) {
            jewels.add(J.charAt(j));
        }
        for (int i = 0; i < S.toCharArray().length; i++) {
            if (jewels.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
