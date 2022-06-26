package com.company.math;

/**
 * Power of Three
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/745/
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three, if there exists an integer x such that n == 3^x.
 *
 * Example 1:
 * Input: n = 27
 * Output: true
 *
 * Example 2:
 * Input: n = 0
 * Output: false
 *
 * Example 3:
 * Input: n = 9
 * Output: true
 *
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 *
 * Explanation:
 * Divide n by 3 checking division remaining is 0 until it is 1.
 *
 * Time complexity : O(log(n)).
 * Space complexity : O(1).
 */
public class PowerOfThree {

    public static void main(String[] args) {
        PowerOfThree app = new PowerOfThree();
        System.out.println(app.isPowerOfThree(27)); // true
        System.out.println(app.isPowerOfThree(-27)); // false
        System.out.println(app.isPowerOfThree(0)); // false
        System.out.println(app.isPowerOfThree(9)); // true
        System.out.println(app.isPowerOfThree(3)); // true
        System.out.println(app.isPowerOfThree(30)); // false
        System.out.println(app.isPowerOfThree(81)); // true
        System.out.println(app.isPowerOfThree(8)); // false
        System.out.println(app.isPowerOfThree(1)); // true
        System.out.println(app.isPowerOfThree(-1)); // false
        System.out.println(app.isPowerOfThree(-3)); // false
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThreeFast(int n) {
        return n > 0 && 1162261467 % n == 0; // 3^19 = 1162261467 (closest to Integer.MAX_VALUE)
    }
}
