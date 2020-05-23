package com.company.challenge2;

import com.company.array.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Interval List Intersections
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 * Example 1:
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 * Note:
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *
 * Algorithm:
 * Two pointers for each array. Iterate while pointers less than lengths.
 * Switch corresponding pointer to the next element if it less then another.
 * Intersection = [max of starts, min of ends].
 * Switch corresponding pointer if its the intersection end.
 *
 * Time complexity : O(n + m).
 * Space complexity : O(i). i - count of intersections.
 */
public class IntervalListIntersections {

    public static void main(String[] args) {
        IntervalListIntersections app = new IntervalListIntersections();
        int[][] test = {{0,2},{5,10},{13,23},{24,25}};
        int[][] test2 = {{1,5},{8,12},{15,24},{25,26}};
        ArrayUtils.printTwoDimArray(app.intervalIntersection(test, test2)); // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        int[][] test3 = {{14,16}};
        int[][] test4 = {{7,13},{16,20}};
        ArrayUtils.printTwoDimArray(app.intervalIntersection(test3, test4)); // [[16,16]]

    }

    private int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> pairs = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] < B[j][0]) {
                i++;
                continue;
            }
            if (B[j][1] < A[i][0]) {
                j++;
                continue;
            }
            int end = Math.min(A[i][1], B[j][1]);
            pairs.add(new int[]{Math.max(A[i][0], B[j][0]), end});
            if (A[i][1] == end) i++;
            if (B[j][1] == end) j++;
        }
        int[][] result = pairs.size() > 0 ? new int[pairs.size()][2] : new int[0][0];
        for (int k = 0; k < pairs.size(); k++) {
            result[k] = pairs.get(k);
        }
        return result;
    }
}
