package OAOracle;


public class IslandPerimeter {

    public static void main(String[] args) {
        int [][] grid = {
                {1,0}
        };

        System.out.println(findIslandPerimeter(grid));
    }

    static int findIslandPerimeter(int [] [] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i =0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter +=bfs(grid,i,j);
                }
            }
        }
        return perimeter;
    }

    static int bfs (int[][] grid, int row, int col) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {
                {1,0},{-1,0},{0,1},{0,-1}
        };

        for (int [] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (newRow <0 || newRow >= rows || newCol <0 || newCol >= cols
            || grid[newRow][newCol] == 0) {
                perimeter++;
            }
        }
        return perimeter;
    }
}
