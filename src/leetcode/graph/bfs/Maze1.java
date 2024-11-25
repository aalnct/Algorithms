package leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Maze1 {

    public static void main(String[] args) {
        int [][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int [] start = {0,4};
        int [] destination = {4,4};

        System.out.println(hasPath(maze,start,destination));
    }

    public static boolean hasPath(int [][] maze, int [] start, int [] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[] [] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int [][] directions = {
                {-1,0}, // up
                {1,0}, // down
                {0,-1}, // left
                {0,1} // right
        };

        while(!queue.isEmpty()) {
            int [] current = queue.poll();

            if(current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }

            for(int [] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                while (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols
                && maze[newRow][newCol] == 0) {
                    // keep rolling
                    newRow +=dir[0];
                    newCol +=dir[1];
                }

                // back track to one row and column before hitting the wall
                newRow -=dir[0];
                newCol -=dir[1];

                if(!visited[newRow][newCol]) {
                    queue.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return false;
    }


}
