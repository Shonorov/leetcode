package com.company.Trees;

/**
 * Validate Binary Search Tree
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 *
 * Explanation:
 * Add min and max values for each node.
 * For each node:
 * Update max=prev.val for left branches and min=prev.val for right branches.
 * Each step validate if min < node.val < max, otherwise BST invalid.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree app = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(app.isValidBST(root)); // true
        System.out.println(app.isValidBST(root2)); // false
        System.out.println(app.isValidBST(root3)); // true
        System.out.println(app.isValidBST(null)); // true
        System.out.println(app.isValidBST(root4)); // false
    }

    public boolean isValidBST(TreeNode root) {
        return validateNode(root, null, null);
    }

    private boolean validateNode(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max!= null && node.val >= max)) {
            return false;
        }
        return validateNode(node.left, min, node.val) && validateNode(node.right, node.val, max);
    }
}
