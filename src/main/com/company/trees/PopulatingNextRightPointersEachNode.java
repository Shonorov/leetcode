package com.company.trees;

import static com.company.trees.TreeNodeUtils.printTree;

/**
 * Populating Next Right Pointers in Each Node
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/789/
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2^12 - 1].
 * -1000 <= Node.val <= 1000
 *
 * Explanation:
 * For each node from root level set current.left.next = current.right.
 * Assign leftmost node as level start and if current.next assigned on previous level,
 * then current.right.next = current.next.left
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class PopulatingNextRightPointersEachNode {

    public static void main(String[] args) {
        PopulatingNextRightPointersEachNode app = new PopulatingNextRightPointersEachNode();
        PerfectTreeNode root1 = new PerfectTreeNode(1, new PerfectTreeNode(2, new PerfectTreeNode(4), new PerfectTreeNode(5)), new PerfectTreeNode(3, new PerfectTreeNode(6), new PerfectTreeNode(7)));
        printTree(app.connect(root1));
        printTree(app.connect(null));
    }

    public PerfectTreeNode connect(PerfectTreeNode root) {
        PerfectTreeNode levelStart = root;
        while (levelStart != null) {
            PerfectTreeNode current = levelStart;
            while (current != null) {
                if (current.left != null) current.left.next = current.right;
                if (current.right != null && current.next != null) current.right.next = current.next.left;
                current = current.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    public PerfectTreeNode connectRecursive(PerfectTreeNode root) {
        if (root == null || root.left == null || root.right == null) return root;

        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;

        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;

    }

}
