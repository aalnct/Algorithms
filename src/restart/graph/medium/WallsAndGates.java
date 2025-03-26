package restart.graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;

        int [] [] rooms = {
                {INF, -1,  0,  INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0,   -1, INF, INF}
        };

        System.out.println("Before running adjustment");
        printGrids(rooms);

        wallsAndGates(rooms);

        System.out.println("After running adjustment");
        printGrids(rooms);
    }

    static void wallsAndGates (int [][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        // since we are going to run multi source BFS, we have to use queue
        Queue<int []> queue = new LinkedList<>();

        // add all the gates into a queue
        for (int i=0; i < m ; i++) {
            for (int j=0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int [] {i,j});
                }
            }
        }

        // BFS traversal
        int [][] directions = {  {1,0} , {-1,0} , {0,1} , {0,-1} }; // can move into 4 directions (up,down,left,right)

        while (!queue.isEmpty()) {
            int [] cells = queue.poll();
            int r = cells[0];
            int c = cells[1];

            for (int [] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR <0 || newR >= m || newC < 0 || newC >= n ||
                rooms[newR][newC] != Integer.MAX_VALUE) {
                    continue;
                }

                rooms[newR][newC] = rooms[r][c] + 1;
                queue.offer(new int [] {newR, newC});
            }
        }
    }

    private static void printGrids (int [][] grid) {
        for (int [] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
