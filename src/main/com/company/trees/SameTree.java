package com.company.trees;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Same Tree
 * https://leetcode.com/problems/same-tree/
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 *
 * Explanation:
 * Compare each node recursively .
 * Null nodes are equal!
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class SameTree {

    public static void main(String[] args) {
        SameTree app = new SameTree();
        assertEquals(true, app.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        assertEquals(false, app.isSameTree(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, null, new TreeNode(2))));
        assertEquals(false, app.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)), new TreeNode(1, new TreeNode(1), new TreeNode(2))));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    private boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return compare(p.left, q.left) && compare(p.right, q.right);
    }

    public boolean isSameTreeLists(TreeNode p, TreeNode q) {
        List<Integer> nodesP = new ArrayList<>();
        List<Integer> nodesQ = new ArrayList<>();
        traverse(p, nodesP);
        traverse(q, nodesQ);
        if (nodesP.size() != nodesQ.size()) return false;
        for (int i = 0; i < nodesP.size(); i++) {
            if (!nodesP.get(i).equals(nodesQ.get(i))) return false;
        }
        return true;
    }

    private void traverse(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            nodes.add(Integer.MAX_VALUE);
            return;
        }
        nodes.add(node.val);
        traverse(node.left, nodes);
        traverse(node.right, nodes);
    }


}
