package com.company.challange;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiguous Array
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 *
 * Explanation:
 * Traverse the array. We subtract 1 if meet ZERO and add 1 if we meet ONE.
 * Then we add this count to the map with index as value.
 * If same count exist on the map, then length between those element indexes is contiguous subarray with equal number of 0 and 1.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray app = new ContiguousArray();
        int[] test = {0, 1};
        int[] test2 = {0, 1, 0};
        int[] test3 = {0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println(app.findMaxLength(test)); // 2
        System.out.println(app.findMaxLength(test2)); // 2
        System.out.println(app.findMaxLength(test3)); // 6
    }

    private int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
