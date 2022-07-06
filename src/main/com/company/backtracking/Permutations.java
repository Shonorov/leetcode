package com.company.backtracking;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Permutations
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 * Explanation:
 * Recursively process all combinations.
 * If current.size() == nums.length -> add combination to result.
 * Else loop on nums array and if current List contains value -> continue, otherwise -> add.
 * start next iteration and remove last value from result.
 *
 * Time complexity : O(n*n!).
 * Space complexity : O(n*n!).
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations app = new Permutations();
        assertEquals(List.of(List.of(1,2,3),List.of(1,3,2),List.of(2,1,3),List.of(2,3,1),List.of(3,1,2),List.of(3,2,1)), app.permute(new int[]{1,2,3}));
        assertEquals(List.of(List.of(0,1),List.of(1,0)), app.permute(new int[]{0,1}));
        assertEquals(List.of(List.of(1)), app.permute(new int[]{1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        process(result, new ArrayList<>(), nums);
        return result;
    }

    private void process(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (current.contains(nums[i])) continue;
                current.add(nums[i]);
                process(result, current, nums);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        formPermutation(nums, 0, permutations);
        return permutations;
    }

    private void formPermutation(int[] permutation, int currentIndex, List<List<Integer>> permutations) {
        if (currentIndex == permutation.length) {
            List<Integer> permutationList = new ArrayList<>();
            for (int num : permutation) { permutationList.add(num); }
            permutations.add(permutationList);
        } else {
            for (int index = currentIndex; index < permutation.length; index++) {
                swap(permutation, index, currentIndex);
                formPermutation(permutation, currentIndex + 1, permutations);
                swap(permutation, index, currentIndex);
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
