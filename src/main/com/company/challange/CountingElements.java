package com.company.challange;

import java.util.Map;
import java.util.TreeMap;

/**
 * Counting Elements
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
 *
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * If there're duplicates in arr, count them separately.
 *
 * Constraints:
 * 1 <= arr.length <= 1000
 * 0 <= arr[i] <= 1000
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 * Explanation:
 * Store all numbers in TreeMap where key is number and value number of occurances.
 * Loop for array of keys to get valid keys and sum values.
 *
 * Time complexity : O(n + m). Where m is the consequent numbers set length.
 * Space complexity : O(3 * m). Where m is the consequent numbers set length.
 */
public class CountingElements {

    public static void main(String[] args) {
        CountingElements countingElements = new CountingElements();
        int[] test1 = {1,2,3};
        int[] test2 = {1,1,3,3,5,5,7,7};
        int[] test3 = {1,3,2,3,5,0};
        int[] test4 = {1,1,2,2};
        System.out.println(countingElements.countElements(test1)); // 2
        System.out.println(countingElements.countElements(test2)); // 0
        System.out.println(countingElements.countElements(test3)); // 3
        System.out.println(countingElements.countElements(test4)); // 2

    }

    private int countElements(int[] arr) {
        Map<Integer, Integer> numbers = new TreeMap<>();
        for (int i : arr) {
            if (numbers.containsKey(i)) {
                numbers.replace(i, numbers.get(i) + 1);
            } else {
                numbers.put(i, 1);
            }
        }
        int result = 0;
        Integer[] keys = numbers.keySet().toArray(new Integer[0]);
        for (int i = 0; i < keys.length - 1; i++) {
            if (keys[i] + 1 == keys[i + 1]) {
                result += numbers.get(keys[i]);
            }
        }
        return result;
    }
}
