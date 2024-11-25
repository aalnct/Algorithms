package leetcode.graph.bfs;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // If the start or end is blocked, there is no path.
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == rows - 1 && y == cols - 1) {
                    return steps; // Reached the destination.
                }

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 0) {
                        queue.offer(new int[]{newX, newY});
                        grid[newX][newY] = 1; // Mark as visited.
                    }
                }
            }

            steps++;
        }

        return -1; // No path found.
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        ShortestPathInBinaryMatrix solution = new ShortestPathInBinaryMatrix();
        int shortestPath = solution.shortestPathBinaryMatrix(grid);
        System.out.println("Shortest path length: " + shortestPath);
    }
}
