package com.company.array;

/**
 * Plus One
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Algorithm:
 * If start and end are 9, then result length is increased and last element is 0;
 * Otherwise increment element starting from end for element + 1.
 * When sum is less than 10 just copy mod % 10 except first element.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne app = new PlusOne();
        int[] test = {1,2,3};
        int[] test2 = {4,3,2,1};
        int[] test3 = {9,9};
        int[] test4 = {0};
        int[] test5 = {8,9,9,9};
        app.print(app.plusOne(test)); // [1,2,4]
        app.print(app.plusOne(test2)); // [4,3,2,2]
        app.print(app.plusOne(test3)); // [1,0,0]
        app.print(app.plusOne(test4)); // [1]
        app.print(app.plusOne(test5)); // [9,0,0,0]
    }

    private int[] plusOne(int[] digits) {
        int length =  digits[0] == 9 && digits[digits.length - 1] == 9 ? digits.length + 1 : digits.length;
        int[] result = new int[length];
        int increment = 1;
        if (length > digits.length) {
            result[length - 1] = 0;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + increment;
            if (sum < 10) {
                increment = 0;
            }
            result[i] = (i == 0 && sum % 10 == 0) ? 1 : sum % 10;
        }
        return result;
    }

    private void print(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
}
