package com.company.challange;

/**
 * Bitwise AND of Numbers Range
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3308/
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Input: [5,7]
 * Output: 4
 *
 * Input: [0,1]
 * Output: 0
 *
 * Note:
 * & (AND)
 * The bits that are set in both operands are set.
 * (10101010) & (11111111) = (10101010)
 *
 * Note:
 * >> (SHIFT RIGHT)
 * It shifts the bits of operand1 to the right operand2
 * Four bit right shift (00000011 = 4):
 * (10101010) >>
 * (00000011) =
 * (00001010)
 *
 * Note:
 * Last Significant Bit (LSB) - last '1' position (for 10100 = third one).
 *
 * Explanation:
 * Flip the LSB of b.
 * And check if the new number is in range(a < number < b) or not:
 * - if the number greater than 'a' again flip lsb
 * - if it is not then that's the answer
 *
 * Example:
 * x = 17, y = 19
 * y = 10011
 * Flip LSB of y so New Number = 10010 i.e. 18
 * 18 is in range so Again flip : 10000 i.e. 16 and 16 is not in range so Stop, answer is 16.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class BitwiseANDNumbersRange {

    public static void main(String[] args) {
        BitwiseANDNumbersRange app = new BitwiseANDNumbersRange();
        int[] test = {5, 7};
        int[] test2 = {0, 1};
        int[] test3 = {12, 15};
        int[] test4 = {10, 20};
        System.out.println(app.rangeBitwiseAnd(test[0], test[1])); // 4
        System.out.println("------------------------------");
        System.out.println(app.rangeBitwiseAnd(test2[0], test2[1])); // 0
        System.out.println("------------------------------");
        System.out.println(app.rangeBitwiseAnd(test3[0], test3[1])); // 12
        System.out.println("------------------------------");
        System.out.println(app.rangeBitwiseAnd(test4[0], test4[1])); // 0
        System.out.println("------------------------------");
    }

    private int rangeBitwiseAnd(int m, int n) {
        while(m < n) {
            // -n is the 2's complement of n when do bitwise or with n
            // we get LSB and we subtract that from n
            // n = n - LSB
            int LSB = n & -n;
            System.out.println(Integer.toBinaryString(n) + " & " + Integer.toBinaryString(-n) + " = " + LSB + " (LSB of n)");
            System.out.print(n + " - " + LSB + " = ");
            n -= LSB;
            System.out.println(n);
        }
        System.out.print(n + " <= " + m + " answer is ");
        return n;
    }
}
