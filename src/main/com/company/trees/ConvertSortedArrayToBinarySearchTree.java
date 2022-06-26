package com.company.trees;

import java.util.Arrays;

import static com.company.trees.TreeNodeUtils.printTree;

/**
 * Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 *
 * Explanation:
 * Recursively find center of array and return root node of it. Get leafs from left and right sub arrays.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree app = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = new int[]{-10,-3,0,5,9};
        int[] nums2 = new int[]{1,3};
        printTree(app.sortedArrayToBST(nums)); // [0,-3,9,-10,null,5]
        printTree(app.sortedArrayToBST(nums2)); // [3,1]
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int centerIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[centerIndex]);
        if (centerIndex - 1 >= 0) {
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, centerIndex));
        }
        if (centerIndex + 1 <= nums.length - 1) {
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, centerIndex + 1, nums.length));
        }
        return root;
    }
}
