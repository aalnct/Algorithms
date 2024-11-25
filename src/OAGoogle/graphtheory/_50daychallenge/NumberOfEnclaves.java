package OAGoogle.graphtheory._50daychallenge;

public class NumberOfEnclaves {

    public static void main(String[] args) {
        int [][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };

        System.out.println(numberOfEnclaves(grid));
    }

    static int numberOfEnclaves (int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                // if land cell and not connected to boundary ...
                if ( grid[i][j] == 1 && (i ==0 || i == rows-1 || j ==0 || j == cols-1)  ) {
                    dfs(grid,i,j);
                }
            }
        }

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        // if crossed the boundary ...
        if (row <0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0; // mark the node as visited ...

        // now call it recursively for each neighbour
        dfs(grid,row-1,col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid,row,col+1);
    }
}
