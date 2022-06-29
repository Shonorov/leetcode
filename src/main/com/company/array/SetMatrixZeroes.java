package com.company.array;

import static com.company.array.ArrayUtils.printTwoDimArray;

/**
 * Set Matrix Zeroes
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 * Explanation:
 * Iterate by matrix Mark with zeroes rows and columns with first cells.
 * Iterate once more by inner side and mark with zero matrix[i][0] == 0 || matrix[0][j] == 0 cells.
 * Iterate and mark with zero outer bounds.
 *
 * Time complexity : O(n x m).
 * Space complexity : O(1).
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes app = new SetMatrixZeroes();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] matrix3 = {{2147483647}, {2}, {3}};
        app.setZeroes(matrix);
        app.setZeroes(matrix2);
        app.setZeroes(matrix3);
        printTwoDimArray(matrix); // [[1,0,1],[0,0,0],[1,0,1]]
        printTwoDimArray(matrix2); // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        printTwoDimArray(matrix3); // [[2147483647][2][3]]
    }

    public void setZeroes(int[][] matrix) {
        boolean markFirstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) markFirstCol = true;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (markFirstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
