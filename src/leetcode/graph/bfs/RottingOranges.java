package leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int [][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(rottingOranges(grid));
    }

    private static int rottingOranges(int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int freshOranges = 0;

        // first get the count of number of fresh oranges
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1){
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i,j});
                }
            }
        }

        int totalMinutes = 0;
        int [][] directions = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };

        // since with every iteration if condition matches we will decrease the fresh oranges count
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i=0; i < size; i++){
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int [] dir : directions) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;

                    if (newX >=0 && newX < rows && newY >=0 && newY < cols
                    && grid[newX][newY] == 1) {
                        freshOranges--;
                        grid[newX][newY] = 2;
                        queue.offer(new int[] {newX,newY});
                    }
                }
            }

            totalMinutes++;
        }

        return freshOranges == 0 ? totalMinutes : -1;
    }
}
