package com.company.challenge2;

import java.util.ArrayList;
import java.util.List;

/**
 * Course Schedule
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 * Constraints:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 *
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 *
 * Algorithm:
 * Create graph array with nodes and its neighbours. Also initialise array of node visited states.
 * int[] 0 - not visited, 1 - visited, 2 - finished all node neighbours check.
 * For all unvisited nodes and its neighbours perform check if graph is cycled.
 * Graph is cycled if any of its neighbours check is finished.
 *
 * Time complexity : O(n + m). n - number of nodes, m - number of edges.
 * Space complexity : O(n + m). n - number of nodes, m - number of edges.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule app = new CourseSchedule();
        int[][] test = {{1,0}};
        int[][] test2 = {{1,0},{0,1}};
        System.out.println(app.canFinish(2, test)); // true
        System.out.println(app.canFinish(2, test2)); // false
    }

    private List<Integer>[] edges;
    private int[] visited; // 0 - not visited, 1 - visited, 2 - finished;

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            edges[prerequisite[0]].add(prerequisite[1]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCycled(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCycled(int node) {
        visited[node] = 1;
        for (int neighbour : edges[node]) {
            if (visited[neighbour] == 0) {
                if (isCycled(neighbour)) {
                    return true;
                }
            } else if (visited[neighbour] != 2) {
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }
}
