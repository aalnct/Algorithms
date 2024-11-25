package restart.graph.easy;

import java.util.Arrays;

public class FloydWarshallAlgorithm {

    public static void main(String[] args) {
        int n = 5;
        int [][] edges = {
                {1,2,2},
                {1,3,4},
                {2,3,1},
                {2,4,7},
                {3,5,3},
                {4,5,1}
        };
        int [][] result = shortestDistance(n,edges);
        for (int [] _r : result) {
            for (int _r1 : _r) {
                System.out.println(_r1);
            }
        }
        // System.out.println(Arrays.toString(shortestDistance(n,edges)));
    }

    static int [][] shortestDistance (int n, int [][] edges) {
        int [][] distance = new int[n][n];

        for (int i=0; i < n; i++) {
            Arrays.fill(
                    distance[i],Integer.MAX_VALUE
            );
        }

        for (int [] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];

            distance[u][v] = w;
        }

        // k is the median node b/w i and j
        for (int k = 0; k < n; k++) {
            for (int i=0; i < n; i++) {
                for (int j=0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE &&
                    distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] =
                                Math.min(distance[i][j] , distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        return distance;
    }
}
