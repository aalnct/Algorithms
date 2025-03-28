package neetcode150.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {

    public static void main(String[] args) {
        char  [][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numberOfIslands(grid));
    }

    static int numberOfIslands (char [][] grid) {
        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int [][] DIRECTIONS = {
                {1,0}, {-1,0} , {0,1} , {0,-1}
        };

        for (int i=0;  i< rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';


                    Queue<int []> queue = new LinkedList<>();
                    queue.offer(new int [] {i,j});

                    while (!queue.isEmpty()) {
                        int [] current = queue.poll();

                        int currRow = current[0];
                        int currCol = current[1];

                        for (int [] dir : DIRECTIONS) {
                            int newRow = currRow + dir[0];
                            int newCol = currCol + dir[1];

                            if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == '1') {
                                queue.offer(new int [] {newRow,newCol});
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
