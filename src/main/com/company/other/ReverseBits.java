package com.company.other;

/**
 * Reverse Bits
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/648/
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example 1:
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 *
 * Example 2:
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *
 * Constraints:
 * The input must be a binary string of length 32
 *
 * Explanation:
 * Shift n and if most right bit set, then add 1 to the start of result.
 *
 * Time complexity : O(1).
 * Space complexity : O(1).
 */
public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits app = new ReverseBits();
        System.out.println(app.reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2))); // 964176192
        System.out.println(app.reverseBits(Integer.parseUnsignedInt("11111111111111111111111111111101", 2))); // -1073741825
    }

    public int reverseBits(int n) {
        int pos = Integer.SIZE - 1;
        int reverse = 0;
        while (pos >= 0 && n != 0)
        {
            if ((n & 1) != 0) {
                reverse = reverse | (1 << pos);
            }
            n >>>= 1;
            pos--;
        }
        return reverse;
    }

    public int reverseBits2(int n) {
        // store reversed bits of `n`. Initially, all bits are set to 0
        int reverse = 0;

        // do till all set bits are processed
        while (n != 0)
        {
            // find the position of the rightmost set bit
            double pos = log(n & -n, 2) + 1;

            // set the corresponding bit in the result
            // (set the leftmost bit at `pos`)
            reverse = reverse | (1 << (Integer.SIZE - (int)pos));

            // unset the rightmost set bit of a number
            n = n & (n - 1);
        }
        return reverse;
    }

    public static double log(int x, int base) {
        return (Math.log(x) / Math.log(base));
    }
}
