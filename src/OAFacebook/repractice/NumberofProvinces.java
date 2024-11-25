package OAFacebook.repractice;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofProvinces {

    public static void main(String[] args) {
        int [][] isConnected =
                {
                        {1,1,0},
                        {1,1,0},
                        {0,0,1}
                };
        System.out.println(numberOfProvinces(isConnected));
    }

    static int numberOfProvinces (int [][] isConnected) {
        int province = 0;
        int length = isConnected.length;
        // visited array to check if city is already visited
        boolean [] visited = new boolean[length];

        // visit all cities one by one ...
        for (int i=0; i < length; i++) {
            // if not visited , then visit else skip
            if (!visited[i]) {
                visitAndCount(isConnected,visited,i);
                province++;
            }
        }

        return province;
    }

    static void visitAndCount (int[][] isConnected, boolean [] visited, int startCity) {
        visited[startCity] = true;
        // we will use queue and add start city in it, and then use it to
        // traverse the neighbours of it
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
                if (isConnected[current][neighbour] == 1 && !visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }

        }
    }
}
