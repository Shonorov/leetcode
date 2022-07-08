package com.company.sort_search;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Merge Intervals
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * Explanation:
 * Sort intervals by starting positions and iterate on them.
 * If intervals overlap, current[1] = Math.max(intervals[i][1], current[1]), else add to result.
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(n).
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals app = new MergeIntervals();
        assertArrayEquals(new int[][]{{1,6},{8,10},{15,18}}, app.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
        assertArrayEquals(new int[][]{{1,5}}, app.merge(new int[][]{{1,4},{4,5}}));
        assertArrayEquals(new int[][]{{1,4}}, app.merge(new int[][]{{1,4}}));
        assertArrayEquals(new int[][]{{0,4}}, app.merge(new int[][]{{1,4},{0,4}}));
        assertArrayEquals(new int[][]{{1,4}}, app.merge(new int[][]{{1,4},{2,3}}));
    }

    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        int count = 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                result[count++] = current;
                current  = intervals[i];
            }
        }
        result[count++] = current;
        return Arrays.copyOf(result, count);
    }
}
