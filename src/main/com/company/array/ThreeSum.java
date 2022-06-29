package com.company.array;

import java.util.*;

/**
 * 3Sum
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 * Constraints:
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * Explanation:
 * Sort array to avoid duplicates.
 * Add 3 pointers: outer and 2 inner. Inner pointers move to each other.
 * If sum == 0, add to result, else if sum < 0 move left++, sum < 0 move left++.
 *
 * Time complexity : O(n^2 * log(n)).
 * Space complexity : O(1).
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum app = new ThreeSum();
        System.out.println(app.threeSum(new int[]{-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(app.threeSum(new int[]{})); // []
        System.out.println(app.threeSum(new int[]{0})); // []
        System.out.println(app.threeSum(new int[]{1,-1,-1,0})); // [[-1,0,1]]
        System.out.println(app.threeSum(new int[]{-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int search = -(nums[i] + nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
                    if (search == nums[k]) {
                        List<Integer> sum = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        if (!result.contains(sum)) {
                            result.add(List.of(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return result;
    }
}
