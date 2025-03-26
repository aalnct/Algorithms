package restart.graph.again.graphtheory.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestBridge {

    public static void main(String[] args) {
        int [][] grid = {
                {0,1},
                {1,0}
        };
        System.out.println(shortestBridge(grid));
    }

    static int [][] DIRECTIONS = {
            {1,0},{-1,0},{0,1},{0,-1}
    };

    static int shortestBridge (int [] [] grid) {
        // using DFS and BFS approach
        int n = grid.length;

        boolean foundIsland = false;
        boolean [][] visited = new boolean[n][n];

        Queue<int []> queue = new LinkedList<>();

        for (int i=0; i <n && !foundIsland; i++) {
            for (int j=0; j < n && !foundIsland; j++) {
                if (grid[i][j] == 1) {
                    markIsland(grid, i, j, queue, visited);
                    foundIsland = true;
                    break;
                }
            }
        }
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                int [] current = queue.poll();
                for (int [] dir : DIRECTIONS) {
                    int r = dir[0] + current[0];
                    int c = dir[1] + current[1];

                    if (r >= 0 && r < n && c >=0 && c < n && !visited[r][c]) {
                        if (grid[r][c] == 1) {
                            return distance;
                        }
                        visited[r][c] = true;
                        queue.offer(new int [] {r,c});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    static void markIsland (int [][] grid, int start, int end, Queue<int []> queue, boolean [][] visited) {
        int n = grid.length;
        visited[start][end] = true;

        Stack<int []> stack = new Stack<>();
        stack.add(new int [] {start,end});
        queue.offer(new int [] {start,end});

        while (!stack.isEmpty()) {
            int [] current = stack.pop();

            for (int [] dir : DIRECTIONS) {
                int r = dir [0] + current[0];
                int c = dir[1] + current[1];

                if (r >=0 && r < n && c >=0 && c < n && !visited[r][c]
                && grid[r][c] == 1) {
                    stack.push(new int [] {r,c});
                    queue.offer(new int [] {r,c});
                    visited[r][c] = true;
                }
            }
        }
    }
}
