package com.company.challenge2;

import com.company.Trees.TreeNode;

import java.util.*;

/**
 * Kth Smallest Element in a BST
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 * Example 3:
 * Input: root = [10,8,12,4,9,2,5], k = 3
 *        10
 *       / \
 *      8   12
 *     / \
 *    4   9
 *   / \
 *  2   5
 * Output: 5
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * Hint:
 * Try to utilize the property of a BST.
 * Try in-order traversal.
 * What if you could modify the BST node's structure?
 * The optimal runtime complexity is O(height of BST).
 *
 * Algorithm:
 * Add left nodes to the stack until its null.
 * Remove element from stack and decrease count. If count == 0 return current val.
 * Otherwise repeat the same with right node and all its left children.
 *
 * Time complexity : O(log(n) + k).
 * Space complexity : O(log(n) + k).
 */
public class KthSmallestElementInBST {

    public static void main(String[] args) {
        KthSmallestElementInBST app = new KthSmallestElementInBST();
        TreeNode test = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        TreeNode test2 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        TreeNode test3 = new TreeNode(10, new TreeNode(8, new TreeNode(4, new TreeNode(2), new TreeNode(5)), new TreeNode(9)), new TreeNode(12));
        TreeNode test4 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(app.kthSmallest(test, 1)); // 1
        System.out.println(app.kthSmallest(test2, 3)); // 3
        System.out.println(app.kthSmallest(test3, 3)); // 5
        System.out.println(app.kthSmallest(test3, 5)); // 9
        System.out.println(app.kthSmallest(test4, 2)); // 2
    }

    private int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    private int kthSmallest2(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        process(root, nodes);
        nodes.sort(Comparator.naturalOrder());
        return nodes.get(k - 1);
    }

    private void process(TreeNode node, List<Integer> nodes) {
        if (node == null) return;
        nodes.add(node.val);
        process(node.left, nodes);
        process(node.right, nodes);
    }
}
