package restart.graph.medium;

import java.util.*;

public class MaxComponentWeight {

    public static void main(String[] args) {
        int numNodes = 5;
        int [] weight = {10, 20, 30, 40, 50};

        Map<Integer,List<Integer>> graph = new HashMap<>();
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(1);
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(0);
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(2);
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(1);
        // Component 2
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(4);
        graph.computeIfAbsent(4, k -> new ArrayList<>()).add(3);

        System.out.println(maxWeightComponent(graph,weight,numNodes));
    }

    private static int bfs (int currNode, Map<Integer, List<Integer>> graph, int[] weights,boolean [] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currNode);
        visited[currNode] = true;

        int totalWeight = 0;
        while (!queue.isEmpty()) {
            int node  = queue.poll();
            totalWeight +=weights[node];

            for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return totalWeight;
    }

    static int maxWeightComponent (Map<Integer, List<Integer>> graph, int [] weights, int numNodes) {
        boolean [] visted = new boolean[numNodes];
        int maxWeight = 0;

        for (int i=0; i< numNodes; i++) {
            if (!visted[i]) {
                int componentWeight = bfs(i,graph,weights,visted);
                maxWeight = Math.max(maxWeight,componentWeight);
            }
        }
        return maxWeight;
    }
}
