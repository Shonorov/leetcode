package com.company.array;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 *
 * Time complextiy : O(n).
 * Space complexity : O(1).
 */
public class RemoveDuplicates {

    public static void main(String[]args) {
        RemoveDuplicates c1 = new RemoveDuplicates();
        int[] num1 = {1, 1, 2};
        int[] num2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(c1.removeDuplicates(num1)); //[1, 2, 2] 2
        System.out.println(c1.removeDuplicates(num2)); //[0, 1, 2, 3, 4, 2, 2, 3, 3, 4] 5
    }

    /**
     * Два указателя индекса: уникальные, внешний цикл.
     * Если значения не равны, увеличить первый и обновить значение.
     */
    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.print(Arrays.toString(nums));
        return i + 1;
    }
}

