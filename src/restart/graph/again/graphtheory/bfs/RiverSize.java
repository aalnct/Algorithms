package restart.graph.again.graphtheory.bfs;

import java.util.*;

public class RiverSize {

    public static void main(String[] args) {
        int [] [] grid = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        riverSizes(grid).forEach(System.out::println);
    }

    static List<Integer> riverSizes (int [][] grid) {
        List<Integer> result = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int [][] DIRECTIONS = {
                {1,0},{-1,0},{0,1},{0,-1}
        };

        boolean [][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();


        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = 0; // since once current loop is ended, we will reset the size so that new size can be calculated
                    queue.offer(new int [] {i,j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int [] current = queue.poll();
                        size++;

                        for (int [] dir : DIRECTIONS) {
                            int r = dir[0] + current[0];
                            int c = dir[1] + current[1];

                            if (r >=0 && r < rows && c >= 0 && c < cols
                            && !visited[r][c] && grid[r][c] == 1) {
                                visited[r][c] = true;
                                queue.offer(new int[] {r,c});
                            }
                        }
                    }
                    result.add(size);
                }
            }
        }
        return result;
    }
}
