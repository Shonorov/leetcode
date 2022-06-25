package com.company.design;

import java.util.Random;

import static com.company.array.ArrayUtils.printArray;

/**
 * Shuffle an Array
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/
 *
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 *
 * Example 1:
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 *                        // Any permutation of [1,2,3] must be equally likely to be returned.
 *                        // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 *
 * Constraints:
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * All the elements of nums are unique.
 * At most 104 calls in total will be made to reset and shuffle.
 *
 * Explanation:
 * Swap random index on shuffle inside copy of array. Return initial array on reset.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ShuffleAnArray {

    public static void main(String[] args) {
        Solution app = new Solution(new int[]{1, 2 ,3});
        printArray(app.shuffle()); // 3,2,1
        printArray(app.reset()); // 1,2,3
        printArray(app.shuffle()); // 1,3,4
    }
}

class Solution {

    private final int[] array;
    private final Random random = new Random();

    Solution(int[] array) {
        this.array = array;
    }

    public int[] reset() {
        return this.array;
    }

    public int[] shuffle() {
        int[] result = this.array.clone();
        for (int i = 0; i < result.length; i++) {
            int index = this.random.nextInt(result.length);
            int temp = result[i];
            result[i] = result[index];
            result[index] = temp;
        }
        return result;
    }
}