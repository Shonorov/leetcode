package com.company.challenge2;

/**
 * First Bad Version
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 *
 * Algorithm:
 * Array binary search. Range cut by half each time.
 * WRONG! int mid = (start + end) / 2
 * int mid = (Integer.MAX_VALUE + Integer.MAX_VALUE) / 2 = -1 !INTEGER VARIABLE OVERFLOW!
 * RIGHT! int mid = start + (end - start) / 2;
 *
 * Time complexity : O(log(n)).
 * Space complexity : O(1).
 */
public class FirstBadVersion {

    private boolean[] versions;
    private FirstBadVersion(boolean[] versions) {
        this.versions = versions;
    }

    public static void main(String[] args) {
        boolean[] test = {false, false, false, true, true};
        FirstBadVersion app = new FirstBadVersion(test);
        System.out.println(app.firstBadVersion(test.length)); // 4
    }


    private int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            System.out.println(start + " " + mid + " " + end);
            System.out.println(isBadVersion(start) + " " + isBadVersion(mid) + " " + isBadVersion(end));
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start + " " + end);
        return start;
    }

    private boolean isBadVersion(int version) {
        return versions[version - 1];
    }
}
