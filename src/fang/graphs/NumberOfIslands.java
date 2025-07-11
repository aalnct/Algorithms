package fang.graphs;

public class NumberOfIslands {

    // using DFS

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numberOfIslands(grid1));
    }

    static int numberOfIslands (char [][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int numberOfIslands = 0;

        for (int i=0;  i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (matrix[i][j] == '1') { // 1 is island, 0 is water
                    numberOfIslands++;
                    dfs(matrix,i,j);
                }
            }
        }

        return numberOfIslands;
    }

    static void dfs (char[][] matrix, int i, int j) {

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
        || matrix[i][j] == 0) {
            return;
        }

        matrix[i][j] = 0; // so that we don't visit this again

        dfs(matrix, i+1, j);
        dfs(matrix,i-1,j);
        dfs(matrix,i, j+1);
        dfs(matrix,i,j-1);
    }
}
