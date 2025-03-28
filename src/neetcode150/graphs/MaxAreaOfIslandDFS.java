package neetcode150.graphs;

public class MaxAreaOfIslandDFS {

    public static void main(String[] args) {
        int [][] grid = {

                {0,1,1,0,1},
                {1,0,1,0,1},
                {0,1,1,0,1},
                {0,1,0,0,1}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

    static int maxAreaOfIsland (int [][] grid) {
        int maxArea = 0;

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = maxAreaDFS (grid,i,j);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    static int maxAreaDFS (int [][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
        || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + maxAreaDFS (grid ,row+1, col) + maxAreaDFS (grid, row-1, col)
                + maxAreaDFS (grid,row, col + 1) + maxAreaDFS(grid, row, col -1);
    }
}
