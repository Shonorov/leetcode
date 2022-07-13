package com.company.array;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * Explanation:
 * Store in the map max length fo each array entry.
 * int sum = leftLength + rightLength + 1;
 * Update leftmost and rightmost values on each iteration.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence app = new LongestConsecutiveSequence();
        assertEquals(4, app.longestConsecutive(new int[]{100,4,200,1,3,2}));
        assertEquals(9, app.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        assertEquals(0, app.longestConsecutive(new int[]{}));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> sequences = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            if (sequences.containsKey(num)) continue;

            int leftLength = sequences.getOrDefault(num - 1, 0);
            int rightLength = sequences.getOrDefault(num + 1, 0);

            int sum = leftLength + rightLength + 1;
            sequences.put(num, sum);
            maxLength = Math.max(maxLength, sum);

            if (leftLength > 0) sequences.put(num - leftLength, sum);
            if (rightLength > 0) sequences.put(num + rightLength, sum);
        }
        return maxLength;
    }
}
