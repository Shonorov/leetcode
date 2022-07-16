package com.company.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.company.trees.TreeNodeUtils.printTree;

/**
 * Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 *
 * Explanation:
 * Serialize using bread first search, add leaves not nodes each iteration.
 * Add delimiters and null values for each sub node.
 * Deserialize using bread first search too. Select by two values from array starting from 1.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree app = new SerializeAndDeserializeBinaryTree();
        TreeNode head = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String encoded = app.serialize(head);
        printTree(app.deserialize(encoded)); // [1,2,3,null,null,4,5]

        String encoded2 = app.serialize(null);
        printTree(app.deserialize(encoded2)); // null

        String encoded3 = app.serialize(new TreeNode(1, new TreeNode(2), null));
        printTree(app.deserialize(encoded3)); // [1,2,null]
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    // Generate preorder string
    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) return str.append(NULL);
        str.append(root.val).append(DELIM);
        serial(str, root.left).append(DELIM);
        serial(str, root.right);
        return str;
    }

    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(DELIM))));
    }

    // Use queue to simplify position move
    private TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if (NULL.equals(val)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }



    private static final String NULL = "*";
    private static final String DELIM = ";";

    // Encodes a tree to a single string.
    public String serializeMy(TreeNode root) {
        if (root == null) return "";
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer result = new StringBuffer(root.val + DELIM);
        while (!queue.isEmpty()) {
            TreeNode current = queue.removeFirst();
            if (current.left != null) {
                queue.add(current.left);
                result.append(current.left.val).append(DELIM);
            } else {
                result.append(NULL).append(DELIM);
            }
            if (current.right != null) {
                queue.add(current.right);
                result.append(current.right.val).append(DELIM);
            } else {
                result.append(NULL).append(DELIM);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeMy(String data) {
        String[] nodes = data.split(DELIM);
        if (nodes[0].length() == 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode current = queue.removeFirst();

            if (!nodes[i].equals(NULL)) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            } else {
                current.left = null;
            }

            if (!nodes[i + 1].equals(NULL)) {
                current.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.add(current.right);
            } else {
                current.right = null;
            }
        }
        return root;
    }
}
