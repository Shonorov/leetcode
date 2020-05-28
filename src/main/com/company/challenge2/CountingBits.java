package com.company.challenge2;

import com.company.array.ArrayUtils;

/**
 * Counting Bits
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * Hints:
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 *
 * Algorithm:
 * At every step remove last significant bit for it = i & (i - 1) i.e. for 3 step:
 * We have count for now [ 0 1 1 0 0 0 ].
 * 3 (11) &
 * 2 (10) =
 * 2 (10)
 * Add one (+1) to existing count for result index in result array:
 * num[2] = 1
 * num[3] = num[2] + 1 = 2
 * [ 0 1 1 2 0 0 ]
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class CountingBits {

    public static void main(String[] args) {
        CountingBits app = new CountingBits();
        ArrayUtils.printArray(app.countBits(2)); // [0,1,1]
        ArrayUtils.printArray(app.countBits(5)); // [0,1,1,2,1,2]
    }

    private int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 1; i < num + 1; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
