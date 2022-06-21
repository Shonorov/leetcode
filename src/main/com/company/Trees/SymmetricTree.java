package com.company.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Symmetric Tree
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 * Explanation:
 * For each node leafs validate if outer and inner leafs values are the same simultaneously.
 *
 * Time complexity : O(n).
 * Space complexity : O(h). h - height of the tree.
 */
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree app = new SymmetricTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(app.isSymmetric(root)); // true
        System.out.println(app.isSymmetric(root2)); // false
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left != null && right != null && left.val == right.val) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;
    }

    public boolean isSymmetric2(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        process(root.left, left, true);
        process(root.right, right, false);
        return left.equals(right);
    }

    private void process(TreeNode node, List<Integer> values, boolean isLeft) {
        if (node == null) {
            values.add(null);
            return;
        }
        values.add(node.val);
        if (isLeft) {
            process(node.left, values, true);
            process(node.right, values, false);
        } else {
            process(node.right, values, false);
            process(node.left, values, true);
        }
    }
}
