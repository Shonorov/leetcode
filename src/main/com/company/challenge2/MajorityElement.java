package com.company.challenge2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Explanation:
 * Sort array and return middle element. Time complexity : O(n * log(n)).
 * Or create map of occurances and return key with > n / 2 occurrences. Time complexity : O(n).
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(n).
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement app = new MajorityElement();
        int[] test = {3,2,3};
        int[] test2 = {2,2,1,1,1,2,2};
        System.out.println(app.majorityElement(test)); // 3
        System.out.println(app.majorityElement(test2)); // 2
    }

    private int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    private int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                if (count > nums.length / 2) {
                    return num;
                }
                map.replace(num, count);
            } else {
                map.put(num, 1);
            }
        }
        return nums[0];
    }

}
