package OAGoogle.graphtheory._50daychallenge;

import java.util.*;

public class IncomingRoute {

    public static void main(String[] args) {
        int n = 5;
        int[][] connections = {
                {1, 0},
                {1, 2},
                {3, 2},
                {3, 4}
        };

        // System.out.println(incomingRoute(n,connections));
        System.out.println(minReorder(n,connections));
    }

    static int incomingRoute(int n, int [][] connections) {
        int count = 0;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            graph.get(from).add(to); // moving from city 'from' to 'to'
            graph.get(to).add(~from); // reversing the directions.... using bitwise operator

        }

        Set<Integer> isVisted = new HashSet<>();
        for (int i=1; i < n; i++) {
            isVisted.add(i); // adding all cities
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            isVisted.remove(currentCity);

            for (int neighbour : graph.get(currentCity)) {
                if (isVisted.contains(neighbour)) {
                    queue.offer(neighbour);
                    if (neighbour > 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static int minReorder(int n, int [][] connections) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int []  connection : connections) {
            int city1 = connection[0];
            int city2 = connection[1];

            graph.putIfAbsent(city1, new ArrayList<>());
            graph.get(city1).add(city2);
        }
            // initialize a queue to store the nodes that can be reached from city 0
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            // set a visited flag for each city
            int[] visited = new int[n];
            visited[0] = 1;

            while(!queue.isEmpty()) {
                int currentCity = queue.poll();

                for (int neighbour : graph.get(currentCity)) {
                    System.out.println(neighbour);
                    if (visited[neighbour] == 0) {
                        queue.add(neighbour); // if neighbour can be visited from city, add this to queue

                        // increment the number of edges that needs to be reordered
                        visited[neighbour] = visited[currentCity] + 1;
                    }
                }
            }
            return visited[n-1] -1;
    }
}
