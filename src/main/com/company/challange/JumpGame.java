package com.company.challange;

/**
 * Jump Game
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3310/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 * Explanation:
 * Recursively check if we can reach end from every index in range from current position.
 * Traverse range elements from end.
 * If max jump of range element lower than step max length - skip check.
 *
 * Time complexity : O(n).
 * Space complexity : O(0).
 */
public class JumpGame {

    public static void main(String[] args) {
        JumpGame app = new JumpGame();
        int[] test = {2,3,1,1,4};
        int[] test2 = {3,2,1,0,4};
        int[] test3 = {0};
        System.out.println(app.canJump(test)); // true
        System.out.println(app.canJump(test2)); // false
        System.out.println(app.canJump(test3)); // true

    }

    private boolean canJump(int[] nums) {
        return canFinish(nums, 0);
    }

    private boolean canFinish(int[] arr, int start) {
        int end = arr[start] + start;
        if (end >= arr.length - 1) {
            return true;
        }
        for (int i = end; i > start; i--) {
            if (arr[i] + i > end && canFinish(arr, i)) {
                return true;
            }
        }
        return false;
    }
}
