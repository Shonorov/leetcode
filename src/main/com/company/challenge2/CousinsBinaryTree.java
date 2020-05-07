package com.company.challenge2;

/**
 * Cousins in Binary Tree
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 * Example 1:
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 * Example 2:
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 *
 * Example 3:
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 * Note:
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 *
 * Explanation:
 * Recursively search tree nodes. Pass parent and current length to the next call;
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class CousinsBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        CousinsBinaryTree app = new CousinsBinaryTree();
        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        TreeNode test2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));
        TreeNode test3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(app.isCousins(test, 4, 3)); // false
        System.out.println(app.isCousins(test2, 5, 4)); // true
        System.out.println(app.isCousins(test3, 2, 3)); // false
    }

    private class Data {
        int x;
        int y;
        int xDepth = 0;
        int yDepth = 0;
        TreeNode xNode = new TreeNode(0);
        TreeNode yNode = new TreeNode(0);

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isCousins(TreeNode root, int x, int y) {
        Data result = new Data(x, y);
        processNode(root, 0, null, result);
        return result.xDepth == result.yDepth && result.xNode.val != result.yNode.val;
    }

    private void processNode(TreeNode node, int depth, TreeNode parent, Data result) {
        if (node == null) {
            return;
        }
        if (node.val == result.x) {
            result.xNode = parent;
            result.xDepth = depth;
        }
        if (node.val == result.y) {
            result.yNode = parent;
            result.yDepth = depth;
        }
        processNode(node.left, depth + 1, node, result);
        processNode(node.right, depth + 1, node, result);
    }
}
