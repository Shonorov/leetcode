package com.company.strings;

import com.company.array.ArrayUtils;

/**
 * Reverse String
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Hint #1
 * The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
 *
 * Explanation:
 * Traverse array from both ends to center and swap values.
 *
 * Time complexity : O(n / 2).
 * Space complexity : O(1).
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString app = new ReverseString();
        char[] test = {'h','e','l','l','o'};
        char[] test2 = {'H','a','n','n','a','h'};
        app.reverseString(test);
        app.reverseString(test2);
        ArrayUtils.printCharArray(test);
        ArrayUtils.printCharArray(test2);
    }

    private void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
