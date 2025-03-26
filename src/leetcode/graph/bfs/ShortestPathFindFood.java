package leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFindFood {

    public static void main(String[] args) {
        int [][] grid = {
                {'X','X','X','X','X','X'},
                {'X','*','0','0','0','X'},
                {'X','0','0','#','0','X'},
                {'X','X','X','X','X','X'}
        };

        System.out.println(shortestPathFindFood(grid));
    }

    static int shortestPathFindFood (int [][] grid) {
        int steps = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};

        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited = new boolean[rows][cols];

        for (int i=0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int [] {i,j});
                    visited[i][j] = true;
                    break;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                int [] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                if (grid[x][y] == '#') {
                    return steps;
                }
                // explore neighbours
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < rows && ny >=0 && ny < cols && grid[nx][ny] != 'X' && !visited[nx][ny]) {
                        queue.offer(new int [] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
