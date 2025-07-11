package fang.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasures {

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] grid = {
                {INF, -1, 0, INF},
                {INF, INF, -1, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        System.out.println("Before ::");
        printGrid(grid);

        islandAndTreasure(grid);

        System.out.println("After :: ");
        printGrid(grid);
    }

    static void printGrid (int [][] grid) {
        for (int [] row : grid) {
            for (int cell : row) {
                if (cell == Integer.MAX_VALUE) {
                    System.out.print("∞\t");
                } else {
                    System.out.print(cell + "\t");
                }
            }
            System.out.println();
        }
    }

    // this is solved using multi source BFS
    static void islandAndTreasure(int [][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        final int  WALL = -1;
        final int TREASURE = 0;
        final int LAND = Integer.MAX_VALUE;

        int [][] directions = {
                {1,0},
                {0,1},
                {-1,0},
                {0,-1}
        };

        Queue<int []> queue = new LinkedList<>();

        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (grid[i][j] == TREASURE) {
                    queue.offer(new int [] {i,j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int [] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int [] dir : directions) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                    continue;
                }

                if (grid[newRow][newCol] == LAND) {
                    grid[newRow][newCol] = grid[row][col] + 1;
                    queue.offer(new int[] {newRow,newCol});
                }
            }
        }
    }
}
