package com.company.array;

/**
 * Rotate Image
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/770/
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * Example 2:
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * Explanation:
 * Iterate matrix once in circles from outer to inner.
 * Number of circles = side / 2;
 * In circle number of iterations = side - i * 2 - 1;
 * NaxIndex is highest possible index in circle. Helps to calculate replacement steps.
 *
 * Time complexity : O(n * m).
 * Space complexity : O(1).
 */
public class RotateImage {

    public static void main(String[] args) {
        RotateImage app = new RotateImage();
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] test2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] test3 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,16},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] test4 = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
        app.rotate(test);
        app.rotate(test2);
        app.rotate(test3);
        app.rotate(test4);
        ArrayUtils.printTwoDimArray(test);
        ArrayUtils.printTwoDimArray(test2);
        ArrayUtils.printTwoDimArray(test3);
        ArrayUtils.printTwoDimArray(test4);
    }

    private void rotate(int[][] matrix) {
        int side = matrix.length;
        for (int i = 0; i < side / 2; i++) {
            int maxIndex = side - i - 1;
            for (int j = 0; j < maxIndex - i; j++) {
                int top = matrix[i][i + j];
//                System.out.println(i + " " + (i + j)); // top
//                System.out.println((j + i) + " " + maxIndex); // right
//                System.out.println(maxIndex + " " + (maxIndex - j)); // bot
//                System.out.println((maxIndex - j) + " " + i); // left
//                System.out.println("------------");
                matrix[i][i + j] = matrix[maxIndex - j][i];
                matrix[maxIndex - j][i] = matrix[maxIndex][maxIndex - j];
                matrix[maxIndex][maxIndex - j] = matrix[j + i][maxIndex];
                matrix[i + j][maxIndex] = top;
            }
        }
    }
}
