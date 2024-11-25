package leetcode.graph.dfs;

import java.util.*;

public class PathExists {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int [][] edges = {
                {0,1},
                {1,2},
                {2,0}
        };
        int source = 0;
        int destination = 2;
        int n = 3;

        System.out.println(isValidPath(n,edges,source,destination));
    }

    /**
     * first creating an adjacency list to maintain the list of neighbours
     */

    private static boolean isValidPath(int n, int [][] edges, int start, int end) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i=0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int [] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(start);
        boolean[] seen = new boolean[n];
        Arrays.fill(seen,false);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (node == end) {
                return true;
            }

            if (seen[node] == true) {
                continue;
            }
            seen[node] = true;

            for (int neighbours : adjacencyList.get(node)) {
                stack.push(neighbours);
            }
        }
        return false;
    }
}
