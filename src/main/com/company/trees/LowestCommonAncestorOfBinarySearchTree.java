package com.company.trees;

import static org.junit.Assert.assertEquals;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * Example 3:
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 *
 * Explanation:
 * Since BST is sorted:
 * - if both values more than root - recursively search and return right.
 * - if both values lower than root - recursively search and return left.
 * - otherwise means values are from opposite leaves (or one of them is root), then return root.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class LowestCommonAncestorOfBinarySearchTree {

    public static void main(String[] args) {
        LowestCommonAncestorOfBinarySearchTree app = new LowestCommonAncestorOfBinarySearchTree();
        TreeNode head = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        assertEquals(6, app.lowestCommonAncestor(head, new TreeNode(2), new TreeNode(8)).val);
        assertEquals(2, app.lowestCommonAncestor(head, new TreeNode(2), new TreeNode(4)).val);
        assertEquals(2, app.lowestCommonAncestor(new TreeNode(2, new TreeNode(1), null), new TreeNode(2), new TreeNode(1)).val);

        TreeNode head2 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        assertEquals(3, app.lowestCommonAncestor(head2, new TreeNode(2), new TreeNode(3)).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestorMy(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val == p.val) return p;
        if (root.val == q.val) return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
