package com.company.challange3;

import com.company.Trees.TreeNode;
import com.company.Trees.TreeNodeUtils;

/**
 * Invert Binary Tree
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
 *
 * Invert a binary tree.
 *
 * Example:
 * Input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Algorithm:
 * Recursively if node is not null change left and right children starting from root.
 *
 * Time complexity : O(m).
 * Space complexity : O(m).
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree app = new InvertBinaryTree();
        TreeNode test = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNodeUtils.printTree(app.invertTree(test)); // 7 <- 4 -> 2  9 <- 7 -> 6  3 <- 2 -> 1  NULL <- 9 -> NULL  NULL <- 6 -> NULL  NULL <- 3 -> NULL  NULL <- 1 -> NULL
    }

    private TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }

    private void invertNode(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertNode(node.left);
        invertNode(node.right);
    }
}
