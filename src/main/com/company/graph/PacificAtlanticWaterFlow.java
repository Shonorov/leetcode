package com.company.graph;

import java.util.ArrayList;
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
 * Start visiting cells for 'pacific' from top line and left line only if next > current height and not visited by 'pacific'.
 * Then start visiting cells for 'atlantic' from bottom line and right line only if next > current height and not visited by 'atlantic'.
 * If 'atlantic' already visited by 'pacific' - add to result.
 *
 * Time complexity : O(2 * n * m).
 * Space complexity : O(n * m).
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        PacificAtlanticWaterFlow app = new PacificAtlanticWaterFlow();
        assertEquals(List.of(List.of(0,4),List.of(1,4),List.of(1,3),List.of(2,2),List.of(4,0),List.of(3,0),List.of(3,1)), app.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
        assertEquals(List.of(List.of(0,1),List.of(1,1),List.of(0,0),List.of(1,0)), app.pacificAtlantic(new int[][]{{2,1},{1,2}}));
        assertEquals(List.of(List.of(0,2),List.of(1,2),List.of(2,2),List.of(2,1),List.of(1,1),List.of(2,0),List.of(1,0)), app.pacificAtlantic(new int[][]{{1,2,3},{8,9,4},{7,6,5}}));
    }

    char[][] visited;
    List<List<Integer>> result;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        visited = new char[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            visit(heights, i, 0, heights[i][0], 'p');
        }
        for (int j = 0; j < heights[0].length; j++) {
            visit(heights, 0, j, heights[0][j], 'p');
        }
        for (int i = 0; i < heights.length; i++) {
            visit(heights, i, heights[0].length - 1, heights[i][heights[0].length - 1], 'a');
        }
        for (int j = 0; j < heights[0].length; j++) {
            visit(heights, heights.length - 1, j, heights[heights.length - 1][j], 'a');
        }
        return result;
    }

    private void visit(int[][] heights, int i, int j, int previous, char direction) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length ||
                visited[i][j] == direction || previous > heights[i][j]) return;

        if (visited[i][j] == 'p' && direction == 'a') {
            result.add(List.of(i, j));
        }

        visited[i][j] = direction;
        visit(heights, i - 1, j, heights[i][j], direction);
        visit(heights, i + 1, j, heights[i][j], direction);
        visit(heights, i, j - 1, heights[i][j], direction);
        visit(heights, i, j + 1, heights[i][j], direction);
    }
}
