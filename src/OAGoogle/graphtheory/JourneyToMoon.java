package OAGoogle.graphtheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JourneyToMoon {

    public static void main(String[] args) {

    }

    static int journeyToMoon (int n, int[][] astronautPairs) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i=0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int [] pair : astronautPairs) {
            int ast1 = pair[0];
            int ast2 = pair[1];

            graph[ast1].add(ast2);
            graph[ast2].add(ast1);
        }
        boolean[] visited = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (!visited[n]) {
                int component = bfs(graph,visited,i);
            }
        }


        return 0;
    }

    static int bfs(List<Integer>[] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbour : graph[node]) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                    size++;
                }
            }
        }
        return size;
    }
}
