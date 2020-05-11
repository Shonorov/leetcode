package com.company.challenge2;

import com.company.array.ArrayUtils;

/**
 * Flood Fill
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
 *
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * To perform a "flood fill", consider the starting pixel,
 * plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
 * and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 *
 * Example 1:
 * Input:
 * image = [[1,1,1],
 *          [1,1,0],
 *          [1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],
 *          [2,2,0],
 *          [2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 *
 * Note:
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 *
 * Hint #1
 * Write a recursive function that paints the pixel if it's the correct color, then recurses on neighboring pixels.
 *
 * Explanation:
 * Recursively paint neighbours in place.
 * If previous oldColor not the same as current or oldColor and newColor same (been there) exit.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class FloodFill {

    public static void main(String[] args) {
        FloodFill app = new FloodFill();
        int[][] test = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
        int[][] test2 = new int[][] {{0,0,0},{0,1,1}};
        ArrayUtils.printTwoDimArray(app.floodFill(test, 1, 1, 2)); // [[2,2,2],[2,2,0],[2,0,1]]
        ArrayUtils.printTwoDimArray(app.floodFill(test2, 1, 1, 1)); // [[0,0,0],[0,1,1]]
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        paint(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void paint(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor || newColor == oldColor) return;
        image[x][y] = newColor;
        paint(image, x + 1, y, oldColor, newColor);
        paint(image, x - 1, y, oldColor, newColor);
        paint(image, x, y + 1, oldColor, newColor);
        paint(image, x, y - 1, oldColor, newColor);
    }
}
