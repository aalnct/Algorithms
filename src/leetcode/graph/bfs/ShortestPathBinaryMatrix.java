package leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
        int [] [] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    private static int shortestPathBinaryMatrix(int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1) {
            return -1; // path is blocked, so cannot reach to destination
        }

        // 8 sides (including diagonal)
        int [][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == rows-1 && y == cols-1) {
                    return steps; // reached destination
                }

                for (int[] direction : directions) {
                    int newX = direction[0] + x;
                    int newY = direction[1] + y;

                    if (newX >=0 && newX < rows && newY >=0 && newY < cols
                            && grid[newX][newY] == 0) {
                        queue.offer(new int[] {newX,newY});
                        grid[newX][newY] = 1;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
