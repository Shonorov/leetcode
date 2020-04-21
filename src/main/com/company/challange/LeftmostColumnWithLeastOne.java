package com.company.challange;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
    int get(int x, int y);
    List<Integer> dimensions();
}

class Matrix implements BinaryMatrix {

    public List<Integer> dimensions() {
        List<Integer> dimensions = new ArrayList<>();
        dimensions.add(arr.length);
        dimensions.add(arr.length > 0 ? arr[0].length : 0);
        return dimensions;
    }
    private int[][] arr;

    Matrix(int[][] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int x, int y) {
        return this.arr[x][y];
    }
}

/**
 * Leftmost Column with at Least a One
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
 *
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix,
 * this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
 * If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 *     BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 *     BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 *
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples.
 * You will not have access the binary matrix directly.
 *
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 *
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 *
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 *
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 *
 * Constraints:
 *     1 <= mat.length, mat[i].length <= 100
 *     mat[i][j] is either 0 or 1.
 *     mat[i] is sorted in a non-decreasing way.
 *
 * 1. (Binary Search) For each row do a binary search to find the leftmost one on that row and update the answer.
 * 2. (Optimal Approach) Imagine there is a pointer p(x, y) starting from top right corner. p can only move left or down.
 *    If the value at p is 0, move down. If the value at p is 1, move left.
 *    Try to figure out the correctness and time complexity of this algorithm.
 *
 * Explanation:
 * Second approach above. Limit matrix element array last index by leftmost "1" index.
 *
 * Time complexity : O(m * n).
 * Space complexity : O(1).
 */
public class LeftmostColumnWithLeastOne {

    public static void main(String[] args) {
        LeftmostColumnWithLeastOne app = new LeftmostColumnWithLeastOne();
        int[][] test = {{0,0},{1,1}};
        int[][] test2 = {{0,0},{0,1}};
        int[][] test3 = {{0,0},{0,0}};
        int[][] test4 = {{0,0,0,1},{0,0,1,1},{0,1,1,1}};
        int[][] test5 = {{1,1,1,1,1},{0,0,0,1,1},{0,0,1,1,1},{0,0,0,0,1},{0,0,0,0,0}};

        System.out.println(app.leftMostColumnWithOne(new Matrix(test))); // 0
        System.out.println(app.leftMostColumnWithOne(new Matrix(test2))); // 1
        System.out.println(app.leftMostColumnWithOne(new Matrix(test3))); // -1
        System.out.println(app.leftMostColumnWithOne(new Matrix(test4))); // 1
        System.out.println(app.leftMostColumnWithOne(new Matrix(test5))); // 0
    }


    private int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int width = binaryMatrix.dimensions().get(0), result = binaryMatrix.dimensions().get(1) - 1;
        boolean notFound = true;
        for (int i = 0; i < width ; i++) {
            for (int j = result; j >= 0; j--) {
                if (binaryMatrix.get(i, j) == 0) {
                    break;
                } else {
                    result = Math.min(j, result);
                    notFound = false;
                }
            }
            if (result == 0) break;
        }
        return notFound ? -1 : result;
    }
}
