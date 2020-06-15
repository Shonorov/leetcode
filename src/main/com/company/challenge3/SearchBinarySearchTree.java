package com.company.challenge3;

import com.company.Trees.TreeNode;
/**
 * Search in a Binary Search Tree
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3361/
 *
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node.
 * If such node doesn't exist, you should return NULL.
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * You should return this subtree:
 *
 *       2
 *      / \
 *     1   3
 *
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.*
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 *
 * Algorithm:
 * Traverse tree until node is null or with given value.
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(1).
 */
public class SearchBinarySearchTree {

    public static void main(String[] args) {
        SearchBinarySearchTree app = new SearchBinarySearchTree();
        TreeNode test = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        System.out.println(app.searchBST(test, 2)); // 1 <- 2 -> 3
        System.out.println(app.searchBST(test, 5)); // NULL
        System.out.println(app.searchBST(null, 2)); // NULL
    }

    private TreeNode searchBST(TreeNode root, int val) {
        TreeNode result = root;
        while (result != null && result.val != val) {
            result = val < result.val ? result.left : result.right;
        }
        return result;
    }
}
