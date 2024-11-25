package restart.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiStageGraph_2 {

    public static void main(String[] args) {
        int [][] graph = {
                {0, 1, 2},
                {0, 2, 4},
                {1, 2, 1},
                {1, 3, 7},
                {2, 4, 3},
                {3, 4, 1}
        };
        int n = 5;
        System.out.println(minimumCostPath(n,graph));

    }

    private static int minimumCostPath (int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i=0; i < n; i++) { // n is number of stages
            graph.add(new ArrayList<>());
        }

        // establish a path in graph using edges 2D array
        for (int [] edge : edges) {
            graph.get(edge[0]).add(new int[] {edge[1],edge[2]});
        }

        // now we need a cost array, that will keep track of cost from one node to another
        int [] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE); // make sure to populate this, else cost will always be 0 and will never be updated
        cost[0] = 0; // cost from source to source will be 0

        for (int i=0; i < n; i++) {
            for (int [] edge : graph.get(i)) {
                int nextNode = edge[0]; // to which we are going to
                int weight = edge[1];  // how much that will cost
                if (cost[i] != Integer.MAX_VALUE && cost[i] + weight < cost[nextNode]) {
                    cost[nextNode] = cost[i] + weight;
                }
            }
        }
        return cost[n-1];
    }
}
