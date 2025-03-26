package restart.graph.again.graphtheory.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public static void main(String[] args) {
        int [][] graph = {
                {1,2},
                {0,3},
                {0,3},
                {1,2}
        };

        System.out.println(isBipartite(graph));
    }

    // dividing graph into two subsets
    // such that no adjacent vertices in subset are same
    // example subset A and B

    // question statement ::
        // Given an undirected graph, determine if it is bipartite (can be colored using exactly two colors
        // such that no adjacent vertices share the same color).

    static boolean isBipartite (int [][] graph) {
        int n = graph.length;
        int [] colors = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i < n; i++) {
            System.out.print(" " + colors[i]);
            if (colors[i] != 0) {
                continue; // skip if not uncolored
            }
            queue.offer(i);
            colors[i] = 1; // color A

            while (!queue.isEmpty()) {
                Integer curr = queue.poll();

                // check its neighbours
                for (int nei : graph[curr]) {
                    if (colors[nei] == 0) {
                        colors[nei] = -colors[curr];
                        queue.offer(nei);
                    } else if (colors[nei] == colors[curr]) {
                        return false; // not a bipartite
                    }
                }
            }
        }
        return true;
    }
}
