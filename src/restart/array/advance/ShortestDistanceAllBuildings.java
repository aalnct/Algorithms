package restart.array.advance;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceAllBuildings {

    static int [][] DIRECTIONS = {
            {1,0}, {-1,0}, {0,-1}, {0,1} // down, up, left, right respectively
    };

    public static void main(String[] args) {
        int [][] grid = {
                {1}
        };
        System.out.println(shortestDistance(grid));
    }

    static int shortestDistance (int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // maintain distance
        int [][] totalDistance = new int[rows][cols]; // maintain the minimum distance travelled to reach empty ground
        int [][] reachCount = new int[rows][cols]; // if all buildings can reach the empty ground tracker
        int buildingCount = 0;

        // count buildings and perform BFS for each
        for (int i=0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    bfs (grid,i,j,totalDistance,reachCount);
                }
            }
        }

        int minimumDistance = Integer.MAX_VALUE;
        for (int i=0; i <rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 0 && reachCount[i][j] == buildingCount) {
                    minimumDistance = Math.min(minimumDistance,totalDistance[i][j]);
                }
            }
        }

        return minimumDistance;
    }

    static void bfs (int[][] grid, int startX, int startY, int [][] totalDistance, int [][] reachCount) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited = new boolean[rows][cols];

        queue.offer(new int[] {startX,startY});
        visited[startX][startY] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // this is to make sure I first complete the iteration for current level so i have current count
            distance++;

            for (int i=0; i < size; i++) {
                int [] cells = queue.poll();

                int x = cells[0];
                int y = cells[1];

                for (int [] dir : DIRECTIONS) {
                    int newX = x + dir[0]; // moving row
                    int newY = y + dir[1]; // moving column

                    // check if we are in boundary and also check if cell
                    // is not visited, and it's an empty cell
                    if (newX >=0 && newX < rows && newY >=0 && newY < cols && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        totalDistance[newX][newY] +=distance;
                        reachCount[newX][newY]++;
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX,newY});
                    }
                }
            }
        }
    }
}
