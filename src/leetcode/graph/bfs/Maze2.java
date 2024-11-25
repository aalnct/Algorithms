package leetcode.graph.bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Maze2 {

    public static void main(String[] args) {
        int [][] maze = {

                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}

        };

        int [] start = new int [] {0,0};
        int [] destination = new int [] {4,4};

        System.out.println(minimumDistance(maze,start,destination));
    }

    private static int minimumDistance(int [][] maze, int [] start, int [] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        int [][] distance = new int[rows][cols];
        for(int [] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // creating a priority queue and maintain the ordering based on the distance b/w two cells
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        priorityQueue.offer(new int[] {start[0], start[1], 0}); // start row, start col, distance

        int [][] directions = {
                {-1,0}, {1,0}, {0,-1},{0,1}
        };

        while(!priorityQueue.isEmpty()) {
            int [] current = priorityQueue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if (dist >= distance[row][col]) {
                continue;
            }

            distance[row][col] = dist;

            // now explore all directions
            for (int [] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                int steps = 0;

                // Roll till you hit a wall or reaches boundary
                while (newRow >= 0 && newRow < rows && newCol >= 0
                && newCol < cols && maze[newRow][newCol] == 0 ) {
                    newRow +=dir[0];
                    newCol +=dir[1];
                    steps++;
                }

                // add the new position into the priority queue
                priorityQueue.offer(new int[] {newRow, newCol, dist + steps});
            }
        }
        return distance[destination[0]][destination[1]] ==
                Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
