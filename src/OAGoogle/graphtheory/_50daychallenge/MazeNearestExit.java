package OAGoogle.graphtheory._50daychallenge;

import java.util.LinkedList;
import java.util.Queue;

public class MazeNearestExit {

    public static void main(String[] args) {
        char[][] maze = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'},
        };
        int [] entrance = {1,0}; // means we are standing here ...

        System.out.println(nearestExit(maze,entrance));

        // output = 1
        // expected output = 2
    }

    static int nearestExit (char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int [][]  directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        // the above 2 defines the entrance point ....
        // where m is the row and n is the column

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // mark it as visited ...

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                int[] currentCell = queue.poll();
                int row = currentCell[0];
                int col = currentCell[1];

                if ((row !=entrance[0] || col != entrance[1]) && (row ==0 || row == m-1 || col == 0 || col == n-1)) {
                    return steps; // we reached the border cell and hence reached exit
                }

                // explore the directions
                for (int[] direction : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow >=0 && newRow < m
                    && newCol >= 0  && newCol < n && maze[newRow][newCol] == '.') { // the last condition means that we are not at entrance since that cannot be counted
                        queue.offer(new int[] {newRow,newCol});
                        maze[newRow][newCol] = '.'; // now we have marked that as visited ....
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    static int nearestExit_2 (char [][] maze, int [] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] directions = new int [][] {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };

        maze[entrance[0]][entrance[1]] = '+'; // visited marked, since this is the entrance

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {entrance[0],entrance[1],0});

        while (!queue.isEmpty()) {
            int [] currentCell = queue.poll();

            int currRow = currentCell[0];
            int currCol = currentCell[1];
            int currDistance = currentCell[2]; // steps taken to reach here ...

            // explore directions
            for (int [] direction : directions) {
                int newRow = direction[0] + currRow;
                int newCol = direction[1] + currCol;

                // if there exists an unvisited empty neighbour

                if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols
                        && maze[newRow][newCol] == '.') {

                    // if empty cell is an exit, return currentDistance + 1

                    if (newRow == 0 || newRow == rows-1 || newCol == 0 || newCol == cols-1) {
                        return currDistance+1;
                    }
                    // else add this to queue and mark it as visted
                    maze[newRow][newCol] = '+';
                    queue.offer(new int[] {newRow,newCol, currDistance+1});
                }
            }
        }
        return -1;
    }
}
