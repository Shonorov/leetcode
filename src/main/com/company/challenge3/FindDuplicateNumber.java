package com.company.challenge3;

import java.util.Arrays;

/**
 * Find the Duplicate Number
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n ^ 2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * Algorithm:
 * Create two pointers slow(tortoise) and fast(rabbit). Rabbit runs twice fast as tortoise.
 * Traverse array using value as index since there are only 1..n values. One time they will meet.
 * Move tortoise to the start and run them both again with normal speed.
 * They will meet at duplicated value.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        FindDuplicateNumber app = new FindDuplicateNumber();
        int[] test = {1,3,4,2,2};
        int[] test2 = {3,1,3,4,2};
        System.out.println(app.findDuplicate(test)); // 2
        System.out.println(app.findDuplicate(test2)); // 3
    }

    // O(n * log(n))
    private int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return nums[0];
    }

    // O(n)
    private int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int rabbit = nums[0];
        do {
            tortoise = nums[tortoise];
            rabbit = nums[nums[rabbit]];
        } while (tortoise != rabbit);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != rabbit) {
            tortoise = nums[tortoise];
            rabbit = nums[rabbit];
        }
        return rabbit;
    }
}
