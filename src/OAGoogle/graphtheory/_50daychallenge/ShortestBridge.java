package OAGoogle.graphtheory._50daychallenge;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    // index 0 is right, index 1 is bottom, index 2 is left, and index 3 is top
    static final int[] directions = {0,1,0,-1};

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };
        // System.out.println(shortestPath(grid));

        System.out.println(minFlips(grid));
    }


    static final int [][] DIRECTIONS = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };


    static int minFlips (int [][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean[n][m];

        // find the first island and mark it as visited ...
        int [] firstIsland = findFirstIsland(grid,visited,n,m);

        // now use BFS to find first island boundary

        int boundarySize = findBoundary(grid,visited,firstIsland[0],firstIsland[1],n,m);

        // similrly use BFS to find second island

        int secondIslandBoundary = findSecondIslandBoundary(grid,visited,n,m);

        return secondIslandBoundary + boundarySize;
    }

    static int[] findFirstIsland(int[][] grid, boolean [][] visted, int n, int m) {
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visted[i][j] = true;
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    static int findBoundary(int[][] grid, boolean [][] visited, int startX, int startY, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        visited[startX][startX] = true;
        int boundarySize = 0;

        while (!queue.isEmpty()) {
            int [] current = queue.poll();

            int x = current[0];
            int y = current[1];
            boundarySize++;

            for (int [] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >=0 && newX < n && newY >= 0 && newY < m &&
                        !visited[newX][newY]) {
                    if (grid[newX][newY] == 1) {
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX,newY});
                    }
                }
            }
        }
        return boundarySize;
    }

    static int findSecondIslandBoundary(int[][] grid, boolean [][] visited, int n, int m) {
        for (int i=0; i < n; i++) {
            for (int j =0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return findBoundary(grid,visited,i,j,n,m); // we are going to reuse this since we have to do the same to find the boundary of second island (with 1 cell)
                }
            }
        }
        return 0;
    }

    static int shortestPath (int [][] grid) {
        int n = grid.length;
        int m =grid[0].length;

        // mark one group of 1s as 2s to distinguish
        Queue<int []> queue  = new LinkedList<>();
        boolean found = false;

        for (int i=0; i < m;  ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    markGirdTwo(grid,i,j,queue);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        // now expand the borders or check the neighbours

        int steps = 0;
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; --sz) {
                final int[] current = queue.poll();
                for (int k=0; k < 4; ++k) {
                    final int x = current[0] + directions[k];
                    final int y = current[1] + directions[k];

                    if (x < 0 || x == n || y <0 || y == m) {
                        continue;
                    }
                    if (grid[x][y] == 2) {
                        continue;
                    }
                    if  (grid[x][y] == 1) return steps;
                    grid[x][y] = 2;
                    queue.add(new int[] {x,y});
                }
            }
            ++steps;
        }
        return -1;
    }

    static void markGirdTwo(int[][] grid,int i, int j, Queue<int[]> queue) {
        if (grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2; // this will mark it as island 2
        queue.add(new int[] {i,j});
        // iterate directions
        for (int k =0; k < 4; ++k) {
            final int x = i + directions[k];
            final int y = j + directions[k];

            if (x < 0 || x == grid.length || y <0 || y == grid[0].length) {
                continue;
            }

            if (grid[x][y] == 1) {
                continue;
            }
            markGirdTwo(grid,x,y,queue);
        }
    }
}
