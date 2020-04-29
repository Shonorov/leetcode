package com.company.challange;

/**
 * Binary Tree Maximum Path Sum
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3314/
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 * Explanation:
 * Recursively calculate max sum for each node.
 * Pass object with max value to the method.
 * Node max sum: maxSum = Math.max(Math.max(maxLeft, maxRight) + node.val, node.val);
 * Result = Math.max(Math.max(maxLeft + node.val + maxRight, result.val), maxSum);
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class BinaryTreeMaximumPathSum {

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
        BinaryTreeMaximumPathSum app = new BinaryTreeMaximumPathSum();
        TreeNode test = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode test2 = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode test3 = new TreeNode(1, new TreeNode(-2), new TreeNode(3));
        TreeNode test4 = new TreeNode(9, new TreeNode(6), new TreeNode(-3, new TreeNode(-6), new TreeNode(2, new TreeNode(2, new TreeNode(-6, new TreeNode(-6), null), new TreeNode(-6)), null)));
        System.out.println(app.maxPathSum(test)); // 6
        System.out.println(app.maxPathSum(test2)); // 42
        System.out.println(app.maxPathSum(test3)); // 4
        System.out.println(app.maxPathSum(test4)); // 16
    }

    class MaxSum {
        Integer val;

        MaxSum(Integer val) {
            this.val = val;
        }
    }

    private int maxPathSum(TreeNode root) {
        MaxSum result = new MaxSum(root.val);
        calcNode(root, result);
        return result.val;
    }

    private int calcNode(TreeNode node, MaxSum result) {
        if (node == null) {
            return 0;
        }
        int maxLeft = calcNode(node.left, result);
        int maxRight = calcNode(node.right, result);
        int currentPathSum = maxLeft + node.val + maxRight;
        int maxSum = Math.max(Math.max(maxLeft, maxRight) + node.val, node.val);
        result.val = Math.max(Math.max(currentPathSum, result.val), maxSum);
        return maxSum;
    }
}
