package com.company.challenge3;

/**
 * Power of Two
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 2 ^ 0 = 1
 *
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 2 ^ 4 = 16
 *
 * Example 3:
 * Input: 218
 * Output: false
 *
 * Algorithm:
 * All power of two numbers most significant bit followed by zeroes. I.e. 4 = 100 and 16 = 10000.
 * If we subtract 1 then all unset bits become set.                  I.e. 3 = 011 and 16 = 01111.
 * In that case n & (n - 1) (bitwise and) == 0 except when n is zero.
 *
 * Time complexity : O(1).
 * Space complexity : O(1).
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo app = new PowerOfTwo();
        System.out.println(app.isPowerOfTwo(1)); // true
        System.out.println(app.isPowerOfTwo(16)); // true
        System.out.println(app.isPowerOfTwo(218)); // false
        System.out.println(app.isPowerOfTwo(0)); // false
        System.out.println(app.isPowerOfTwo(Integer.MIN_VALUE)); // false
    }

    private boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    private boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        return Integer.bitCount(n) == 1;
    }
}
