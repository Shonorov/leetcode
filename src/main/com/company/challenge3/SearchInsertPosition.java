package com.company.challenge3;

import java.util.Arrays;

/**
 * Search Insert Position
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * Algorithm:
 * Array index binary search.
 * If target == nums[mid] return mid, else return start (lowest) pointer.
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(1).
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition app = new SearchInsertPosition();
        int[] test = {1,3,5,6};
        System.out.println(app.searchInsert(test, 5)); // 2
        System.out.println(app.searchInsert(test, 2)); // 1
        System.out.println(app.searchInsert(test, 7)); // 4
        System.out.println(app.searchInsert(test, 0)); // 0
    }

    private int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (end + (end - start)) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int searchInsert2(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        return result > 0 ? result : -result - 1;
    }
}
