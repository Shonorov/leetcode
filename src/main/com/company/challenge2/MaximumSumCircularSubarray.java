package com.company.challenge2;

/**
 * Maximum Sum Circular Subarray
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
 *
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 *
 * Example 1:
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 *
 * Example 2:
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 * Example 3:
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 *
 * Example 4:
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 *
 * Example 5:
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 *
 * Note:
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 *
 * Explanation:
 * First get max sequence sum in the array and get sum of all elements.
 * Then invert sign for each element and get max sequence sums of two sub arrays without both ends (any of circular sequences will not include one of the ends).
 * Max sequence of cycled arrays = sum + negative array max (we remove most negative sequence from array and get sum of other elements).
 * Max of three is the answer.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        MaximumSumCircularSubarray app = new MaximumSumCircularSubarray();
        int[] test = {1,-2,3,-2};
        int[] test2 = {5,-3,5};
        int[] test3 = {3,-1,2,-1};
        int[] test4 = {3,-2,2,-3};
        int[] test5 = {-2,-3,-1};
        int[] test6 = {-2};
        System.out.println(app.maxSubarraySumCircular(test)); // 3
        System.out.println(app.maxSubarraySumCircular(test2)); // 10
        System.out.println(app.maxSubarraySumCircular(test3)); // 4
        System.out.println(app.maxSubarraySumCircular(test4)); // 3
        System.out.println(app.maxSubarraySumCircular(test5)); // -1
        System.out.println(app.maxSubarraySumCircular(test6)); // -2
    }

    private int maxSubarraySumCircular(int[] A) {
        if (A.length == 1) return A[0];
        int singleArrayMax = kadaneSigned(A,0, A.length, 1);
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int negativeArrayMaxStart = sum + kadaneSigned(A, 0, A.length - 1, -1);
        int negativeArrayMaxEnd = sum + kadaneSigned(A, 1, A.length - 1, -1);
        return Math.max(singleArrayMax, Math.max(negativeArrayMaxStart, negativeArrayMaxEnd));
    }

    private int kadaneSigned(int[] arr, int start, int length, int sign) {
        int max = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;
        for (int i = start; i < length; i++)
        {
            currentMax = sign * arr[i] + Math.max(0, currentMax);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
