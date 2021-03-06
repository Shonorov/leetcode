package com.company.challenge2;

/**
 * Count Square Submatrices with All Ones
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 * Example 1:
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 *
 * Example 2:
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 * Constraints:
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *
 * Hint:
 * Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0).
 * Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, if it checks then add 1 to the answer.
 *
 * Algorithm:
 * Crate matrix with square counts. First vertical and horizontal lines copy as is.
 * For others if element = 1, then squares count ending this point is 1 + minimum count of top neighbours counts.
 * Add element squares sum to result.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class CountSquareSubmatricesAllOnes {

    public static void main(String[] args) {
        CountSquareSubmatricesAllOnes app = new CountSquareSubmatricesAllOnes();
        int[][] test = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        int[][] test2 = {{1,0,1},{1,1,0},{1,1,0}};
        System.out.println(app.countSquares(test)); // 15
        System.out.println(app.countSquares(test2)); // 7
    }

    private int countSquares(int[][] matrix) {
        int result = 0;
        int[][] squares = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    squares[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    squares[i][j] = 1 + Math.min(squares[i - 1][j], Math.min(squares[i - 1][j - 1], squares[i][j - 1]));
                }
                result += squares[i][j];
            }
        }
        return result;
    }
}
