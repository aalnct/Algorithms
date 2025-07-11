package fang.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] height = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        List<List<Integer>> result = waterFlow(height);
        System.out.println("Cells that can reach both oceans:");

        for (List<Integer> cell : result) {
            System.out.println("[" + cell.get(0) + "," + cell.get(1) + "]");
        }
    }

    static List<List<Integer>> waterFlow (int [][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean [][] pacificReachable = new boolean[m][n];
        boolean [][] atlanticReachable = new boolean[m][n];

        List<List<Integer>> result = new ArrayList<>();

        // first update where pacific can reach
        // we are going reverse, means seeing where ocean can reach
        for (int i=0; i < m; i++) {
            dfs(heights, i,0, pacificReachable, heights[i][0]); // left border
        }
        for (int j=0; j < n; j++) {
            dfs(heights,0,j, pacificReachable, heights[0][j]); // top border
        }

        // updating atlantic border
        for (int i=0; i < m; i++) {
            dfs(heights, i,n-1, atlanticReachable, heights[i][n-1]);
        }
        for (int j=0; j < n; j++) {
            dfs(heights, m-1,j, atlanticReachable, heights[m-1][j]);
        }


        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    static void dfs (int [][] height, int row, int col, boolean [][] reachable, int prev) {

        // boundary conditions
        if (row < 0 || row >= height.length || col < 0 || col >= height[0].length) {
            return;
        }

        if (height[row][col] < prev) {
            return;
        }

        if (reachable[row][col]) {
            return;
        }

        reachable[row][col] = true;

        dfs(height, row + 1, col, reachable, height[row][col]);
        dfs(height, row - 1, col, reachable, height[row][col]);
        dfs(height, row, col + 1, reachable, height[row][col]);
        dfs(height, row, col - 1, reachable, height[row][col]);

    }

}
