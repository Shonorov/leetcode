package com.company.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphUtils {

    public static void printGraphNode(Node node) {
        if (node != null) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(node.val).append(" -> [");

            if (node.neighbors != null && node.neighbors.size() > 0) {
                for (Node neighbor : node.neighbors) {
                    buffer.append(neighbor.val).append(",");
                }
                buffer.deleteCharAt(buffer.length() - 1);
            }
            buffer.append("]");
            System.out.println(buffer);
        } else {
            System.out.println("NULL");
        }
    }

    public static void printGraph(Node node) {
        if (node == null) {
            System.out.println("NULL");
            return;
        }
        List<Node> nodes = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.removeLast();
            nodes.add(current);
            if (current.neighbors != null) {
                for (Node neighbor : current.neighbors) {
                    if (!nodes.contains(neighbor) && !queue.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        for (Node n : nodes) {
            printGraphNode(n);
        }
        System.out.println("---------------");
    }
}
