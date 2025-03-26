package restart.graph.again.graphtheory.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathMaze {

    public static void main(String[] args) {
        char [][] maze = {
                {'S', '0', '1', '0'},
                {'1', '0', '0', '0'},
                {'1', '1', '0', '1'},
                {'0', '0', '0', 'E'}
        };
        // shortest path is
        // (0,0), (0,1), (1,1), (1,2), (2,2), (3,2), (3,3) is valid
        System.out.println(totalStepsTaken(maze));
        System.out.println(shortestPathTaken(maze));
    }

    static int totalStepsTaken (char [][] maze) {

        int rows = maze.length;
        int cols = maze[0].length;

        boolean [] [] visited = new boolean[rows][cols];
        Queue<int []> queue = new LinkedList<>();

        int [] dr = {1,-1,0,0};
        int [] dc = {0,0,1,-1};

        int startRows = -1;
        int startCols = -1;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (maze[i][j] == 'S') {
                    startRows = i;
                    startCols = j;
                    break;
                }
            }
            if (startRows != -1) break;
        }

        queue.offer(new int [] {startRows,startCols,0});
        visited[startRows][startCols] = true;

        while (!queue.isEmpty()) {
            int [] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int distance = current[2];

            if (maze[r][c] == 'E') {
                return distance;
            }

            for (int i=0; i < 4; i++) {
                int newRow = r + dr[i];
                int newCol = c + dc[i];

                // check for the boundary conditions
                if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols
                && !visited[newRow][newCol] && maze[newRow][newCol] != 1) {
                    queue.offer(new int [] {newRow,newCol,distance+1});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }

    static List<int []> shortestPathTaken (char [][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean [][] visited = new boolean[rows][cols];

        int startRow = -1;
        int startCol = -1;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
            if (startRow != -1) {
                break;
            }
        }

        int [] dr = {1,-1,0,0};
        int [] dc = {0,0,1,-1};

        Queue<int []> queue = new LinkedList<>();

        int [][][] parent = new int[rows][cols][2];

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                parent [i][j] = new int[]{-1,-1};
            }
        }
        queue.offer(new int [] {startRow,startCol,0});
        visited[startRow][startCol] = true;

        int endRow = -1;
        int endCol = -1;
        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int [] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int distance = current[2];

            if (maze[r][c] == 'E') {
                found = true;
                endRow = r;
                endCol = c;
                break;
            }

            // boundary conditions start
            for (int i=0; i < 4; i++) {
                int newRow = r + dr[i];
                int newCol = c + dc[i];

                if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols
                        && !visited[newRow][newCol] && maze[newRow][newCol] != 1) {
                    queue.offer(new int [] {newRow,newCol, distance+1});
                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = new int [] {r,c}; // storing parent here to back track the path
                }
            }
        }

        if (found) {
            List<int []> path = new ArrayList<>();
            int r = endRow;
            int c = endCol;

            while (r != -1 && c != -1) {
                path.add(0, new int[]{r,c});
                int [] p = parent[r][c];
                r = p[0];
                c = p[1];
            }
            return path;
        }
        return new ArrayList<>();
    }
}
