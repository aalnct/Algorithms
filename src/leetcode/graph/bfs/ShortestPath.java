package leetcode.graph.bfs;

import java.util.*;

public class ShortestPath {

    private static Map<Integer, List<Integer>> adjacencyList = null;

    public static void main(String[] args) {
        int [][] edge = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        int a = 0;
        int b = 4;
        System.out.println(shortestPath(edge,a,b));
    }

    private static int shortestPath(int[][] graph, int a, int b) {
        adjacencyList = new HashMap<>();

        for (int i=0; i < graph.length; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int [] edge : graph) {

            int from = edge[0];
            int to = edge[1];

            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> distance = new HashMap<>();

        queue.offer(a); // source
        visited.add(a);
        distance.put(a,0);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == b  ) {
                return distance.get(currentNode);
            }

            for (int neighbour =0; neighbour < graph.length; neighbour++) {
                if (graph[currentNode][neighbour] == 1 && !visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                    distance.put(neighbour,distance.get(currentNode)+1);
                }
            }
        }
        return -1;
    }
}
