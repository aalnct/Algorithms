package restart.gemini.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numberOfIslands_dfs(grid));

        char grid1 [][] = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numberOfIslands_bfs(grid1));

    }

    // using DFS
    static int numberOfIslands_dfs (char [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int numberOfIslands = 0;

        for (int i = 0; i <rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    static void dfs(char [][] grid, int row, int col) {


        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }

    static int numberOfIslands_bfs (char [][] grid) {
        int numberOfIslands = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=0;  i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    bfs(grid,i,j);
                }
            }
        }
        return numberOfIslands;
    }

    static void bfs (char [][] grid, int rows, int cols) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {rows, cols});

        while (!queue.isEmpty()) {
            int [] current = queue.poll();

            int r = current[0];
            int c = current[1];

            if (r >=0 && r < row && c >=0 && c < col && grid[r][c] == '1') {
                grid[r][c] = '0'; // marking it as visited

                int [][] distance = {
                        {1,0}, {0,1}, {-1,0}, {0,-1}
                };

                for (int [] d : distance) {
                    int newRow = d [0] + r;
                    int newCol = d[1] + c;

                    queue.offer(new int [] {newRow,newCol});
                }
            }
        }
    }
}
