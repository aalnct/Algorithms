package restart.array.intermidiate;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int [][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(totalMinutes(grid));
    }

    // in a grid, there are three conditions
    // 0 for no oranges
    // 1 for fresh oranges
    // 2 for rotten oranges

    static int totalMinutes (int [][] grid) {
        int totalMinutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int freshOranges = 0;
        Queue<int []> queue = new LinkedList<>();

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else {
                    if (grid[i][j] == 2) {
                        queue.offer(new int [] {i,j});
                    }
                }
            }
        }
        int [][] directions = {
                {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while (!queue.isEmpty() && freshOranges != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int x = current[0];
                int y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                    }
                }
            }
            totalMinutes++;
        }
        return freshOranges == 0 ? totalMinutes : -1;
    }
}
