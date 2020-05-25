package com.company.challenge2;

import com.company.array.ArrayUtils;

/**
 * Uncrossed Lines
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
 *
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 *     A[i] == B[j];
 *     The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * Return the maximum number of connecting lines we can draw in this way.
 *
 * Example 1:
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 *
 * Example 2:
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 *
 * Example 3:
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 *
 * Note:
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 *
 * Hint
 * Think dynamic programming. Given an oracle dp(i,j) that tells us how many lines
 * A[i:], B[j:] [the sequence A[i], A[i+1], ... and B[j], B[j+1], ...]
 * are uncrossed, can we write this as a recursion?
 *
 * Algorithm:
 * Iterate all of array elements combinations.
 * Create matrix, where matrix[i + 1][j + 1] - max lines so far.
 * Max lines so far = max of top and left neighbours ang +1 if current elements the same (line)
 * Return matrix last element.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class UncrossedLines {

    public static void main(String[] args) {
        UncrossedLines app = new UncrossedLines();
        int[] testA = {1,4,2};
        int[] testB = {1,2,4};
        int[] testA2 = {2,5,1,2,5};
        int[] testB2 = {10,5,2,1,5,2};
        int[] testA3 = {1,3,7,1,7,5};
        int[] testB3 = {1,9,2,5,1};
        System.out.println(app.maxUncrossedLines(testA, testB)); // 2
        System.out.println(app.maxUncrossedLines(testA2, testB2)); // 3
        System.out.println(app.maxUncrossedLines(testA3, testB3)); // 2
    }

    private int maxUncrossedLines(int[] A, int[] B) {
        int height = A.length, width = B.length;
        int[][] matrix = new int[height + 1][width + 1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (A[i] == B[j]) {
                    matrix[i + 1][j + 1] = matrix[i][j] + 1;
                } else {
                    matrix[i + 1][j + 1] = Math.max(matrix[i][j + 1], matrix[i + 1][j]);
                }
            }
        }
//        ArrayUtils.printTwoDimArray(matrix);
        return matrix[height][width];
    }
}
