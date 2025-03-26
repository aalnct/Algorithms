package restart.graph.medium;

import java.util.*;

public class FindShortestDistanceAfterQueries {

    public static void main(String[] args) {
        int n = 5;
        int [] [] queries = {
                {2,4},
                {0,2},
                {0,4}
        };

        System.out.println(Arrays.toString(findShortest(n,queries)));
    }

    static int [] findShortest (int n, int [][] queries) {
        // creating adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i < n-1; i++) {
            graph.get(i).add(i+1);
        }

        int [] answer = new int[queries.length];

        for (int i=0; i < queries.length; i++) {
            int ui = queries[i][0];
            int vi = queries[i][1];

            graph.get(ui).add(vi);

            answer [i] = bfsCompute(graph,n);
        }

        return answer;
    }

    static int bfsCompute (List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean [] visited = new boolean[n];
        visited[0] = true;

        int [] distance = new int[n];
        distance[0] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                    distance[neighbour] = distance[current] + 1;

                    if (neighbour == n-1) {
                        return distance[neighbour];
                    }
                }
            }
        }
        return -1;
    }
}