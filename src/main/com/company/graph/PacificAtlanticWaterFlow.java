package com.company.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells.
 * You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west
 * if the neighboring cell's height is less than or equal to the current cell's height.
 * Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 * Example 1:
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *
 * Example 2:
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 *
 * Constraints:
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 *
 * Explanation:
 *
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        PacificAtlanticWaterFlow app = new PacificAtlanticWaterFlow();
        assertEquals(List.of(List.of(0,4),List.of(1,3),List.of(1,4),List.of(2,2),List.of(3,0),List.of(3,1),List.of(4,0)), app.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
        assertEquals(List.of(List.of(0,0),List.of(0,1),List.of(1,0),List.of(1,1)), app.pacificAtlantic(new int[][]{{2,1},{1,2},{2,4,5,3,1}}));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (isTop(heights, i, j, true) && isTop(heights, i, j, false)) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private boolean isTop(int[][] heights, int i, int j, boolean toTop) {
        LinkedList<int[]> coordinates = new LinkedList<>();
        coordinates.add(new int[]{i,j});
        while (!coordinates.isEmpty()) {
            int[] current = coordinates.removeFirst();
            if (toTop && (current[0] < 0 || current[1] < 0 )) {
                return true;
            }
            if (!toTop && (current[0] >= heights.length || current[1] >= heights[0].length)) {
                return true;
            }
            if (!(current[0] == i && current[1] == j)) {
                // TODO
                if ( heights[current[0]][current[1]] >= heights[i][j]) continue;
            }
            if (toTop) {
                coordinates.add(new int[]{current[0] - 1, current[1]});
                coordinates.add(new int[]{current[0], current[1] - 1});
            } else {
                coordinates.add(new int[]{current[0] + 1, current[1]});
                coordinates.add(new int[]{current[0], current[1] + 1});
            }
        }
        return false;
    }
}
