package leetcode.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * this is using Kruskal's algorithm
 */
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int [][] points = {
                {0,0},
                {2,2},
                {3,10},
                {5,2},
                {7,0}
        };

        System.out.println(minCostToConnectAllPoints(points));
    }

    private static int minCostToConnectAllPoints(int [][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for (int i=0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int distance = manhattanDistance(points[i], points[j]);
                edges.add(new int [] {i,j,distance});
            }
        }

        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));

        int totalCost = 0;
        int connectedComponents = 0;
        int [] parent = new int[n];

        for (int i=0; i < n; i++) {
            parent[i] = i;
        }

        for (int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            // this step is to find cycle
            if (union(parent, u,v)) {
                totalCost += cost;
                connectedComponents++;
                if (connectedComponents == n-1) {
                    break;
                }
            }
        }

        return totalCost;
    }

    private static boolean union (int [] parent, int u, int v) {
        int rootX = find(parent, u);
        int rootY = find(parent, v);

        if (rootX == rootY) {
            return false; // cycle found
        }

        parent[rootX] = rootY;
        return true;
    }

    private static int find(int [] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent,parent[x]);
    }

    private static int manhattanDistance(int[] a, int [] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
