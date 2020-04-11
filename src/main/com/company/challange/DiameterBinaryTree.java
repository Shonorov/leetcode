package com.company.challange;

/**
 * Diameter of Binary Tree
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree.
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3]
 *
 * The length of path between two nodes is represented by the number of edges between them.
 *
 * Explanation:
 * Diameter is the sum of both leaf depths plus 1.
 * Depth of node is the maximum of leaf depths plus 1.
 * Maximum diameter stored in the class field.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class DiameterBinaryTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private int ans;

    public static void main(String[] args) {
        DiameterBinaryTree app = new DiameterBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(app.diameterOfBinaryTree(root)); // 3
    }

    private int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        ans = Math.max(ans, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
