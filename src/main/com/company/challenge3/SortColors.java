package com.company.challenge3;

import com.company.array.ArrayUtils;
/**
 * Sort Colors
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * Algorithm:
 * Create two pointers - last zero index and first two index.
 * Traverse array and swap corresponding values for corresponding indexes.
 * Change indexes on swap.
 * For first two index perform second check and swap (i--);
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors app = new SortColors();
        int[] test = {2,0,2,1,1,0};
        int[] test2 = {0,0,1,1,1,0};
        int[] test3 = {};
        int[] test4 = {1, 2, 0};
        app.sortColors(test);
        app.sortColors(test2);
        app.sortColors(test3);
        app.sortColors(test4);
        ArrayUtils.printArray(test); // [ 0 0 1 1 2 2 ]
        ArrayUtils.printArray(test2); // [ 0 0 0 1 1 1 ]
        ArrayUtils.printArray(test3); // []
        ArrayUtils.printArray(test4); // [ 0 1 2 ]
    }

    private void sortColors(int[] nums) {
        int zeroIndex = 0, twoIndex = nums.length - 1;
        for (int i = 0; i <= twoIndex; i++) {
            if (nums[i] == 0) {
                swap(nums, i, zeroIndex);
                zeroIndex++;
            }
            if (nums[i] == 2) {
                swap(nums, i, twoIndex);
                twoIndex--;
                i--;
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;
    }
}
