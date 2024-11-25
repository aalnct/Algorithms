package restart.dijkstra.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    private static int [][] DIRECTIONS = {
            {-1,0} , {1,0}, {0,-1}, {0,1},
            {-1,-1}, {-1,1}, {1,-1}, {1,1}
    };

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int result = shortestPath(grid);
        System.out.println("Shortest Path Length: " + result);
    }

    // shortest steps to reach from source to destination
    static int shortestPath (int [][] grid) {
        int n = grid.length;
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1) {
            return -1;
        }

        // Queue to store the cell coordinates and path length
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int [] {0,0,1}); // start from 0,0 and path length is 1

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int pathLength = current[2];

            // check if already reached home

            if (currentRow == n-1 && currentCol == n-1) {
                return pathLength;
            }

            for (int [] directions : DIRECTIONS) {
                int newRow = currentRow + directions[0];
                int newCol = currentCol + directions[1];

                if (newRow >=0 && newRow < n && newCol >=0 && newCol < n && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 1; // first mark it as visited
                    queue.offer(new int[] {newRow,newCol, pathLength+1});
                }
            }
        }
        return -1;
    }
}
