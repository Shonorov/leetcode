package com.company.challenge3;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3366/
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * Algorithm:
 * Get list of n digits {1,2..n} and n - 1 factorial value.
 * Next highest digit index in the list of {1,2..n} = k - 1 / (n - 1)!
 * Remove index value from list and append to result.
 * Update n - 1 factorial (nMinusOneFactorial / numbers.size()) and k (k % nMinusOneFactorial) while list is not empty.
 *
 * Verbose for n = 4, k = 9:
 * digits = [1, 2, 3, 4]; index = 8 / 6 = 1 (2); result = 2
 * digits = [1, 3, 4];    index = 2 / 2 = 1 (3); result = 23
 * digits = [1, 4];       index = 0 / 1 = 0 (1); result = 231
 * digits = [4];          index = 0 / 1 = 0 (4); result = 2314
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence app = new  PermutationSequence();
        System.out.println(app.getPermutation(3,3)); // 213
        System.out.println(app.getPermutation(4,9)); // 2314
    }

    private String getPermutation3(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }

    private String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int nMinusOneFactorial = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            if (i == n) break;
            nMinusOneFactorial = nMinusOneFactorial * i;
        }
        StringBuilder sb = new StringBuilder();
        k--;
        while (true) {
            sb.append(numbers.remove(k / nMinusOneFactorial));
            k = k % nMinusOneFactorial;
            if (numbers.isEmpty()) break;
            nMinusOneFactorial = nMinusOneFactorial / numbers.size();
        }
        return sb.toString();
    }
}
