package org.padulano.fabrizio.algorithms.graphs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Input: grid = [
 * [2,1,1],
 * [1,1,0],
 * [0,1,1]
 * ]
 * Output: 4
 */
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0, fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh += 1;
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] orange = q.poll();
                int r = orange[0], c = orange[1];
                for (int[] dir : dirs) {
                    int x = r + dir[0], y = c + dir[1];
                    if (0 <= x && x < grid.length &&
                            0 <= y && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                        fresh -= 1;
                    }
                }
            }
            time++;

        }

        return fresh == 0 ? time : -1;
    }
}
