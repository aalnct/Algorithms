package OAGoogle.graphtheory._50daychallenge;

public class NumberOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println(numberOfClosedIslands(grid));
    }

    // 0 means lands ...
    // 1 means water ...
    static int numberOfClosedIslands (int [][] grid) {
        int numberOfClosedIslands = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {

                if (grid[i][j] == 0 &&
                                isClosed(grid,i,j,rows,cols)) {
                    numberOfClosedIslands++;
                }

            }
        }
        return numberOfClosedIslands;
    }

    static boolean isClosed(int [][] grid, int row, int col, int rows, int cols) {

        if (row <0 || row >= rows || col <0 || col >= cols) {
            return false;
        }

        if (grid[row][col] == 1) { // if water ...
            return true;
        }

        // marking node as visited ...
        grid[row][col] = 1;

        boolean isClosed = true;

        isClosed &= isClosed(grid,row+1,col,rows,cols);
        isClosed &= isClosed(grid,row-1,col,rows,cols);
        isClosed &= isClosed(grid,row,col+1,rows,cols);
        isClosed &= isClosed(grid,row,col-1,rows,cols);

        return isClosed;
    }
}
