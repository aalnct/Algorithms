package restart.graph.medium;

import java.util.Arrays;

public class MultipleStageGraph {

    public static void main(String[] args) {
        int[][] graph = {
                {INF, 1, 2, INF, INF, INF, INF, INF},
                {INF, INF, INF, 3, 2, INF, INF, INF},
                {INF, INF, INF, INF, 4, 3, INF, INF},
                {INF, INF, INF, INF, INF, INF, 6, INF},
                {INF, INF, INF, INF, INF, INF, 1, 3},
                {INF, INF, INF, INF, INF, INF, INF, 2},
                {INF, INF, INF, INF, INF, INF, INF, INF},
                {INF, INF, INF, INF, INF, INF, INF, INF}
        };
        int stages = 4;
        shortestPath(graph, stages);
    }

    private static final int INF = Integer.MAX_VALUE;

    private static int shortestPath (int [][] graph, int stages) {
        int n = graph.length;
        // to store cost
        int [] cost = new int[n];
        // to store path
        int [] path = new int[n];

        // Will initialize cost array with Infinite values
        Arrays.fill(cost,INF);

        // destination node cost is 0 (to reach to itself)
        cost[n-1] = 0;

        for (int i = n-2; i >= 0; i--) {
            // this loop is for next node
            for (int j = i+1; j < n; j++) {
                // since the next node is i+1
                if (graph[i][j] != INF && cost[j] != INF) {
                    int newCost = graph[i][j] + cost[j];
                    if (newCost < cost[i]) {
                        cost[i] = newCost; // if existing cost at current node is more than newCost
                        path[i] = j; // and we will take that with minimum cost
                    }
                }
            }
        }

        // printing the shortest path
        System.out.println("Shortest Path Cost :" + cost[0]);
        System.out.println("Path :" + 0);
        int next = path[0];
        while (next != 0) {
            System.out.println(" -> " + next);
            next = path[next];
        }

        return cost[0];
    }
}
