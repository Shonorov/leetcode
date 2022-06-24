package com.company.sort_search;

import static com.company.array.ArrayUtils.printArray;

/**
 * Merge Sorted Array
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 *
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 *
 * Explanation:
 * The key to solve this problem is moving element of nums1[] and nums2[] backwards.
 * If nums2[] has some elements left after nums1[] is done, also need to handle that case.
 *
 * Time complexity : O(m + n).
 * Space complexity : O(1).
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray app = new MergeSortedArray();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        app.merge(nums1, 3, new int[]{2,5,6}, 3);
        int[] nums2 = new int[]{1};
        app.merge(nums2, 1, new int[]{}, 0);
        int[] nums3 = new int[]{0};
        app.merge(nums3, 0, new int[]{1}, 1);
        int[] nums4 = new int[]{4,5,6,0,0,0};
        app.merge(nums4, 3, new int[]{1,2,3}, 3);
        printArray(nums1); // [1,2,2,3,5,6]
        printArray(nums2); // [1]
        printArray(nums3); // [1]
        printArray(nums4); // [1,2,3,4,5,6]

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (y < 0 || (x >= 0 && nums1[x] > nums2[y])) {
                nums1[i] = nums1[x--];
            } else {
                nums1[i] = nums2[y--];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j]))
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }
}
