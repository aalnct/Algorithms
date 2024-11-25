package restart.gemini.graph;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times,4,2));
    }

    // n - number of nodes
    // k - starting node
    static int networkDelayTime (int [][] times, int n, int k) {

        // adjacency matrix/graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int [] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            // create graph
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(new int [] {v,w});
        }

        // create a priority queue
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.offer(new int [] {k,0}); // k is starting node, and distance to that node is 0

        // creating a distance dictionary
        Map<Integer,Integer> distance = new HashMap<>();

        while (!minHeap.isEmpty()) {
            int [] current = minHeap.poll();

            int node = current[0];
            int currentDistance = current[1];

            // that means node is already visited ...
            if (distance.containsKey(node)) {
                continue;
            }

            distance.put(node,currentDistance);

            // now explore neighbour
            if (graph.containsKey(node)) {
                for (int [] neighbour : graph.get(node)) {
                    int nextNode = neighbour[0];
                    int weight = neighbour[1];

                    if (!distance.containsKey(nextNode)) {
                        minHeap.offer(new int [] {nextNode, currentDistance + weight});
                    }
                }
            }
        }

        // means never reached the destination node
        if (distance.size() != n) {
            return -1;
        }

        int maxTime = 0;
        for (int time : distance.values()) {
            maxTime = Math.max(maxTime,time);
        }

        return maxTime;
    }
}
