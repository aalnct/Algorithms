package OAGoogle.graphtheory._50daychallenge;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char [][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','0'}
        };

        System.out.println(numberOfIslands(grid));
    }

    static int numberOfIslands(char [][] grid) {
        int numberOfIslands = 0;

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    bfs(grid,i,j);
                }
            }
        }
        return numberOfIslands;
    }

    public static void bfs (char [][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int r = current[0];
            int c = current[1];

            if (r >=0 && r < rows && c >=0 && c < cols &&
                        grid[r][c] == '1') {
                grid[r][c] = '0'; // marking it as visited ...
                int [][] directions = {
                        {-1,0} , {1,0} , {0,-1}, {0,1}
                };

                for (int [] d : directions) {
                    int newRow = r + d[0];
                    int newCol = c + d[1];

                    queue.offer(new int[] {newRow,newCol});
                }
            }
        }
    }
}
