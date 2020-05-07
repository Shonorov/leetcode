package com.company.strings;

/**
 * Reverse Integer
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Explanation:
 * While input != 0 find mod 10 and add it to the (result * 10);
 * Math.multiplyExact() will throw ArithmeticException on integer overflow. Return 0 then.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger app = new ReverseInteger();
        System.out.println(app.reverse(123)); // 321
        System.out.println(app.reverse(-123)); // -321
        System.out.println(app.reverse(120)); // 21
        System.out.println(app.reverse(123456789)); // 987654321
        System.out.println(app.reverse(-123456789)); // -987654321
        System.out.println(app.reverse(1123456789)); // 0
    }

    private int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            try {
                result = Math.multiplyExact(result, 10) + temp;
            } catch (ArithmeticException e) {
                result = 0;
                break;
            }
            x = x / 10;
        }
        return result;
    }
}
