package OAGoogle.graphtheory._50daychallenge;

public class MaxAreaIsland {

    public static void main(String[] args) {
        int [][] grid = {
                {0,0,0,1,1,1,0,0},
                {0,0,0,1,1,1,0,0}
        };
        System.out.println(maxArea(grid));
    }


    public static int maxArea(int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid [i][j] == 1) {
                    int currentArea = dfs(grid,i,j);

                    maxArea = Math.max(currentArea,maxArea);
                }
            }
        }
        return maxArea;
    }


    private static int dfs (int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row <0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0; // marking visited  ...

        int area = 1;

        area += dfs(grid,row+1,col);
        area += dfs(grid,row-1, col);
        area += dfs(grid,row,col+1);
        area += dfs(grid,row,col-1);

        return area;
    }

}
