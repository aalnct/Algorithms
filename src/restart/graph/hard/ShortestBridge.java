package restart.graph.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    static int [][] DIRECTIONS = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };
        System.out.println(shortestBridge(grid));
    }

    // using DFS - find the first island
    // using BFS - find the second island, and number of steps it took to find second island is the shortest distance/bridge

    static int shortestBridge (int [][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        boolean islandFound = false;

        for (int i=0; i < m; i++) {
            if (islandFound) break;
            for (int j=0;j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid,i,j,queue);
                    islandFound = true;
                    break;
                }
            }
        }
        // will perform BFS here ...
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }

                    if (grid[x][y] == 1) {
                        return steps;
                    }

                    if (grid[x][y] == 0) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    static void dfs (int [][] grid, int i, int j, Queue<int[]> queue) {
        int m = grid.length;
        int n = grid[0].length;

        if (i <0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;

        queue.offer(new int [] {i,j});

        for (int [] dir : DIRECTIONS) {
            dfs(grid, i + dir[0], j + dir[1], queue);
        }
    }
}
