package com.company.dynamic;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 *
 * Example 2:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 3
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * Explanation:
 * Rob two sub arrays without first or last element. (watch HouseRobber solution)
 * Maximum of them is the answer.
 *
 * Time complexity : O(2 * n).
 * Space complexity : O(n).
 */
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII app = new HouseRobberII();
        assertEquals(3, app.rob(new int[]{2,3,2}));
        assertEquals(4, app.rob(new int[]{1,2,3,1}));
        assertEquals(3, app.rob(new int[]{1,2,3}));
        assertEquals(11, app.rob(new int[]{2,7,9,3,1}));
        assertEquals(103, app.rob(new int[]{1,3,1,3,100}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robPart(nums, 0, nums.length - 1), robPart(nums, 1, nums.length));
    }

    public int robPart(int[] nums, int start, int end) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        for (int i = start + 1; i < end; i++) {
            if (i == start + 1) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
            }
        }
        return dp[end - 1];
    }
}
