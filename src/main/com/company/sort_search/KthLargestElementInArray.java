package com.company.sort_search;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;

/**
 * Kth Largest Element in an Array
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 *
 * Explanation:
 * Assign pivot pointer and search pointer in array.
 * Iterate on array and swap elements lower than pivot.
 * Swap pivot with first element greater than pivot.
 * If kTh largest not same as pivot, narrow and repeat search.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class KthLargestElementInArray {

    public static void main(String[] args) {
        KthLargestElementInArray app = new KthLargestElementInArray();
        assertEquals(5, app.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        assertEquals(4, app.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        assertEquals(5, app.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return select(nums,0,nums.length - 1, nums.length - k);
    }

    public int select(int[] nums, int left, int right, int kthLargest) {
        int pivot = left + (right - left + 1)/2;
        int greaterThenPivot = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, greaterThenPivot, i);
                if (greaterThenPivot == pivot) {
                    pivot = i;
                }
                greaterThenPivot++;
            }
        }
        swap(nums, greaterThenPivot, pivot);
        if (kthLargest < greaterThenPivot) {
            return select(nums, left, greaterThenPivot - 1, kthLargest);
        } else if (kthLargest > greaterThenPivot) {
            return select(nums, greaterThenPivot + 1, right, kthLargest);
        }
        return nums[greaterThenPivot];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int selectSlow(int[] nums, int left, int right, int kthLargest) {
        int pivot = right;
        int search = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, search, i);
                search++;
            }
        }
        swap(nums, search, pivot);
        if (kthLargest < search) {
            return select(nums, left, search - 1, kthLargest);
        } else if (kthLargest > search) {
            return select(nums, search + 1, right, kthLargest);
        }
        return nums[search];
    }

    public int findKthLargestEasy(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
