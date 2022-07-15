package com.company.trees;

import static org.junit.Assert.assertEquals;

/**
 * Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 *
 * Example 1:
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 *
 * Example 2:
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 * Explanation:
 * Recursively check if left and right leaves are subtrees.
 * Compare recursively node and sub node on each step.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        SubtreeOfAnotherTree app = new SubtreeOfAnotherTree();
        TreeNode node1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode node2 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        assertEquals(true, app.isSubtree(node1, node2));

        TreeNode node11 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        TreeNode node22 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        assertEquals(false, app.isSubtree(node11, node22));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (compare(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean compare(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) return true;
        if (head1 == null || head2 == null || head1.val != head2.val) return false;
        return compare(head1.left, head2.left) && compare(head1.right, head2.right);
    }
}
