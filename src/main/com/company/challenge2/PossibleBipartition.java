package com.company.challenge2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Possible Bipartition
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 * Example 1:
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 *
 * Example 2:
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Example 3:
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 * Note:
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 *
 * Algorithm:
 * Create map of node dislikes.
 * Try add nodes to the Map<node, nodeColor>.
 * Try to add missing node with one color (0) and all it`s dislikes with another color (1);
 * If node already present in Map with another color - then Bipartition impossible.
 *
 * Time complexity : O(n + m). m - dislikes count.
 * Space complexity : O(n + m). m - dislikes count.
 */
public class PossibleBipartition {

    public static void main(String[] args) {
        PossibleBipartition app = new PossibleBipartition();
        int[][] test = {{1,2},{1,3},{2,4}};
        int[][] test2 = {{1,2},{1,3},{2,3}};
        int[][] test3 = {{1,2},{2,3},{3,4},{4,5},{1,5}};
        System.out.println(app.possibleBipartition(4, test)); // True
        System.out.println(app.possibleBipartition(3, test2)); // False
        System.out.println(app.possibleBipartition(5, test3)); // False
    }

    Set<Integer>[] graph;
    Map<Integer, Integer> nodeColors;

    private boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        nodeColors = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (!nodeColors.containsKey(i) && !addNode(i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean addNode(int node, int color) {
        if (nodeColors.containsKey(node)) {
            return nodeColors.get(node) == color;
        }
        nodeColors.put(node, color);
        for (int neighbour : graph[node]) {
            if (!addNode(neighbour, color ^ 1)) {
                return false;
            }
        }
        return true;
    }
}
