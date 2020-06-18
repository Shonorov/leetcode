package com.company.challenge3;

/**
 * H-Index II
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
 *
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * Example:
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 *              received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 *
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * Follow up: This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 *            Could you solve it in logarithmic time complexity?
 *
 * Hint: Expected runtime complexity is in O(log n) and the input is sorted.
 *
 * Algorithm:
 * Binary search element where citations[i] == citations.length - i;
 *
 * Time complexity : O(log n).
 * Space complexity : O(1).
 */
public class HIndexII {

    public static void main(String[] args) {
        HIndexII app = new HIndexII();
        int[] test = {0,1,3,5,6};
        int[] test2 = {1,2,3,4,5,6};
        int[] test3 = {100};
        int[] test4 = {0};
        int[] test5 = {11,15};

        System.out.println(app.hIndex(test)); // 3
        System.out.println(app.hIndex(test2)); // 3
        System.out.println(app.hIndex(test3)); // 1
        System.out.println(app.hIndex(test4)); // 0
        System.out.println(app.hIndex(test5)); // 2
    }

    private int hIndex(int[] citations) {
        int start = 0, mid = 0, end = citations.length - 1;
        while (start <= end) {
            mid = (end + (end - start)) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations.length - mid;
            } else if (citations[mid] < citations.length - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return citations.length - start;
    }
}
