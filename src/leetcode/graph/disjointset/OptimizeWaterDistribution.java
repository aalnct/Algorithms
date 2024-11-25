package leetcode.graph.disjointset;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edges {
    int to;
    int cost;

    public Edges(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class OptimizeWaterDistribution {

    public static void main(String[] args) {
        int n = 2;
        int [] wells = {1,1};
        int [][] pipes = {
                {1,2,1},
                {1,2,2}
        };

        System.out.println(minCostToSupplyWater(n,wells,pipes));

    }

    private static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int totalCost = 0;
        // adjacency list
        List<Edges> [] graph = new ArrayList[n+1];

        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        // create edges for wells
        for (int i=0; i < n; i++) {
            graph[0].add(new Edges(i + 1, wells[i]));
            graph[i + 1].add(new Edges(0, wells[i]));
        }

        // create edges for pipes
        for (int[] pipe : pipes) {

            int house1 = pipe[0];
            int house2 = pipe[1];
            int cost = pipe[2];

            graph[house1].add(new Edges(house2,cost));
            graph[house2].add(new Edges(house1,cost));
        }

        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edges> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e ->e.cost));
        priorityQueue.addAll(graph[0]);

        while (!priorityQueue.isEmpty()) {
            Edges edge = priorityQueue.poll();
            int to =edge.to;
            int cost = edge.cost;

            if (visited[to]) {
                continue;
            }
            visited[to] = true;
            totalCost +=cost;

            for (Edges nextEdges : graph[to]) {
                if (!visited[nextEdges.to]) {
                    priorityQueue.add(nextEdges);
                }
            }
        }

        return totalCost;
    }


}
