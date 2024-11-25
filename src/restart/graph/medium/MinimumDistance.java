package restart.graph.medium;

public class MinimumDistance {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                { 0,   5,  INF, 10 },
                { INF, 0,   3, INF },
                { INF, INF, 0,   1 },
                { INF, INF, INF, 0 }
        };
        minimumDistance(graph);
    }

    private static void minimumDistance (int [][] graph) {
        int v = graph.length;
        int [][] distance = new int[v][v];

        for (int i=0; i<v; i++) {
            for (int j=0;j<v;j++) {
                distance[i][j] = graph[i][j];
            }
        }

        for (int k=0; k < v; k++) {
            for (int i=0;i<v; i++) {
                for (int j=0; j<v;j++) {
                    if (distance[i][k] != INF && distance[k][j] != INF &&
                    distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        printSolution(distance);
    }

    private static void printSolution (int[][] distance) {
        int v = distance.length;
        for (int i=0; i < v; i++) {
            for (int j=0; j<v; j++) {
                if (distance[i][j] == INF) {
                    System.out.println("Distance is INF");
                } else {
                    System.out.println(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
