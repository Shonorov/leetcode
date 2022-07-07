package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Subsets
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/796/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 *
 * Explanation:
 * Recursively backtrack all combinations. Skip unsorted variants to exclude duplicates, so as longest variant.
 *
 * Time complexity : O(n*2^n).
 * Space complexity : O(n*2^n).
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets app = new Subsets();
        assertEquals(List.of(List.of(),List.of(1),List.of(1,2),List.of(1,3),List.of(2),List.of(2,3),List.of(3),List.of(1,2,3)), app.subsets(new int[]{1,2,3}));
        assertEquals(List.of(List.of(),List.of(0)), app.subsets(new int[]{0}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> all = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(result, new ArrayList<>(), nums);
        result.add(all);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length ||
            current.size() > 1 && current.get(current.size() - 1) < current.get(current.size() - 2)
        ) {
            return;
        }
        result.add(new ArrayList<>(current));
        for (int num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            backtrack(result, current, nums);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void generateSubsets(int curr, int[] nums, List<Integer> subset, List<List<Integer>> ans) {
        if (curr == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[curr]);
        generateSubsets(curr + 1, nums, subset, ans);
        subset.remove(subset.size() - 1);
        generateSubsets(curr + 1, nums, subset, ans);
    }
}
