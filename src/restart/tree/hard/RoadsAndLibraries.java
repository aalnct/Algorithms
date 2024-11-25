package restart.tree.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RoadsAndLibraries {

    static class Edge implements Comparable<Edge> {

        int dest;
        int weight;

        public Edge (int dest, int weight) {
            this.dest =dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static long findMinCost (int n, int c_roads, int c_lib, List<List<Integer>> cities) {

        if (c_lib <= c_roads) {
            return (long) n * c_lib;
        }

        List<List<Edge>> adjacencyList = new ArrayList<>(); // building adjacency list

        for (int i=0; i<=n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (List<Integer> road : cities) {
            int u = road.get(0);
            int v = road.get(1);

            adjacencyList.get(u).add(new Edge(v, c_roads)); // from point A to point B
            adjacencyList.get(v).add(new Edge(u,c_roads)); // from point B to point A
        }

        boolean [] visited = new boolean[n+1];
        long totalCost = 0;

        for (int i=1; i <= n; i++) {
            totalCost += prims(i, adjacencyList, visited, c_lib);
        }

        return totalCost;
    }

    private static long prims (int start, List<List<Edge>> adjacencyList, boolean [] visited, int c_lib) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(start,0)); // cost/weight associated with the starting point is always 0
        boolean isFirstNode = true;
        long cost = 0;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int u = edge.dest; // where to go ...

            if (visited[u]) {
                continue;
            }

            visited[u] = true;


            if (isFirstNode) {
                cost += c_lib;
                isFirstNode = false;
            } else {
                cost +=edge.weight;
            }

            for (Edge neighbour : adjacencyList.get(u)) {
                if (!visited[neighbour.dest]) {
                    priorityQueue.offer(neighbour);
                }
            }
        }
        return cost;
    }
}
