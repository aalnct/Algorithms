package OAGoogle;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPathToGetFood {


    public static void main(String[] args) {
        int[][] grid = {
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', '0', '0', '0', 'X'},
                {'X', '0', 'O', '#', '0', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };
        System.out.println(getFood(grid));
    }

    private static int getFood (int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // define directions to move up, down,left,right
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // find the starting position i.e. '*'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[] {i,j});
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int steps = 0; // when food is encountered, return the steps
        while (!queue.isEmpty()) {
            int size = queue.size();

            // process all nodes at the current level
            for (int i=0; i < size; i++) {
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // if current cell is having food
                if (grid[x][y] == '#') {
                    return steps;
                }

                // explore all possible directions
                for (int d=0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // check if the new position is valid
                    // and not visited

                    if (nx >= 0 && nx < rows
                            && ny >=0 && ny < cols && grid[nx][ny] != 'X' && !visited[nx][ny]) {
                        queue.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
