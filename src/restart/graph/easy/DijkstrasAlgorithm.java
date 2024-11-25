package restart.graph.easy;

import java.util.*;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        int n = 5;
        int [][] edges = {
                {1,2,2},
                {1,3,4},
                {2,3,1},
                {2,4,7},
                {3,5,3},
                {4,5,1}
        };
        int source = 1;

        System.out.println(Arrays.toString(findShortestPath(n,edges,source)));
    }

    // find the shortest path from source to destination
    static int [] findShortestPath ( int n, int [][] edges , int source) {
        List<List <int []>> graph = new ArrayList<>();

        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] edge : edges) {
            int u = edge[0] - 1; // source node
            int v = edge[1] - 1; // destination node
            int w = edge[2]; // weight b/w edges

            graph.get(u).add(new int [] {v,w});
        }

        int [] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source-1] = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int [] {source-1, 0});

        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            int u =current[0];
            int currentDistance = current[1];

            if (currentDistance > distance[u]) continue;

            for (int [] neighbor : graph.get(u)) {
                int v = neighbor[0]; // next node
                int w = neighbor[1]; // weight

                if (w + distance[u] < distance[v]) {
                    distance[v] = w + distance[u];
                    pq.offer(new int[] {v, distance[v]});
                }
            }
        }


        for (int i=0; i < n; i ++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

}


