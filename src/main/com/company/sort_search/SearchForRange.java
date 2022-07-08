package com.company.sort_search;

import static org.junit.Assert.assertArrayEquals;

/**
 * Search for a Range
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 *
 * Explanation:
 * Tree pointers: left, right, mid. Select array half on each step.
 * If nums[mid] < target go right+1, else left+1.
 * When target found, iterate to find start and end indexes.
 *
 * Time complexity : O(log(n)).
 * Space complexity : O(1).
 */
public class SearchForRange {

    public static void main(String[] args) {
        SearchForRange app = new SearchForRange();
        assertArrayEquals(new int[]{3,4}, app.searchRange(new int[]{5,7,7,8,8,10}, 8));
        assertArrayEquals(new int[]{-1,-1}, app.searchRange(new int[]{5,7,7,8,8,10}, 6));
        assertArrayEquals(new int[]{-1,-1}, app.searchRange(new int[]{}, 0));
        assertArrayEquals(new int[]{0,0}, app.searchRange(new int[]{1}, 1));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == target) left--;
                while (right < nums.length - 1 && nums[right + 1] == target) right++;
                return new int[]{left, right};
            }
        }
        return new int[]{-1,-1};
    }
}
