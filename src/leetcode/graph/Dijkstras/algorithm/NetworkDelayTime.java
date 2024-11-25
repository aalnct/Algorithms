package leetcode.graph.Dijkstras.algorithm;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int [] [] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }

    // n number of node
    // k source/starting node
    // time - > [u,v,w] , u (source), v(destination), w (total time taken)
    private static int networkDelayTime(int [] [] times, int n, int k) {
        int maxTime = 0;

        List<int[]>[] graph = new ArrayList[n+1];

        // we are creating graph here ...
        for (int i=1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int [] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u].add(new int[] {v,w});
        }

        // initialize the distance array (initially all with infinity but source)
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0; // source node will be 0

        // with sorting
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> distance[a]));

        priorityQueue.offer(k);

        // now we will run loop using Dijkstra's algorithm
        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll();
            for (int [] edge : graph[current]) {
                int v = edge[0]; // neighbour
                int w = edge[1]; // time to travel to node v

                if (distance[current] + w < distance[v]) {
                    distance[v] = distance[current] + w; // update the time if smaller
                    priorityQueue.offer(v); // now we will explore the neighbors
                }
            }
        }

        // to check if any node is still unreachable by checking if their distance is still infinity

        for (int i=1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }

        // else return the max time
        for (int i=1; i <= n; i++) {
            maxTime = Math.max(maxTime, distance[i]);
        }

        return maxTime;
    }
}
