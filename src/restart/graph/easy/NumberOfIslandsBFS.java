package restart.graph.easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {

    public static void main(String[] args) {
        char [][]  grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numberOfIslands(grid));
    }

    static int numberOfIslands (char [][] grid) {
        int numberOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    bfs(grid,i,j);
                }
            }
        }
        return numberOfIslands;
    }

    static void bfs (char [][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {i,j});

        grid[i][j] = '0';

        int [] [] directions = {
                {1,0}, {-1,0},{0,-1},{0,1}
        };

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for (int [] direction : directions) {
                int newRow = direction[0] + currentRow;
                int newCol = direction[1] + currentCol;

                if (newRow >=0 && newRow < rows
                && newCol >= 0 && newCol < cols &&
                grid[newRow][newCol] == '1') {
                    queue.offer(new int [] {newRow,newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
}
