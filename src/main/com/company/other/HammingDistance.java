package com.company.other;

/**
 * Hamming Distance
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 *
 * Example 1:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 *
 * Example 2:
 * Input: x = 3, y = 1
 * Output: 1
 * 1   (0 0 0 1)
 * 4   (0 0 1 1)
 *          ↑
 *
 * Constraints:
 * 0 <= x, y <= 231 - 1
 *
 * Explanation:
 * XOR x and y before to set only different bits, then count set bits.
 * Do bitwise & with N-1 value until N > 0 and increase count.
 * Right set bit will be unset on each iteration:
 * N & (N – 1) = (36 & 35) = (100100 & 100011) = 32 (100000)
 * N & (N – 1) = (32 & 31) = (100000 & 011111) = 0 (000000)
 *
 * Time complexity : O(1).
 * Space complexity : O(1).
 */
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance app = new HammingDistance();
        System.out.println(app.hammingDistanceKernigan(1, 4)); // 2
        System.out.println(app.hammingDistanceKernigan(3, 1)); // 1
    }

    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }
        return count;
    }

    public int hammingDistanceKernigan(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor > 0) {
            xor = (xor & (xor - 1));
            ++count;
        }
        return count;
    }
}
