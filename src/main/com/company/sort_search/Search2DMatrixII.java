package com.company.sort_search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Search a 2D Matrix II
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 * - Integers in each row are sorted in ascending from left to right.
 * - Integers in each column are sorted in ascending from top to bottom.
 *
 * Example 1:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 *
 * Explanation:
 * Binary search for all matrix rows in range.
 *
 * Time complexity : O(n*log(m)).
 * Space complexity : O(1).
 */
public class Search2DMatrixII {

    public static void main(String[] args) {
        Search2DMatrixII app = new Search2DMatrixII();
        assertTrue(app.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        assertTrue(app.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 12));
        assertFalse(app.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        assertTrue(app.searchMatrix(new int[][]{{1,4,7,11,15}}, 1));
        assertTrue(app.searchMatrix(new int[][]{{1,4,7,11,15}}, 15));
        assertFalse(app.searchMatrix(new int[][]{{1,4,7,11,15}}, 20));
        assertTrue(app.searchMatrix(new int[][]{{1}}, 1));
        assertFalse(app.searchMatrix(new int[][]{{1}}, 2));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (row[0] <= target && target <= row[row.length - 1]) {
                int start = 0;
                int end = row.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (target < row[mid]) {
                        end = mid - 1;
                    } else if (target > row[mid]) {
                        start = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean searchMatrixMN(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (target > matrix[row][column]) {
                row++;
            } else if (target < matrix[row][column]) {
                column--;
            } else {
                return true;
            }
        }
        return false;
    }
}
