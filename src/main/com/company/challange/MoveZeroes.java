package com.company.challange;

/**
 * Move Zeroes
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Explanation:
 * Travers array increasing non null count. Set element at count as current.
 * Then fill array from count index with zeroes.
 *
 * Time complexity : O(n).
 * Space complexity : O(0).
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] test = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(test);
        for (int i : test) {
            System.out.print(i + " ");
        }
    }

    private void moveZeroes(int[] nums) {
        int count = 0;  // Count of non-zero elements
        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i]; // here count is incremented
            }
        }
        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }

    private void pushZerosToEnd(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
