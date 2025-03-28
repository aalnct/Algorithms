package neetcode150.graphs;

public class NumberOfIslandsDFS {

    public static void main(String[] args) {
        char  [][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numberOfIslandsDFS(grid));
    }


    // DFS approach
    static int numberOfIslandsDFS (char [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    static void dfs (char [][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col]  = '0'; // marking this as visited, so we do not have to visit it again

        dfs (grid, row+1, col);
        dfs (grid, row - 1, col);
        dfs (grid, row, col + 1);
        dfs (grid, row, col - 1);

    }
}
