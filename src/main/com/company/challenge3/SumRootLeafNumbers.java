package com.company.challenge3;

import com.company.Trees.TreeNode;

/**
 * Sum Root to Leaf Number
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * Example:
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * Algorithm:
 * Traverse tree and pass number-so-far to the next level.
 * Append current node value to the end.
 * If it is leaf node sum number-so-far to the whole sum.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class SumRootLeafNumbers {

    public static void main(String[] args) {
        SumRootLeafNumbers app = new SumRootLeafNumbers();
        TreeNode test = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode test2 = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        TreeNode test3 = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0, new TreeNode(6), null));
        System.out.println(app.sumNumbers(test)); // 25
        System.out.println(app.sumNumbers(test2)); // 1026
        System.out.println(app.sumNumbers(test3)); // 1392
    }

    private int sumNumbers(TreeNode root) {
        sum = 0;
        process(root, 0);
        return sum;
    }

    private int sum;

    private void process(TreeNode node, int value) {
        if (node != null) {
            value = value * 10 + node.val;
            if (node.left == null && node.right == null) {
                sum += value;
            } else {
                process(node.left, value);
                process(node.right, value);
            }
        }
    }
}
