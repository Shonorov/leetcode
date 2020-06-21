package com.company.challenge3;

import com.company.array.ArrayUtils;
/**
 * Dungeon Game
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid.
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer.
 * If at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2 (K) -3   3
 * -5 	  -10  1
 * 10 	   30 -5 (P)
 *
 * Note:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 * Algorithm:
 * Bottom-Up dynamic programming solution since we can not know health gains and fix required minimum.
 * Initiate matrix with health for every room.
 * Current health >= 1 and minimum of differences between right and bottom ones.
 *
 * Verbose health matrix for example 1:
 * [ 7 5 2 ]
 * [ 6 11 5 ]
 * [ 1 1 6 ]
 *
 * Time complexity : O(n * m).
 * Space complexity : O(n * m).
 */
public class DungeonGame {

    public static void main(String[] args) {
        DungeonGame app = new DungeonGame();
        int[][] test = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] test2 = {{}};
        int[][] test3 = {{-2,-3,3}};
        int[][] test4 = {{-2}};
        int[][] test5 = {{100}};
        int[][] test6 = {{-3,5}};
        int[][] test7 = {{100, -1}};
        int[][] test8 = {{-1, 1}};
        System.out.println(app.calculateMinimumHP(test)); // 7
        System.out.println(app.calculateMinimumHP(test2)); // 1
        System.out.println(app.calculateMinimumHP(test3)); // 6
        System.out.println(app.calculateMinimumHP(test4)); // 3
        System.out.println(app.calculateMinimumHP(test5)); // 1
        System.out.println(app.calculateMinimumHP(test6)); // 4
        System.out.println(app.calculateMinimumHP(test7)); // 1
        System.out.println(app.calculateMinimumHP(test8)); // 2
    }

    private int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int[][] matrix = new int[dungeon.length][dungeon[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (i == matrix.length - 1 && j == matrix[0].length - 1) {
                    matrix[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == matrix.length - 1) {
                    matrix[i][j] = Math.max(1, matrix[i][j + 1] - dungeon[i][j]);
                } else if (j == matrix[0].length - 1) {
                    matrix[i][j] = Math.max(1, matrix[i + 1][j] - dungeon[i][j]);
                } else {
                    matrix[i][j] = Math.max(1, Math.min(matrix[i + 1][j], matrix[i][j + 1]) - dungeon[i][j]);
                }
            }
        }
//        ArrayUtils.printTwoDimArray(matrix);
        return matrix[0][0];
    }
}
