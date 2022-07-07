package com.company.sort_search;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertArrayEquals;

/**
 * Top K Frequent Elements
 * hhttps://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Explanation:
 * Create map of number occurrences. Create PriorityQueue with comparator based on that map values.
 * Add only k elements to PriorityQueue (remove first? when heap.size() > k).
 * PriorityQueue elements are answer.
 *
 * Time complexity : O(n*log(k)). k - array uniques.
 * Space complexity : O(n*log(k)).
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements app = new TopKFrequentElements();
        assertArrayEquals(new int[]{2,1}, app.topKFrequent(new int[]{1,1,1,2,2,3},2));
        assertArrayEquals(new int[]{1}, app.topKFrequent(new int[]{1},1));
        assertArrayEquals(new int[]{0}, app.topKFrequent(new int[]{3,0,1,0},1));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }

        Queue<Integer> heap = new PriorityQueue<>((a1, a2) -> count.get(a1) - count.get(a2));
        for (Integer key : count.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
