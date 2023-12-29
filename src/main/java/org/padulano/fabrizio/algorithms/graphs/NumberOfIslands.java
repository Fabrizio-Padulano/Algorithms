package org.padulano.fabrizio.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j, visited)) count++;
            }
        }

        return count;
    }

    private boolean dfs(char[][] grid, int r, int c, Set<String> visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }

        if (grid[r][c] == '0') return false;

        String position = r + "-" + c;
        if (visited.contains(position)) return false;

        visited.add(position);

        dfs(grid, r - 1, c, visited);
        dfs(grid, r + 1, c, visited);
        dfs(grid, r, c - 1, visited);
        dfs(grid, r, c + 1, visited);

        return true;
    }
}
