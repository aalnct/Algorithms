package leetcode.graph.bfs;

import java.util.*;

public class PathExists {

    public static void main(String[] args) {
        int [][] edges = {
                {0,7},
                {0,8},
                {6,1},
                {2,0},
                {0,4},
                {5,8},
                {4,7},
                {1,3},
                {3,5},
                {6,5}
        };
        int n = 10;
        int source = 7;
        int destination = 5;

        System.out.println(pathExists(n,edges,source,destination));
        System.out.println(pathExists_2(edges,n,source,destination));
        System.out.println(isPathExists(edges,source,destination));
        System.out.println(isPathExists_2(n,edges,source,destination));

    }

    private static boolean pathExists(int n, int [][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        Queue<Integer>[] graph = new LinkedList[n];
        for (int i=0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int [] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].offer(to);
        }

        boolean [] visited = new boolean[n];
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            source = queue.poll();

            for (int neighbour : graph[source]) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;

                    if (neighbour == destination) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static boolean pathExists_2(int[][] edges, int n, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }

            List<Integer> neighbors = graph.get(current);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return false;
    }

    public static boolean isPathExists(int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }

            List<Integer> neighbors = graph.get(current);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Leet code solution since i am getting false for the output
     */

    private static boolean isPathExists_2(int n, int [][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i=0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int [] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean [] visited = new boolean[n];
        Arrays.fill(visited,false);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }

            // add all neighbours to stack
            for (int neighbour : adjacencyList.get(current)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return false;
    }
}
