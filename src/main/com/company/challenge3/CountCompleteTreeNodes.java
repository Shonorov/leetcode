package com.company.challenge3;

import com.company.trees.TreeNode;

/**
 * Count Complete Tree Nodes
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2 ^ h nodes inclusive at the last level h.
 *
 * Example:
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * Output: 6
 *
 * Algorithm:
 * Get heights of left and right nodes by traversing only left nodes (they are always here for complete tree).
 * If leftHeight == rightHeight means left tree is full.
 * We can add its node count (Math.pow(2, leftHeight) or 1 << height) to the right leaf nodes count.
 * Otherwise right leaf tree is full and its height = leftHeight - 1.
 * Count left leaf nodes count recursively and add  right node count (Math.pow(2, leftHeight - 1) or 1 << (height - 1)).
 *
 * Time complexity : O(log(n) ^ 2).
 * Space complexity : O(1).
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        CountCompleteTreeNodes app = new CountCompleteTreeNodes();
        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(app.countNodes(test)); // 6
    }

    private int countNodes(TreeNode root) {
        int leftHeight = getHeight(root);
        if (leftHeight < 0) return 0;
        int rightHeight = getHeight(root.right);

        if (rightHeight == leftHeight - 1) {
//            return (1 << leftHeight) + countNodes(root.right);
            return ((int) Math.pow(2, leftHeight)) + countNodes(root.right);
        } else {
//            return countNodes(root.left) + (1 << (leftHeight - 1));
            return countNodes(root.left) + ((int) Math.pow(2, leftHeight - 1));
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) return -1;
        return 1 + getHeight(node.left);
    }
}
