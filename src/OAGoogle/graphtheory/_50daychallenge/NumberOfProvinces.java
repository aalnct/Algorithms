package OAGoogle.graphtheory._50daychallenge;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int [][] isConnected = {
                {1,1,0}, // city 0
                {1,1,0}, // city 1
                {0,0,1} // city 2
        };

        System.out.println(findNumberOfProvinces(isConnected));
    }

    private static int findNumberOfProvinces (int [][] isConnected) {
        int province = 0;
        int length = isConnected.length;
        boolean [] visited = new boolean[length];

        for (int i=0; i<length; i++) { // --> iterate through all cities
            if (!visited[i]) { // --> if city is not visited, it is a new province
                province++;

                bfs(isConnected,visited,i); // --> we have to traverse from the current city to find all its neighbour
            }
        }

        return province;
    }

    private static void bfs(int[][] isConnected, boolean[] visited, int startCity) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        visited[startCity] = true; // --> marking current city as visited ....

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();

            for (int neighbour = 0; neighbour < isConnected.length; neighbour++) { // --> iterate through all cities to find connected cities from the current cities
                if (isConnected[currentCity][neighbour] == 1 && !visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

    }

}
