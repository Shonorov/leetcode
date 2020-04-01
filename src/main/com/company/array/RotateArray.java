package com.company.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Rotate Array
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Time complextiy : O(n).
 * Space complexity : O(1).
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] test2 = {-1 , -100, 3, 99};
        int k2 = 2;
        rotateArray.rotate(test1, k1);
        rotateArray.rotate(test2, k2);
    }

    private void rotate(int[] nums, int k) {
        k %= nums.length;
        Collections.rotate(Arrays.asList(nums), k);
//        int i = 0;
//        int temp;
//        do {
//            temp = nums[i];
//            nums[i + k] = nums[i];
//        } while (i != 0);
        System.out.println(Arrays.toString(nums));
    }
}
