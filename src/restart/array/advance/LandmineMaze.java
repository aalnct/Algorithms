package restart.array.advance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LandmineMaze {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, -1, 0},
                {0, 1, 0, -1},
                {0, 0, 0, 0},
                {1, -1, 0, 0}
        };

        int [][] result = mazeLandmine(maze);
        for (int [] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static int [][] DIRECTIONS = {
            {-1,0}, {1,0}, {0,1}, {0,-1}
    };

    private static int [][] mazeLandmine ( int [][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        int [][] distance = new int[rows][cols];
        // Initialize distance with Integer Max_Value
        for (int i=0; i < rows; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // now initialize a queue for BFS traversal
        Queue<int []> queue = new LinkedList<>();
        // update the queue with the landmine position
        for (int i=0; i< rows; i++) {
            for (int j=0; j < cols; j++) {
                if (maze[i][j] == 1) {
                    distance[i][j] = 0;
                    queue.offer(new int [] {i,j});
                }
            }
        }

        // Start BFS traversal

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = distance[row][col];

            // check neighbors
            for (int [] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // check if they are with in the bound

                if (newRow >=0 &&newRow < rows && newCol >=0 && newCol < cols
                && maze[newRow][newCol] == 0) { // also last check means if they are not visited, to avoid any duplicates
                    if (distance[newRow][newCol] > dist + 1) { // i.e. integer max value
                        distance[newRow][newCol] = dist + 1;
                        queue.offer(new int [] {newRow,newCol});
                    }
                }
            }
        }


        // those who are not reachable update those to -1
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (distance[i][j] == Integer.MAX_VALUE) {
                    distance[i][j] = -1;
                }
            }
        }
        return distance;
    }
}
