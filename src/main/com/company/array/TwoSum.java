package com.company.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/546/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Hint #1
 * A really brute force way would be to search for all possible pairs of numbers but that would be too slow.
 * Again, it's best to try out brute force solutions for just for completeness.
 * It is from these brute force solutions that you can come up with optimizations.
 *
 * Hint #2
 * So, if we fix one of the numbers, say
 * x , we have to scan the entire array to find the next number
 * y which is value - x
 * where value is the input parameter. Can we change our array somehow so that this search becomes faster?
 *
 * Hint #3
 * The second train of thought is, without changing the array, can we use additional space somehow?
 * Like maybe a hash map to speed up the search?
 *
 * Algorithm:
 * Store array values as Map<value, index>.
 * Calculate difference between target and current element.
 * If map contains such key - result found.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum app = new TwoSum();
        int[] test = {2,7,11,15};
        ArrayUtils.printArray(app.twoSum(test, 9)); // [0, 1]
    }

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (elements.containsKey(diff)) {
                return new int[] {elements.get(diff), i};
            }
            elements.put(nums[i], i);
        }
        return new int[0];
    }
}
