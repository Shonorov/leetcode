package com.company.challange;

import java.util.HashMap;

/**
 * Subarray Sum Equals K
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3307/
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * Constraints:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 * Hint: Will Brute force work here? Try to optimize it.
 * Hint: Can we optimize it by using some extra space?
 * Hint: What about storing sum frequencies in a hash table? Will it be useful?
 * Hint: sum(i,j) = sum(0,j) - sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
 *       Can we use this property to optimize it.
 *
 * Explanation:
 * Traverse array and calculate sum. Put sum into the Map<Sum, Sum of occurrences>.
 * If map contains element with key (sum - k), that means there are occurrences count of subarrays with sum k before this point.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        SubarraySumEqualsK app = new SubarraySumEqualsK();
        int[] test = {1,1,1};
        System.out.println(app.subarraySum(test, 2)); // 2
    }

    private int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
