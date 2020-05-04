package com.company.challenge2;

/**
 * Number Complement
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
 *
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 * Note:
 *     The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 *     You could assume no leading zero bit in the integer’s binary representation.
 *     This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * Explanation:
 * First find number of meaning bits.
 * Left shift 1 for that count and subtract 1. (0001 << 3 = 1000 - 1 = 0111)
 * XOR result with original. (0x0=0, 0x1=1, 1x1=0)
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class NumberComplement {

    public static void main(String[] args) {
        NumberComplement app = new NumberComplement();
        System.out.println(app.findComplement(5)); // 2
        System.out.println(app.findComplement(1)); // 0
    }

    // Example: num = 5
    private int findComplement(int num) {
        int number_of_bits = 0;
        int temp = num;
        // Find number of bits in the given integer.
        // 5 == 0..0101 (and all positive ints).
        // at third right shifts it becomes 0. So number_of_bits = 3.
        while (temp != 0) {
            temp >>= 1;
            number_of_bits++;
        }
        // 0...0001 << 3 = 0...1000
        // 0...1000 - 1 = 0...0111
        // 0...0101 ^ 0...0111 = 0...0010 = 2
        return num ^ ((1 << number_of_bits) - 1);
    }

    private int findComplement2(int num) {
        // Find number of bits in the given integer
        int number_of_bits = (int)(Math.floor(Math.log(num) / Math.log(2))) + 1;

        // XOR the given integer with poe(2, number_of_bits-1) and print the result
        return ((1 << number_of_bits) - 1) ^ num;
    }

    private int findComplement3(int num) {
        String binary = Integer.toBinaryString(num);
        char[] arr = new char[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            arr[i] = binary.charAt(i) == '0' ? '1' : '0';
        }
        return Integer.parseInt(new String(arr), 2);
    }
}
