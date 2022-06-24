package com.company.dynamic;

/**
 * Climbing Stairs
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 * 1 <= n <= 45
 *
 * Explanation:
 * Current n steps count = stepsCount(n - 1) + stepsCount(n - 2).
 * Аdd values to DP array recursively. Return last element.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs app = new ClimbingStairs();
        System.out.println(app.climbStairs(2)); // 2
        System.out.println(app.climbStairs(3)); // 3
    }

    public int climbStairs(int n) {
        Integer[] result = new Integer[n + 1];
        fib(n, result);
        return result[n];
    }

    private int fib(int n, Integer[] dp) {
        if (n <= 1) {
            dp[n] = 1;
            return dp[n];
        }

        if (dp[n] != null) {
            return dp[n];
        }
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

}
