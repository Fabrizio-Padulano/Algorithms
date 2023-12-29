package org.padulano.fabrizio.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * Output: 6
 */
public class MaxAreaOfIslands {
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c, Set<String> visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }
        if (grid[r][c] == 0) return 0;

        String position = r + "-" + c;

        if (visited.contains(position)) return 0;

        visited.add(position);

        int areaSum = 1;
        areaSum += dfs(grid, r - 1, c, visited);
        areaSum += dfs(grid, r + 1, c, visited);
        areaSum += dfs(grid, r, c - 1, visited);
        areaSum += dfs(grid, r, c + 1, visited);

        return areaSum;
    }
}
