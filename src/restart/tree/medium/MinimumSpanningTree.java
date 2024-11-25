package restart.tree.medium;

import java.util.Arrays;

/**
 * Finding minimum spanning tree using Prime algorithm
 */
public class MinimumSpanningTree {

    static final int V = 5; // number of vertices

    public static void main(String[] args) {

        int graph[][] = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        minimumSpanningTree(graph);
    }


    static void minimumSpanningTree (int [][] graph) {

        // one parent vector
        // one boolean set vector
        // one to maintain the current key

        int [] key = new int[V];
        int [] parent = new int[V];
        boolean [] visited = new boolean[V];

        Arrays.fill(key,Integer.MAX_VALUE);
        key[0] = 0; // since we need a source to start
        parent[0] = -1; // first node is always the root, so it cannot have a parent node ....


        for (int count = 0; count < V-1; count++) {
            int u = findMinMST(key,visited);
            visited[u] = true;

            for (int v=0; v < V; v++) {
                if (graph[u][v] != 0
                && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent,graph);
    }

    private static void printMST (int [] parent, int [][] graph) {
        System.out.println(" Edge \t weight");
        for (int i=1; i < V; i++) {
            System.out.println(
                    parent[i] + "  - "+ i + "\t" + graph[i][parent[i]]
            );
        }
    }

    static int findMinMST (int [] key, boolean [] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v=0; v < V; v++) {
            if (!visited[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }



}
