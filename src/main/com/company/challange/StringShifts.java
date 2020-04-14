package com.company.challange;

/**
 * Perform String Shifts
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
 *
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 *     direction can be 0 (for left shift) or 1 (for right shift).
 *     amount is the amount by which string s is to be shifted.
 *     A left shift by 1 means remove the first character of s and append it to the end.
 *     Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 *
 * Return the final string after all operations.
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 * Constraints:
 *     1 <= s.length <= 100
 *     s only contains lower case English letters.
 *     1 <= shift.length <= 100
 *     shift[i].length == 2
 *     0 <= shift[i][0] <= 1
 *     0 <= shift[i][1] <= 100
 *
 * Hint: Intuitively performing all shift operations is acceptable due to the constraints.
 * Hint: You may notice that left shift cancels the right shift, so count the total left shift times
 *       (may be negative if the final result is right shift), and perform it once.
 *
 * Explanation:
 * Get resulting right rotations count.
 * Rotate is done by sum substring of end part to start part.
 *
 * Time complexity : O(n). n - rotations count
 * Space complexity : O(1).
 */
public class StringShifts {

    public static void main(String[] args) {
        StringShifts app = new StringShifts();
        String test = "abc";
        int[][] shift = {{0,1}, {1,2}};
        String test2 = "abcdefg";
        int[][] shift2 = {{1,1}, {1,1}, {0,2}, {1,3}};
        String test3 = "mecsk";
        int[][] shift3 = {{1,4}, {0,5}, {0,4}, {1,1}, {1,5}};
        String test4 = "xqgwkiqpif";
        int[][] shift4 = {{1,4}, {0,7}, {0,8}, {0,7}, {0,6}, {1,3}, {0,1}, {1,7}, {0,5}, {0,6}};
        System.out.println(app.stringShift(test, shift)); // cab
        System.out.println(app.stringShift(test2, shift2)); // efgabcd
        System.out.println(app.stringShift(test3, shift3)); // kmecs
        System.out.println(app.stringShift(test4, shift4)); // qpifxqgwki
    }

    private String stringShift(String s, int[][] shift) {
        int rotation = getShift(s.length(), shift);
        s = s.substring(s.length() - rotation) + s.substring(0, s.length() - rotation);
        return s;
    }

    private int getShift(int length, int[][] shift) {
        int sum = 0;
        for (int[] pair : shift) {
            sum += pair[0] > 0 ? pair[1] : -pair[1];
        }
        sum = Math.abs(sum) >= length ? sum % length : sum;
        return sum > 0 ? sum : length + sum;
    }
}
