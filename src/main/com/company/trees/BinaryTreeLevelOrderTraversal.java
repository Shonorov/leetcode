package com.company.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Binary Tree Level Order Traversal
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 *
 * Explanation:
 * Create map of nodes by level recursively.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal app = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        TreeNode root4 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(app.levelOrder(root)); // [[3],[9,20],[15,7]]
        System.out.println(app.levelOrder(root2)); // [[1]]
        System.out.println(app.levelOrder(null)); // []
        System.out.println(app.levelOrder(root3)); // [[1],[2,3],[4,5]]
        System.out.println(app.levelOrder(root4)); // [[1],[2,3],[4,5]]
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        process(root, 1, levels);
        return new ArrayList<>(levels.values());
    }

    private void process(TreeNode node, int level, Map<Integer, List<Integer>> levels) {
        if (node == null) return;
        if (levels.containsKey(level)) {
            levels.get(level).add(node.val);
        } else {
            levels.put(level, new ArrayList<>(List.of(node.val)));
        }
        process(node.left, level + 1, levels);
        process(node.right, level + 1, levels);
    }

}
