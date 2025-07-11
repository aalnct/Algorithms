package fang.graphs;

import java.util.*;

/**
 *  Find minimum time for all nodes to receive signals
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int k = 2;
        int n = 4;

        System.out.println(findMinimumTime(times,n,k));
    }


    // variable definition

    // V = n (number of vertices/nodes)
    // E = times.length (number of edges)

    static int findMinimumTime (int [][] times, int n, int k) {
        int maxTime = 0;

        // n = total nodes
        // k = starting nodes

        List<List<int []>> graph = new ArrayList<>();

        for (int i=0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] time : times) { // E iterations :: Graph Constructions O(E)
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new int [] {v,w}); // O(1) operation : adding into list ...
            // loop through all edges once : O(E)
        }

        // initialize arrays : O(V)

        int [] distances = new int[n+1];

        Arrays.fill(distances,Integer.MAX_VALUE); // O(V)

        distances[k] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int [] {k,0}); // starting node distance is 0

        boolean [] visited = new boolean[n + 1];  // O(V)


        // Priority Queue operations :: O(V log V)
        while (!pq.isEmpty()) {
            int [] current = pq.poll(); // O(log V)
            int node = current[0];
            int dist = current[1];

            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            for (int [] nei : graph.get(node)) {
                int nextNode = nei[0];
                int weight = nei[1];

                if (distances[node] + weight < distances[nextNode]) {
                    distances[nextNode] = distances[node] + weight;
                    pq.offer(new int [] {nextNode,distances[nextNode]});
                }
            }
        }

        for (int i=1; i <=n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime,distances[i]);
        }
        return maxTime;
    }
}
