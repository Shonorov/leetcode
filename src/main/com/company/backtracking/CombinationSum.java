package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Combination Sum
 * https://leetcode.com/problems/combination-sum/
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Constraints:
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 *
 * Explanation:
 * Sort candidates array.
 * Recursively backtrack all combinations.
 * Subtract current value from target, and add combination to result when target == 0.
 * Optimisations: skip if candidate > targetRemain or if current candidate < previous (candidates sorted).
 *
 * Time complexity : O(n * n!).
 * Space complexity : O(n * n!).
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum app = new CombinationSum();
        assertEquals(List.of(List.of(2,2,3),List.of(7)), app.combinationSum(new int[]{2,3,6,7}, 7));
        assertEquals(List.of(List.of(2,2,2,2),List.of(2,3,3),List.of(3,5)), app.combinationSum(new int[]{2,3,5}, 8));
        assertEquals(List.of(), app.combinationSum(new int[]{2}, 1));
//        assertEquals(List.of(), app.combinationSum(new int[]{100,200,4,12}, 400));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    public void backTrack(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> combination) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }
        backTrack(index + 1, candidates, target, result, combination);
        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            backTrack(index, candidates, target - candidates[index], result, combination);
            combination.remove(combination.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, result, new ArrayList<>(), target);
        return result;
    }

    private void backtrack(int[] candidates, List<List<Integer>> result, List<Integer> combination, int targetRemain) {
        if (targetRemain == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int candidate : candidates) {
            if (candidate > targetRemain ||
                    (!combination.isEmpty() && combination.get(combination.size() - 1) > candidate)
            ) continue;
            combination.add(candidate);
            backtrack(candidates, result, combination, targetRemain - candidate);
            combination.remove(combination.size() - 1);
        }
    }
}
