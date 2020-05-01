package com.company.array;

import java.util.*;

/**
 * Intersection of Two Arrays II
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 *
 * Note:
 *     Each element in the result should appear as many times as it shows in both arrays.
 *     The result can be in any order.
 *
 * Follow up:
 *     What if the given array is already sorted? How would you optimize your algorithm?
 *     What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * Explanation:
 * Hash first array to Map with number of occurances.
 * Traverse second and add element to result if Map contains same key.
 *
 * Time complexity : O(n + m).
 * Space complexity : O(n).
 */
public class IntersectionTwoArrays2 {

    public static void main(String[] args) {
        IntersectionTwoArrays2 app = new IntersectionTwoArrays2();
        int[] arrA = {1,2,2,1};
        int[] arrB = {2,2};
        int[] arrA2 = {4,9,5};
        int[] arrB2 = {9,4,9,8,4};
        app.print(app.intersect(arrA, arrB)); // [2,2]
        app.print(app.intersect(arrA2, arrB2)); // [4,9]
    }

    private int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> intersect = new ArrayList<>();
        for (int i : nums1) {
            if (result.containsKey(i)) {
                result.replace(i, result.get(i) + 1);
            } else {
                result.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (result.containsKey(i)) {
                intersect.add(i);
                if (result.get(i) > 1) {
                    result.replace(i, result.get(i) - 1);
                } else {
                    result.remove(i);
                }
            }
        }
        int[] arr = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) {
            arr[i] = intersect.get(i);
        }
        return arr;
    }

    private void print(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
}
