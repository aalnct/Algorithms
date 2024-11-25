package leetcode.graph.Dijkstras.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinEffort {

    public static void main(String[] args) {
        int [][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };

        System.out.println(pathWithMinEffort(heights));
    }

    private static int pathWithMinEffort(int [][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // sorting based on the distance
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a-> a[2]));

        boolean [][] visited = new boolean[rows][cols];

        priorityQueue.offer(new int [] {0,0,0});

        int [] distanceX = {-1,1,0,0};
        int [] distanceY = {0,0,-1,1};

        while (!priorityQueue.isEmpty()) {
            int [] current = priorityQueue.poll();
            int  row = current[0];
            int col = current[1];
            int currentCost = current[2];

            // if reached destination
            if (row == rows - 1 && col == cols-1) {
                return currentCost;
            }
            visited[row][col] = true;

            // explore neighbor
            for (int i=0; i < 4; i++) {
                int newRow = distanceX[i] + row;
                int newCol = distanceY[i] + col;

                if (newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    int updatedCost = Math.max(currentCost, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    priorityQueue.offer(new int[] {newRow,newCol, updatedCost});
                }
            }
        }
        return -1;
    }
}
