package hackerrank.medium.graph;

import java.util.*;

public class RoadAndCities {

    public static void main(String[] args) {
        int n = 3;
        int c_lib = 2;
        int c_road = 1;
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(Arrays.asList(1, 2));
        cities.add(Arrays.asList(3, 1));
        cities.add(Arrays.asList(2, 3));

        System.out.println(roadsAndLibraries(n,c_lib,c_road,cities));
    }

    private static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        if (c_lib <= c_road) {
            return (long) c_lib * n;
        }
        long totalCost = 0;

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(List<Integer> roads : cities) {
            int u = roads.get(0) - 1;
            int v = roads.get(1) - 1;

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean [] visited = new boolean[n+1];

        for (int i=0; i <= n; i++) {
            if (!visited[i]) {
                totalCost += c_lib + bfs(i,visited, adjList, c_road);
            }
        }
        return totalCost;
    }

    private static int bfs(int currentCity, boolean [] visited, List<List<Integer>> adjList, int c_road) {
        int connectedComponent = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentCity);
        visited[currentCity] = true;

        while (!queue.isEmpty()) {
            int start = queue.poll();

            for (int neighbor : adjList.get(start)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    connectedComponent++;
                }
            }
        }
        return (connectedComponent-1) * c_road;
    }

}
