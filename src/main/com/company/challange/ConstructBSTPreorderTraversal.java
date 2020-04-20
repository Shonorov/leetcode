package com.company.challange;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3305/
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * Recall that a binary search tree is a binary tree where for every node, any descendant of node.
 * left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * Note:
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 *
 * Explanation:
 * Create stack and put first element as root.
 * If top element value is greater than array's next set left node.
 * If top element value is lower than array's next remove node from stack and set its right node.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */

public class ConstructBSTPreorderTraversal {

    public static void main(String[] args) {
        ConstructBSTPreorderTraversal app = new ConstructBSTPreorderTraversal();
        int[] test = {8,5,1,7,10,12};
        TreeNode root = app.bstFromPreorder(test);

        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(5);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(7);
        node.right.right = new TreeNode(12);

        app.printTree(root); // 8 5 10 1 7 12
    }

    private TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = preorder.length > 0 ? new TreeNode(preorder[0]) : new TreeNode(0);
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode current = null;

            // if current value is right node (greater then last node val)
            // remove node from stack
            while (!nodes.empty() && preorder[i] > nodes.peek().val) {
                current = nodes.pop();
            }

            // if current not null, then its right node value
            if (current != null) {
                current.right = new TreeNode(preorder[i]);
                nodes.push(current.right);
            // if current is null, then value is left, set left node to the stack top node
            } else {
                current = nodes.peek();
                current.left = new TreeNode(preorder[i]);
                nodes.push(current.left);
            }
        }
        return root;
    }

    private void printTree(TreeNode root) {
        Queue<TreeNode> nodes = new ConcurrentLinkedDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.remove();
            System.out.print(current.val + " ");
            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }
    }
}
