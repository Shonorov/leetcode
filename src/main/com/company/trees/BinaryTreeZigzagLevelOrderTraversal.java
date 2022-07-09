package com.company.trees;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 *
 * Explanation:
 * Recursively traverse tree left to right (ascending values) passing current level.
 * For even level add value inverse (index = 0).
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal app = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        assertEquals(List.of(List.of(3),List.of(20,9),List.of(15,7)), app.zigzagLevelOrder(root1));
        assertEquals(List.of(List.of(1),List.of(3,2),List.of(4,5)), app.zigzagLevelOrder(root2));
        assertEquals(List.of(List.of(1)), app.zigzagLevelOrder(new TreeNode(1)));
        assertEquals(List.of(), app.zigzagLevelOrder(null));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }

    private void traverse(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() <= level) {
            result.add(level, new LinkedList<>());
        }
        int index = level % 2 == 0 ? result.get(level).size() : 0;
        result.get(level).add(index, node.val);
        traverse(node.left, result, level + 1);
        traverse(node.right, result, level + 1);
    }
}
