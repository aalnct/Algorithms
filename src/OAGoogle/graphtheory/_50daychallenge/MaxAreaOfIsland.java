package OAGoogle.graphtheory._50daychallenge;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int [][] grid = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {0,0,1,0,0},
                {0,0,0,1,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    private static int maxAreaOfIsland(int [][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                int area = bfs (grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    private static int bfs (int [][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int r = current[0];
            int c = current[1];

            if (r >=0 && r < rows && c >=0 && c < cols && grid[r][c] == 1) {
                grid[r][c] = 0; // mark node as visted so we do not hve visit it again ...
                area++;

                int [][] directions = {
                        {-1,0}, {1,0}, {0,-1}, {0,1}
                };

                for (int [] d : directions) {
                    int newRow = d[0] + r;
                    int newCol = d[1] + c;

                    if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols) {
                        queue.offer(new int [] {newRow,newCol});
                    }
                }
            }
        }

        return area;
    }
}
