package com.company.challenge2;

/**
 * Valid Perfect Square
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 14
 * Output: false
 *
 * Explanation:
 * Binary sqr value search for range a to num;
 * ALL start, end, mid and sqrt SHOULD BE LONG because of INT OVERFLOW!
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(1).
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        ValidPerfectSquare app = new ValidPerfectSquare();
        System.out.println(app.isPerfectSquare(16)); // true
        System.out.println(app.isPerfectSquare(14)); // false
        System.out.println(app.isPerfectSquare(1)); // true
        System.out.println(app.isPerfectSquare(2147483647)); // false
    }

    private boolean isPerfectSquare(int num) {
        long start = 1, end = num;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sqr = mid * mid;
            if (sqr == num) return true;
            if (sqr > num) {
                end = mid - 1;
            } else  {
                start = mid + 1;
            }
        }
        return false;
    }
}
