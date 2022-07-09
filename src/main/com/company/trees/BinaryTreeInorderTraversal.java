package com.company.trees;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Binary Tree Inorder Traversal
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Explanation:
 * Traverse tree recursively or using stack + current pointer.
 * Add all left nodes value first, then current value (stack.pop()), then right node values.
 *
 * Time complexity : O(n*log(m)).
 * Space complexity : O(1).
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal app = new BinaryTreeInorderTraversal();
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assertEquals(List.of(1,3,2),app.inorderTraversal(root1));
        assertEquals(List.of(),app.inorderTraversal(null));
        assertEquals(List.of(1),app.inorderTraversal(new TreeNode(1)));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }
}
