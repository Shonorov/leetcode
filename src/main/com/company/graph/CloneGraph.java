package com.company.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static com.company.graph.GraphUtils.printGraph;

/**
 * Clone Graph
 * https://leetcode.com/problems/clone-graph/
 *
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 *
 * Example 3:
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 * Constraints:
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 *
 * Explanation:
 * Traverse all nodes BFS with queue.
 * Add all existing nodes as map key and create copy nodes as map value.
 * Add key neighbors as value neighbors.
 * If current neighbour not visited yet, add it to result and return it back to queue.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class CloneGraph {

    public static void main(String[] args) {
        CloneGraph app = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node4, node2);
        node4.neighbors = List.of(node3, node1);

        Node result1 = app.cloneGraph(node1);
        printGraph(app.cloneGraph(result1)); // [[2,4],[1,3],[2,4],[1,3]]
        printGraph(app.cloneGraph(new Node(1))); // [[]]
        printGraph(app.cloneGraph(null)); // []
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> result = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        result.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!result.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    result.put(neighbor, new Node(neighbor.val));
                }
                result.get(current).neighbors.add(result.get(neighbor));
            }
        }
        return result.get(node);
    }

    public Node cloneGraphMy(Node node) {
        if (node == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Integer, Node> nodes = new HashMap<>();
        Map<Integer, Node> result = new HashMap<>();
        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            nodes.put(current.val, current);
            result.put(current.val, new Node(current.val));
            for (Node child : current.neighbors) {
                if (!nodes.containsKey(child.val) && !queue.contains(child)) {
                    queue.add(child);
                }
            }
        }
        for (Map.Entry<Integer, Node> entry : nodes.entrySet()) {
            for (Node copy : entry.getValue().neighbors) {
                result.get(entry.getKey()).neighbors.add(result.get(copy.val));
            }

        }
        return result.get(node.val);
    }
}

