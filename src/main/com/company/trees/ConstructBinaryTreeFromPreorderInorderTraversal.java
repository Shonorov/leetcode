package com.company.trees;

import java.util.HashMap;
import java.util.Map;

import static com.company.trees.TreeNodeUtils.printTree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 * Explanation:
 * Build map of inorder value indexes outside of method.
 * Store and init preorder index value outside of method.
 * Recursively for all preorder values narrow inorder index ranges for left and right subtrees and construct tree nodes.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ConstructBinaryTreeFromPreorderInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderInorderTraversal app = new ConstructBinaryTreeFromPreorderInorderTraversal();
        printTree(app.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7})); // [3,9,20,null,null,15,7]
        printTree(app.buildTree(new int[]{3,9,1,2,20,15,7}, new int[]{1,9,2,3,15,20,7})); // [3,9,20,1,2,15,7]
        printTree(app.buildTree(new int[]{-1}, new int[]{-1})); // [-1]
    }

    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
           inorderIndexMap.put(inorder[i], i);
        }
        return constructNode(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructNode(int[] preorder, int leftInorderIndex, int rightInorderIndex) {
        if (leftInorderIndex > rightInorderIndex) return null;

        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        root.left = constructNode(preorder, leftInorderIndex, inorderIndexMap.get(root.val) - 1);
        root.right = constructNode(preorder, inorderIndexMap.get(root.val) + 1, rightInorderIndex);
        return root;
    }
}
