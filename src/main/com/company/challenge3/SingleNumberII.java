package com.company.challenge3;

import java.util.Arrays;

/**
 * Single Number II
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 *
 * Algorithm:
 * Sort array, traverse it and count same elements.
 * Return value if it is not the same as previous and its count < 3.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class SingleNumberII {

    public static void main(String[] args) {
        SingleNumberII app =new SingleNumberII();
        int[] test = {2,2,3,2};
        int[] test2 = {0,1,0,1,0,1,99};
        int[] test3 = {4};
        int[] test4 = {1,2,2,2};
        System.out.println(app.singleNumber(test)); // 3
        System.out.println(app.singleNumber(test2)); // 99
        System.out.println(app.singleNumber(test3)); // 4
        System.out.println(app.singleNumber(test4)); // 1
    }

    private int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int value = nums[0], count = 3;
        for (int num : nums) {
            if (count == 3) {
                value = num;
                count = 1;
            } else if (value == num) {
                count++;
            } else {
                break;
            }
        }
        return value;
    }

    private int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int value = nums[0], index = 0;
        while (true) {
            if (index + 3 <= nums.length - 1 && nums[index + 2] == value) {
                index += 3;
                value = nums[index];
            } else {
                return value;
            }
        }
    }
}
