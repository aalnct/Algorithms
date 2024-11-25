package OAGoogle;

import java.util.*;

class Node implements Comparable<Node> {

    int node;
    int time;

    public Node (int node, int time) {
        this.node = node;
        this.time = time;
    }


    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.time,other.time);
    }
}
public class ShortestDistance {
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n,k));
    }

    private static int networkDelayTime(int [] [] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // creating an adjacency list ....
        for (int[] time : times){
            int source = time[0];
            int target = time[1];
            int travelTime = time[2];

            graph.putIfAbsent(source, new ArrayList<>());
            graph.get(source).add(new int[]{target,travelTime});
        }

        // initialize data structure
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k,0));
        Map<Integer,Integer> minTimeMap = new HashMap<>();

        // start the exploration loop
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int node = currentNode.node;
            int time = currentNode.time;

            // mark the current node as visited
            if (minTimeMap.containsKey(node)) {
                continue;
            }
            minTimeMap.put(node,time);

            // explore the neighbours of the current node ...
            if (graph.containsKey(node)) {
                for (int [] edge : graph.get(node)) {
                    int neighbour = edge[0];
                    int neighbourTime = edge[1];
                    // calculate the total distance to the neighbour and update the minimum time if needed
                    pq.add(new Node(neighbour, time + neighbourTime));
                }
            }
        }

        // terminate and final result ...
        if (minTimeMap.size() == n) {
            int maxTime = 0;

            for (int time : minTimeMap.values()) {
                maxTime = Math.max(maxTime,time);
            }

            return maxTime;
        } else {
            return -1;
        }
    }
}