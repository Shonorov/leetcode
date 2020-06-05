package com.company.challenge3;

import java.util.Arrays;
import java.util.Random;

/**
 * Random Pick with Weight
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 *
 * Example 1:
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 *
 * Example 2:
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 *
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w.
 * pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 *
 * Algorithm:
 * Crate cumulative weight sum array where weights[i] = w[i] + weights[i - 1].
 * All weights sum (weightSum) is the last element.
 * Generate random int [1 ... weightSum] and perform binary search for it`s index.
 * If exact index not found ("-(would be inserted index) - 1" is returned) reverse calculate it and return as next array index;
 * i.e: for array=[1,3,4] and search value = 2, index 1 is returned.
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(n).
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {1};
        int[] test2 = {1,3};
        Solution app = new Solution(test);
        Solution app2 = new Solution(test2);
        System.out.println(app.pickIndex()); // 0
        System.out.println("---------");
        System.out.println(app2.pickIndex()); // 0
        System.out.println(app2.pickIndex()); // 1
        System.out.println(app2.pickIndex()); // 1
        System.out.println(app2.pickIndex()); // 1
        System.out.println(app2.pickIndex()); // 0
    }

    private int[] weights;
    private int weightSum = 0;
    private Random rnd = new Random();

    private Solution(int[] w) {
        weights = new int[w.length];
        weights[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            weights[i] = weights[i - 1] + w[i];
        }
        weightSum += weights[weights.length - 1];
    }

    private int pickIndex() {
        int random = rnd.nextInt(weightSum) + 1;
        int weightIndex = Arrays.binarySearch(weights, random);
        return weightIndex < 0 ? -weightIndex - 1 : weightIndex;
    }
}
