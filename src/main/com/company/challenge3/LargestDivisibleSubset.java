package com.company.challenge3;

import com.company.array.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Largest Divisible Subset
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
 *
 * Given a set of distinct positive integers,
 * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 *
 * Example 2:
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 *
 * Algorithm:
 * Create Dynamic Programming arrays where max result elements count and result indexes in given array are stored.
 * Sort array ascending;
 * Traverse array and for each previous elements from current check if it meet the requirement.
 *
 * Test case example, () - requirements met here:
 * test = {1,2,3,4,5,6,7,8,9}
 * resLengths: [ 1 (2) 2 (3) 2 3 2 (4) 3 ], maxResLength: 4
 * resIndexes: [ -1 (0) 0 (1) 0 2 0 (3) 2 ], lastResIndex: 7
 * Result: [1,2,4,8]
 *
 * Time complexity : O(n ^ 2).
 * Space complexity : O(n * 2).
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset app = new LargestDivisibleSubset();
        int[] test = {1,2,3};
        int[] test2 = {1,2,4,8};
        int[] test3 = {};
        int[] test4 = {1};
        int[] test5 = {1,2,3,4,5,6,7,8,9};

        System.out.println(app.largestDivisibleSubset(test)); // [1,2] or [1,3]
        System.out.println(app.largestDivisibleSubset(test2)); // [1,2,4,8]
        System.out.println(app.largestDivisibleSubset(test3)); // []
        System.out.println(app.largestDivisibleSubset(test4)); // [1]
        System.out.println(app.largestDivisibleSubset(test5)); // [1,2,4,8]
    }

    private List<Integer> largestDivisibleSubset(int[] nums) {
        int[] resLengths = new int[nums.length];
        Arrays.fill(resLengths, 1);
        int[] resIndexes = new int[nums.length];
        Arrays.fill(resIndexes, -1);
        Arrays.sort(nums);
        int maxResLength = 0, lastResIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + resLengths[j] > resLengths[i]) {
                        resLengths[i] = resLengths[j] + 1;
                        resIndexes[i] = j;
                    }
                }
            }
            if (resLengths[i] > maxResLength) {
                maxResLength = resLengths[i];
                lastResIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
//        ArrayUtils.printArray(resLengths);
//        ArrayUtils.printArray(resIndexes);
//        System.out.println("maxResLength: " + maxResLength + " lastResIndex: " + lastResIndex);
        while (lastResIndex != -1) {
            result.add(nums[lastResIndex]);
            lastResIndex = resIndexes[lastResIndex];
        }
        return result;
    }
}
