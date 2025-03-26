package restart.graph.medium;

import java.util.*;

class NodeInfo {
    int node;
    int cumWeight;

    public NodeInfo (int node, int cumWeight) {
        this.node = node;
        this.cumWeight = cumWeight;
    }
}

public class TotalWeightSourceToDestination {

    public static void main(String[] args) {
        int numNodes = 5;
        int [] weights = {10, 20, 30, 40, 50};

        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Edge: 0 - 1
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(1);
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(0);

        // Edge: 1 - 2
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(2);
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(1);

        // Edge: 1 - 3
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(3);
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(1);

        // Edge: 3 - 4
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(4);
        graph.computeIfAbsent(4, k -> new ArrayList<>()).add(3);

        System.out.println(totalWeightSourceToDestination(graph, weights, 0, 4, numNodes));
    }

    static int totalWeightSourceToDestination (
            Map<Integer, List<Integer>> graph,
            int [] weight,
            int source,
            int destination,
            int numNodes
    ) {

        boolean [] visited = new boolean[numNodes];
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(source,weight[source]));
        visited[source] = true;

        while (!queue.isEmpty()) {
            NodeInfo nodeInfo = queue.poll();
            int currNode = nodeInfo.node;
            int currWeight = nodeInfo.cumWeight;

            if (currNode == destination) {
                return currWeight;
            }

            for (int neighbour : graph.getOrDefault(currNode,new ArrayList<>())) {
                if (!visited[neighbour]) {
                    queue.offer(new NodeInfo(neighbour, currWeight + weight[neighbour]));
                }
            }
        }
        return -1;
    }
}
