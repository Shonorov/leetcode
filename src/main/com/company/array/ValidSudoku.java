package com.company.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Valid Sudoku
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/769/
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *     The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 * Input:
 * [
 *   ['5','3','.','.','7','.','.','.','.'],
 *   ['6','.','.','1','9','5','.','.','.'],
 *   ['.','9','8','.','.','.','.','6','.'],
 *   ['8','.','.','.','6','.','.','.','3'],
 *   ['4','.','.','8','.','3','.','.','1'],
 *   ['7','.','.','.','2','.','.','.','6'],
 *   ['.','6','.','.','.','.','2','8','.'],
 *   ['.','.','.','4','1','9','.','.','5'],
 *   ['.','.','.','.','8','.','.','7','9']
 * ]
 * Output: true
 *
 * Example 2:
 * Input:
 * [
 *   ['8','3','.','.','7','.','.','.','.'],
 *   ['6','.','.','1','9','5','.','.','.'],
 *   ['.','9','8','.','.','.','.','6','.'],
 *   ['8','.','.','.','6','.','.','.','3'],
 *   ['4','.','.','8','.','3','.','.','1'],
 *   ['7','.','.','.','2','.','.','.','6'],
 *   ['.','6','.','.','.','.','2','8','.'],
 *   ['.','.','.','4','1','9','.','.','5'],
 *   ['.','.','.','.','8','.','.','7','9']
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Note
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 *     The given board contain only digits 1-9 and the character '.'.
 *     The given board size is always 9x9.
 *
 * Algorithm:
 * Create arrays of Sets for rows, columns and boxes.
 * Traverse matrix and add value to all sets by corresponding index.
 * int boxIndex = (i / 3) * 3 + j / 3;
 * 2,2 = 0*3 + 0 = 0
 * 5,4 = 1*3 + 1 = 4
 * 8,8 = 2*3 + 2 = 8
 * If any set contains value - sudoku is invalid.
 *
 * Time complexity : O(m * n).
 * Space complexity : O(n * 3).
 */
public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku app = new ValidSudoku();
        char[][] test = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] test2 = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(app.isValidSudoku(test)); // true
        System.out.println(app.isValidSudoku(test2)); // false
    }

    private boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] columns = new Set[9];
        Set<Character>[] subBoxes = new Set[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            subBoxes[i] = new HashSet<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (current != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;
                    System.out.println(i + "," + j + " = " + i/3 + "*3 + " + j/3 + " = " + boxIndex);
                    if (!(rows[i].add(current) && columns[j].add(current) && subBoxes[boxIndex].add(current))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
