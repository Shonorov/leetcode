package com.company.Trees;

/**
 * Maximum Depth of Binary Tree
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
 *
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 *
 * Explanation:
 * Recursively if node exists return 1 + maximum of the next function call for both leafs.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        MaximumDepthBinaryTree app = new MaximumDepthBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3, new TreeNode(9, null, new TreeNode(10)), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root5 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), null));
        System.out.println(app.maxDepth(root)); // 3
        System.out.println(app.maxDepth(root2)); // 2
        System.out.println(app.maxDepth(root3)); // 1
        System.out.println(app.maxDepth(null)); // 0
        System.out.println(app.maxDepth(root4)); // 3
        System.out.println(app.maxDepth(root5)); // 3
    }

    int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    int maxDepth2(TreeNode root) {
        return process(root, 1);
    }

    private int process(TreeNode node, Integer max) {
        if (node == null) return 0;
        if (node.left != null || node.right != null) {
            max++;
        }
        return Math.max(max, Math.max(process(node.left, max), process(node.right, max)));
    }
}
