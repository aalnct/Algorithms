package restart.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HackerLandShortestPath {

    public static void main(String[] args) {

    }

    static String sumOfMinDistance (int n, List<List<Integer>> roads) {
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i=0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (List<Integer> road : roads) {
            int u = road.get(0) - 1;
            int v = road.get(1) - 1;
            int weight = road.get(2);

            adjacencyList.get(u).add(new int [] {v,weight});
            adjacencyList.get(v).add(new int [] {u,weight});
        }

        int [][] dist = new int[n][n];

        for (int i=0; i <n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE); // since we need to find distance b/w every node
            dist[i][i] = 0; // distance to self is 0
        }

        // convert adjacency matrix to distance vector
        for (int i=0; i < n; i++) {
            for (int [] edge : adjacencyList.get(i)) {
                int v = edge[0];
                int weight = edge[1];
                dist[i][v] = weight;
            }
        }

        for (int k=0; k < n; k++) {
            for (int i=0; i <n; i++) {
                for (int j=0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE
                    && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] =
                                Math.min(dist[i][j],
                                        dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long totalSum = 0;
        for (int i=0; i < n; i++) {
            for (int j=i+1; j < n; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    totalSum +=dist[i][j];
                }
            }
        }

        return Long.toBinaryString(totalSum);
    }
}
