package leetcode.graph.Dijkstras.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindCheapestRoute {

    public static void main(String[] args) {
        int [][] flight = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        int source = 0;
        int destination = 3;
        int k = 1;
        int n = 4;

        System.out.println(findCheapestRoute(n,flight,source,destination,k));
    }

    // n - total number of nodes
    // flights -- will have source, dest, and cost
    // source -- starting point of flight
    // destination -- reaching point
    // k -- total stops
    private static int findCheapestRoute(int n, int [][] flights, int source, int destination, int k) {

        Map<Integer, Map<Integer,Integer>> graph = new HashMap<>();
        for (int [] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            graph.computeIfAbsent(from, keySet -> new HashMap<>()).put(to, cost);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        priorityQueue.offer(new int[] {0,source,k+1});

        while (!priorityQueue.isEmpty()) {
            int [] info = priorityQueue.poll();

            int cost = info[0];
            int node = info[1];
            int stops = info[2];

            if (node == destination) {
                return cost;
            }

            if (stops == 0) {
                continue;
            }

            if (stops > 0) {

                for (int neighboring : graph.getOrDefault(node, new HashMap<>()).keySet()) {
                    int newCost = cost + graph.get(node).get(neighboring);
                    priorityQueue.offer(new int[] {newCost,neighboring,stops-1});
                }
            }
        }

        return -1;
    }
}
