package com.company.other;

/**
 * Number of 1 Bits
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/565/
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Example 1:
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 *
 * Example 2:
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 *
 * Example 3:
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 * Constraints:
 * The input must be a binary string of length 32.
 *
 * Follow up: If this function is called many times, how would you optimize it?
 *
 * Explanation:
 * Bit shift binary representation and increase count if last bit is 1.
 * 11101 * 00001 = 00001 (1).
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        NumberOf1Bits app = new NumberOf1Bits();
        System.out.println(app.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2))); // 3
        System.out.println(app.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000", 2))); // 1
        System.out.println(app.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2))); // 31
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeightLOL(int n) {
        return Integer.bitCount(n);
    }
}
