package neetcode150.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int [][] grid = {
                {1,0,1},
                {0,2,0},
                {1,0,1}
        };
        System.out.println(rottingOranges(grid));
    }

    static int rottingOranges (int [][] grid) {
        int totalMinutes = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int freshOranges = 0;
        Queue<int []> queue = new LinkedList<>();

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int [] {i,j});
                }
            }
        }

        int [][] DIRECTIONS = {
                {1,0} ,  {-1,0} ,  {0,1}, {0,-1}
        };

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();

            for (int i=0;  i<size ; i++) {
                int [] current = queue.poll();

                for (int [] dir : DIRECTIONS) {
                    int newR = dir[0] + current[0];
                    int newC = dir[1] + current[1];

                    if (newR >=0 && newR < rows && newC >=0 && newC < cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        queue.offer(new int [] {newR,newC});
                        freshOranges--;

                    }
                }
            }
            totalMinutes++;
        }
        return freshOranges == 0 ? totalMinutes : -1;
    }

}
