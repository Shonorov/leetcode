package com.company.challenge2;

/**
 * Check If It Is a Straight Line
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 * Example 1:
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Example 2:
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Constraints:
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 *
 * Hint #1
 * If there're only 2 points, return true.
 * Hint #2
 * Check if all other points lie on the line defined by the first 2 points.
 * Hint #3
 * Use cross product to check collinearity.
 *
 * Explanation:
 * If there're only 2 points, return true.
 * Line equation is: y == kx + b
 * Get k and b first.
 * b = y - kx
 * y1 - kx1 = y2 - kx2
 * k = (y1 - y2) / (x1 - x2) (if x1 == x2 then k = 0 - vertical line)
 * Check if other points on the line with line equation.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class CheckIfStraightLine {

    public static void main(String[] args) {
        CheckIfStraightLine app = new CheckIfStraightLine();
        int[][] test = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] test2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        int[][] test3 = {{-7,-3},{-7,-1},{-2,-2},{0,-8},{2,-2},{5,-6},{5,-5},{1,7}};
        System.out.println(app.checkStraightLine(test)); // true
        System.out.println(app.checkStraightLine(test2)); // false
        System.out.println(app.checkStraightLine(test3)); // false
    }

    private boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        float k = coordinates[0][0] != coordinates[1][0] ? (coordinates[0][1] - coordinates[1][1]) / (coordinates[0][0] - coordinates[1][0]) : 0;
        float b = coordinates[0][1] - k * coordinates[0][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][1] != k * coordinates[i][0] + b) {
                return false;
            }
        }
        return true;
    }
}
