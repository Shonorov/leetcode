package com.company.challange;

/**
 * Search in Rotated Sorted Array
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3304/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Explanation:
 * Find array middle element and find which of subarray is sorted.
 * Compare middle element with target and search the next chosen subarray recursively.
 *
 * Time complexity : O(log(n)).
 * Space complexity : O(1).
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray app = new SearchRotatedSortedArray();
        int[] test = {4,5,6,7,0,1,2};
        int[] test2 = {4,5};
        int[] test3 = {4};
        int[] test4 = {1,3,5};
        int[] test5 = {4,5,6,7,8,1,2,3};
        int[] test6 = {2,3,4,5,6,7,8,9,1};
        System.out.println(app.search(test, 4)); // 0
        System.out.println(app.search(test, 3)); // -1
        System.out.println(app.search(test, 0)); // 4
        System.out.println(app.search(test, 1)); // 5
        System.out.println(app.search(test, 8)); // -1
        System.out.println(app.search(test2, 0)); // -1
        System.out.println(app.search(test2, 4)); // 0
        System.out.println(app.search(test3, 5)); // -1
        System.out.println(app.search(test3, 4)); // 0
        System.out.println(app.search(new int[0], 5)); // -1
        System.out.println(app.search(test4, 6)); // -1
        System.out.println(app.search(test5, 8)); // 4
        System.out.println(app.search(test6, 9)); // 7

        System.out.println(app.searchRecursive(test, 0, test.length - 1, 4)); // 0
        System.out.println(app.searchRecursive(test, 0, test.length - 1, 3)); // -1
        System.out.println(app.searchRecursive(test, 0, test.length - 1, 0)); // 4
        System.out.println(app.searchRecursive(test, 0, test.length - 1, 1)); // 5
        System.out.println(app.searchRecursive(test, 0, test.length - 1, 8)); // -1
        System.out.println(app.searchRecursive(test2, 0, test2.length - 1, 0)); // -1
        System.out.println(app.searchRecursive(test2, 0, test2.length - 1, 4)); // 0
        System.out.println(app.searchRecursive(test3, 0, test3.length - 1, 5)); // -1
        System.out.println(app.searchRecursive(test3, 0, test3.length - 1, 4)); // 0
        System.out.println(app.searchRecursive(new int[0], 0, 0, 5)); // -1
        System.out.println(app.searchRecursive(test4, 0, test4.length - 1, 6)); // -1
        System.out.println(app.searchRecursive(test5, 0, test5.length - 1, 8)); // 4
        System.out.println(app.searchRecursive(test6, 0, test6.length - 1, 9)); // 7
    }

    private int search(int[] nums, int target) {
        int start = 0, end = nums.length > 0 ? nums.length - 1 : 0, mid = 0, result = -1;

        if (nums.length == 0) {
            return result;
        }

        while (true) {
            mid = (end + start) / 2;

            if (target == nums[start]) {
                result = start;
                break;
            }

            if (target == nums[mid]) {
                result = mid;
                break;
            }

            if (target == nums[end]) {
                result = end;
                break;
            }

            if (end - start <= 2) {
                break;
            }

            if (nums[start] < nums[mid]) {
                if (target < nums[mid] && target > nums[start]) {
                    start++;
                    end = mid - 1;
                } else {
                    end--;
                    start = mid + 1;
                }
                continue;
            }

            if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target < nums[end]) {
                    end--;
                    start = mid + 1;
                } else {
                    start++;
                    end = mid - 1;
                }
            }
        }
        return result;
    }

    private int searchRecursive(int[] arr, int l, int h, int key)
    {
        if (l > h || arr.length == 0)
            return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid])
        {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return searchRecursive(arr, l, mid-1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return searchRecursive(arr, mid+1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return searchRecursive(arr, mid+1, h, key);

        return searchRecursive(arr, l, mid-1, key);
    }

}
