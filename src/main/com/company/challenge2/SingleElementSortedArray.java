package com.company.challenge2;

/**
 * Single Element in a Sorted Array
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 * Explanation:
 * Select array start and end;
 * Find mid (last of two) and count count from start. If even count from start then single item to the left.
 * When search length <= 3 - calculate and return result.
 *
 * Time complexity : O(log(n)).
 * Space complexity : O(1).
 */
public class SingleElementSortedArray {

    public static void main(String[] args) {
        SingleElementSortedArray app = new SingleElementSortedArray();
        int[] test = {1,1,2,3,3,4,4,8,8};
        int[] test2 = {3,3,7,7,10,11,11};
        int[] test3 = {3,3,7};
        int[] test4 = {3,7,7};
        int[] test5 = {5};
        int[] test6 = {1,1,2,2,3};
        int[] test7 = {0,1,1,2,2};

        System.out.println(app.singleNonDuplicate(test)); // 2
        System.out.println(app.singleNonDuplicate(test2)); // 10
        System.out.println(app.singleNonDuplicate(test3)); // 7
        System.out.println(app.singleNonDuplicate(test4)); // 3
        System.out.println(app.singleNonDuplicate(test5)); // 5
        System.out.println(app.singleNonDuplicate(test6)); // 3
        System.out.println(app.singleNonDuplicate(test7)); // 0
    }

    private int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start < end - 2) {
            mid = start + (end - start) / 2;
            mid = nums[mid + 1] == nums[mid] ? mid + 1 : mid;
            if ((mid - start) % 2 != 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start == end) return nums[start];
        return nums[start] == nums[start + 1] ? nums[end] : nums[start];
    }
}
