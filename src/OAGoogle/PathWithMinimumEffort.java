package OAGoogle;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 3, 2},
                {2, 5, 8},
                {5, 7, 4}
        };
        System.out.println(pathWithMinimumEffort(heights));
    }

    private static int pathWithMinimumEffort (int [][] heights) {
        int m = heights.length; // row
        int n = heights[0].length; // column

        // Priority Queue to explore nodes with minimum efforts
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // created a boolean visited array
        boolean [] [] visited = new boolean[m][n];

        // add the source to priority queue source node --> 0,0 and effort -> 0
        priorityQueue.add(new int[] {0,0,0});

        // direction to explore neighbor's (up,down, left,right)
        int []dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};

        while (!priorityQueue.isEmpty()) {
            int []  current = priorityQueue.poll();
            int row = current[0];
            int col = current[1];
            int currentEffort = current[2];

            // destination reached
            if (row == m-1 && col == n-1) {
                return currentEffort;
            }

            visited[row][col] = true;

            // explore neighbor

            for (int i=0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                // check if neighbor is within grid bounds
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol]) {
                    int neighborEffort = Math.max(currentEffort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    priorityQueue.add(new int[] {newRow,newCol,neighborEffort});
                }
            }
        }
        return -1;
    }
}
