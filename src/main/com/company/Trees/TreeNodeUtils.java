package com.company.Trees;

import java.util.*;

public class TreeNodeUtils {

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("NULL");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
