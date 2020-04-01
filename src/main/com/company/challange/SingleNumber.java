package com.company.challange;

/**
 * Single Number
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 * Explanation:
 * a) XOR of a number with itself is 0.
 * b) XOR of a number with 0 is number itself.
 *
 * Time complextiy : O(n).
 * Space complexity : O(0).
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] test1 = {4,1,2,1,2};
        int[] test2 = {2,2,1};
        System.out.println(singleNumber.singleNumber(test1)); //4
        System.out.println(singleNumber.singleNumber(test2)); //1
    }

    private int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            System.out.print(result + " ^ " + nums[i] + " = ");
            result = result ^ nums[i];
            System.out.println(result);
        }
        return result;
    }
}
