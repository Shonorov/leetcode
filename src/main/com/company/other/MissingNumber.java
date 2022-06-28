package com.company.other;

/**
 * Missing Number
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/
 *
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 *
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 *
 * Explanation:
 * sum = (first number + last number) * (n / 2). @Carl Gauss
 * Subtract array elements from total sum. Missing number remains.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber app = new MissingNumber();
        System.out.println(app.missingNumber(new int[]{3,0,1})); // 2
        System.out.println(app.missingNumber(new int[]{0,1})); // 2
        System.out.println(app.missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8
        System.out.println(app.missingNumber(new int[]{1})); // 0
        System.out.println(app.missingNumber(new int[]{0})); // 1
    }

    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSum += i + 1;
            sum += nums[i];
        }
        return maxSum - sum;
    }
}
