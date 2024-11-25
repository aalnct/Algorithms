package leetcode.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeState {
    public static void main(String[] args) {
        int [][] graph = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        eventualSafeNodes(graph).forEach(System.out::println);
    }

    private static List<Integer> eventualSafeNodes(int [][] graph) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> reversed = new ArrayList<>();
        int n = graph.length;

        for (int i=0; i < n; i++){
            reversed.add(new ArrayList<>());
        }

        int [] outDegrees = new int[n];

        for (int i=0; i < n; i++) {
            for(int neighbor : graph[i]) {
                reversed.get(neighbor).add(i); // reversing the original graph
                outDegrees[i]++;
            }
        }

        // initialize queue adding nodes with outdegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < n; i++) {
            if(outDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // perform BFS
        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // reduce out degree of neighbors and enqueue if out-degree becomes 0
            for(int neighbor : reversed.get(node)) {
                outDegrees[neighbor]--;
                if(outDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        result.sort(null);
        return result;
    }
}
