package restart.graph.easy;

public class NumberOfIslandsDFS {

    public static void main(String[] args) {
        char [][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numberOfIslands(grid));
    }


    static int numberOfIslands (char [][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int numberOfIslands = 0;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return numberOfIslands;
    }

    static void dfs (char [][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        // up, down, left, right
        dfs(grid, i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

}
