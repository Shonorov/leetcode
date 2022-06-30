package com.company.array;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Increasing Triplet Subsequence
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/
 *
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 *
 * Example 2:
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 * Example 3:
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 * Constraints:
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * Explanation:
 * Iterate on array and find two minimum values.
 * If next num is higher them both of minimums, then triplet found.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class IncreasingTripletSubsequence {


    public static void main(String[] args) {
        IncreasingTripletSubsequence app = new IncreasingTripletSubsequence();
        assertTrue(app.increasingTriplet(new int[]{1,2,3,4,5}));
        assertFalse(app.increasingTriplet(new int[]{5,4,3,2,1}));
        assertTrue(app.increasingTriplet(new int[]{2,1,5,0,4,6}));
        assertFalse(app.increasingTriplet(new int[]{1,2}));
        assertFalse(app.increasingTriplet(new int[]{2}));
        assertFalse(app.increasingTriplet(new int[]{3,2,1}));
        assertTrue(app.increasingTriplet(new int[]{20,100,10,12,5,13}));
        assertTrue(app.increasingTriplet(new int[]{4,5,2147483647,1,2}));
    }

    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) {
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
