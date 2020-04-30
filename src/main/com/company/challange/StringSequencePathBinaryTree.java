package com.company.challange;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/
 *
 * Given a binary tree where each path going from the root to any leaf form a valid sequence,
 * check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values
 * of the nodes along a path results in a sequence in the given binary tree.
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence.
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 *
 * Constraints:
 *     1 <= arr.length <= 5000
 *     0 <= arr[i] <= 9
 *     Each node's value is between [0 - 9].
 *
 * Explanation:
 * Depth-first search (DFS) with the parameters: current node in the binary tree and current position in the array of integers.
 * When reaching at final position check if it is a leaf node.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class StringSequencePathBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        StringSequencePathBinaryTree app = new StringSequencePathBinaryTree();
        TreeNode test = new TreeNode(0, new TreeNode(1, new TreeNode(0, null, new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(0))), new TreeNode(0, new TreeNode(0), null));
        System.out.println(app.isValidSequence(test, new int[]{0,1,0,1})); // true
        System.out.println(app.isValidSequence(test, new int[]{0,0,1})); // false
        System.out.println(app.isValidSequence(test, new int[]{0,1,1})); // false
    }

    private boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    private boolean isValidSequence(TreeNode node, int[] arr, int position) {
        if (node == null || position >= arr.length || node.val != arr[position]) {
            return false;
        } else if (position == arr.length - 1 && node.left == null && node.right == null) {
            return true;
        }
        return isValidSequence(node.left, arr, position + 1) || isValidSequence(node.right, arr, position + 1);
    }
}
