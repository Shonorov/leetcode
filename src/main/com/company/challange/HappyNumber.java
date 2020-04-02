package com.company.challange;

import java.util.HashSet;

/**
 * Happy Number
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Input: 19
 * Output: true
 * Example:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * Explanation:
 * A number will not be a Happy Number when it makes a loop in its sequence that is it touches a number in sequence which already been touched.
 *
 * Time complextiy : O(n).
 * Space complexity : O(0).
 */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println("19: " + happyNumber.isHappy(19)); // true
        System.out.println("20: " + happyNumber.isHappy(20)); // false
        System.out.println("-------------------");
        System.out.println("19: " + happyNumber.isHappySetMethod(19)); // true
        System.out.println("20: " + happyNumber.isHappySetMethod(20)); // false
    }

    /**
     *  Fast moves twice faster than slow. One time they will meet.
     *  Zero space required.
     */
    private boolean isHappy(int n) {
        int slow, fast;

        //  initialize slow and fast by n
        slow = fast = n;
        do
        {
            // move slow number
            // by one iteration
            slow = numSquareSum(slow);

            // move fast number
            // by two iteration
            fast = numSquareSum(numSquareSum(fast));
            System.out.println("Slow: " + slow + " Fast: " + fast);
        }
        while (slow != fast);

        //  if both number meet at 1,
        // then return true
        return (slow == 1);
    }

    /**
     *  Check number == 1.
     *  If set not contains number - add numbers to set.
     *  Otherwise it is not happy.
     */
    private boolean isHappySetMethod(int n) {
        HashSet<Integer> numbers = new HashSet<>();

        while (true) {
            n = numSquareSum(n);
            if (n == 1) {
                return true;
            }
            if (numbers.contains(n)) {
                return false;
            } else {
                numbers.add(n);
            }
        }
    }

    // Utility method to return sum of square of digit of n
    private int numSquareSum(int n) {
        int squareSum = 0;
        while (n!= 0)
        {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }
}
