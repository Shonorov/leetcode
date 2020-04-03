package com.company.challange;

/**
 * Maximum Subarray
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Example:
 * [4,-1,2,1] has the largest sum = 6.
 *
 * Kadane algorithm:
 * For every index in array from start to end get max of (curr_max + nums[i], nums[i])
 * Then get max of that result and global max.
 *
 * Time complextiy : O(n).
 * Space complexity : O(0).
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] test2 = {-1};
        System.out.println(maximumSubarray.maxSubArray(test)); //6
        System.out.println(maximumSubarray.maxSubArray(test2)); //-1

        System.out.println(maximumSubarray.bruteForce(test)); //6
        System.out.println(maximumSubarray.bruteForce(test2)); //-1
    }

    /**
     * Kadane`s algorithm
     * Time complextiy : O(n).
     */
    private int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            curr_max = Math.max(curr_max + nums[i], nums[i]);
            max = Math.max(max, curr_max);
        }
        return max;
    }

    /**
     * Brute force all possible arrays and find max sum of then.
     * Time complextiy : O(n^2).
     */
    private int bruteForce(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(arraySum(nums, i, j), max);
            }
        }
        return max;
    }

    private int arraySum(int[] arr, int start, int end) {
        int sum = arr[start];
        for (int i = start + 1; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
